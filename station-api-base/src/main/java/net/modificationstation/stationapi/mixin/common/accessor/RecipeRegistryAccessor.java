package net.modificationstation.stationapi.mixin.common.accessor;

import net.minecraft.item.ItemInstance;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.*;

@Mixin(RecipeRegistry.class)
public interface RecipeRegistryAccessor {

    @SuppressWarnings("UnusedReturnValue")
    @Invoker("<init>")
    static RecipeRegistry invokeCor() {
        throw new UnsupportedOperationException("Mixin!");
    }

    @Invoker
    void invokeAddShapedRecipe(ItemInstance itemInstance, Object... o);

    @Invoker
    void invokeAddShapelessRecipe(ItemInstance itemInstance, Object... o);

    @Accessor
    List<Recipe> getRecipes();
}
