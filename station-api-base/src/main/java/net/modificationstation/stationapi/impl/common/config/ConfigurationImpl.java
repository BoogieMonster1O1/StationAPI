package net.modificationstation.stationapi.impl.common.config;

import net.modificationstation.stationapi.api.common.config.Category;
import net.modificationstation.stationapi.api.common.config.Configuration;
import net.modificationstation.stationapi.api.common.factory.GeneralFactory;

import java.io.*;
import java.text.*;
import java.util.*;

public class ConfigurationImpl implements Configuration {

    private final File configFile;
    private final Set<net.modificationstation.stationapi.api.common.config.Category> categories = new TreeSet<>();

    private static final Map<File, ConfigurationImpl> CONFIGS = new HashMap<>();

    public static ConfigurationImpl of(File file) {
        return CONFIGS.computeIfAbsent(file, ConfigurationImpl::new);
    }

    private ConfigurationImpl(File configFile) {
        this.configFile = configFile;
    }

    @Override
    public net.modificationstation.stationapi.api.common.config.Category getCategory(String name) {
        for (net.modificationstation.stationapi.api.common.config.Category category : categories)
            if (name.equals(category.getName()))
                return category;
        net.modificationstation.stationapi.api.common.config.Category category = GeneralFactory.INSTANCE.newInst(net.modificationstation.stationapi.api.common.config.Category.class, name);
        categories.add(category);
        return category;
    }

    @Override
    public Collection<Category> getCategories() {
        return Collections.unmodifiableCollection(categories);
    }

    @Override
    public File getConfigFile() {
        return configFile;
    }

    @Override
    public void load() {
        try {
            if ((!configFile.getParentFile().exists() && !configFile.getParentFile().mkdirs()) || (!configFile.exists() && !configFile.createNewFile()))
                throw new RuntimeException("Failed to load config at " + configFile.getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (configFile.canRead()) {
            FileInputStream fileInputStream;
            BufferedReader buffer;
            try {
                fileInputStream = new FileInputStream(configFile);
                buffer = new BufferedReader(new InputStreamReader(fileInputStream, "8859_1"));
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            load(buffer);
            try {
                buffer.close();
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void load(BufferedReader buffer) {
        net.modificationstation.stationapi.api.common.config.Category currentCategory = null;
        String line;
        while (true) {
            try {
                line = buffer.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line == null) {
                if (currentCategory != null)
                    throw new RuntimeException("Category \"" + currentCategory.getName() + "\" isn't closed!");
                break;
            }
            boolean doneOrComment = false;
            for (int i = 0; i < line.length() && !doneOrComment; i++) {
                if (!Character.isLetterOrDigit(line.charAt(i)) && line.charAt(i) != '.' && !Character.isWhitespace(line.charAt(i))) {
                    switch (line.charAt(i)) {
                        case '#':
                            doneOrComment = true;
                            break;
                        case '=':
                            if (currentCategory == null)
                                throw new RuntimeException("Property outside of a category!");
                            currentCategory.getProperty(line.split("=")[0].substring(4)).setValue(line.substring(i + 1));
                            doneOrComment = true;
                            break;
                        case '{':
                            if (currentCategory != null)
                                throw new RuntimeException("Category inside of \"" + currentCategory.getName() + "\" category!");
                            currentCategory = getCategory(line.substring(0, i - 1));
                            doneOrComment = true;
                            break;
                        case '}':
                            if (currentCategory == null)
                                throw new RuntimeException("Closing a category while the one isn't present!");
                            currentCategory = null;
                            doneOrComment = true;
                            break;
                        default:
                            throw new RuntimeException("Unknown character " + line.charAt(i));
                    }
                }
            }
        }
    }

    @Override
    public void save() {
        try {
            if ((!configFile.getParentFile().exists() && !configFile.getParentFile().mkdirs()) || (!configFile.exists() && !configFile.createNewFile()))
                throw new RuntimeException("Failed to save config at " + configFile.getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (configFile.canWrite()) {
            FileOutputStream fileOutputStream = null;
            BufferedWriter buffer = null;
            try {
                fileOutputStream = new FileOutputStream(configFile);
                buffer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "8859_1"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            save(buffer);
            try {
                buffer.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void save(BufferedWriter buffer) {
        try {
            buffer.write("# Saved on " + DateFormat.getInstance().format(new Date()) + "\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (net.modificationstation.stationapi.api.common.config.Category category : categories) {
            try {
                buffer.write("\r\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            category.save(buffer);
        }
    }
}
