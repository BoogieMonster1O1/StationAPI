package net.modificationstation.sltest;

import net.modificationstation.stationapi.api.common.event.Event;
import net.modificationstation.stationapi.api.common.event.EventBus;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.ListenerPriority;
import net.modificationstation.stationapi.api.common.event.mod.InitEvent;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;

public class SLTest {

    @Entrypoint.Instance
    public static final SLTest INSTANCE = Null.get();

    @Entrypoint.ModID
    public static final ModID MODID = Null.get();

    public SLTest() {
        System.out.println("WHAT");
    }

    @EventListener
    public void init(InitEvent event) {
        System.out.println(MODID);
        EventBus eventBus = new EventBus();
        eventBus.register(this::onTestEvent, ListenerPriority.LOWEST.numPriority);
        eventBus.register(this::onTestEventbutCOOLER, ListenerPriority.HIGH.numPriority);
        eventBus.register(this::onTestEventButNo);
//        eventBus.register(this::lol);
        eventBus.post(new TestEvent());
//        TextureAtlas atlas = new TextureAtlas(true, null, null, 0);
//        try {
//            int firstTexture = atlas.addTexture("/assets/sltest/textures/blocks/FreezerSide.png");
//            int secondTexture = atlas.addTexture("/assets/sltest/textures/blocks/FreezerTop.png");
//            int thirdTexture = atlas.addTexture("/assets/sltest/textures/blocks/testBlock.png");
//            System.out.println(firstTexture + " " + secondTexture + " " + thirdTexture);
//            File spritesheet = new File(FabricLoader.getInstance().getGameDir().toFile(), "spritesheet.png");
//            if (!spritesheet.exists())
//                spritesheet.createNewFile();
//            ImageIO.write(atlas.getSpritesheet(), "png", spritesheet);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        {
            int tests = 1000;
            int listeners = 1;
            int dispatches = 1000000;
            long total = 0;
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for (int i = 0; i < tests; i++) {
                EventBus bmBus = new EventBus();
                for (int j = 0; j < listeners; j++)
                    bmBus.register(Listener.class);
                long startTS = System.nanoTime();
                for (int j = 0; j < dispatches; j++)
                    bmBus.post(new TestEvent());
                long stopTS = System.nanoTime();
                long result = stopTS - startTS;
                System.out.println("Took: " + result + "ns");
                total += result;
                if (result < min)
                    min = result;
                if (result > max)
                    max = result;
            }
            System.out.println("Tests: " + tests);
            System.out.println("Listeners: " + listeners);
            System.out.println("Dispatches: " + dispatches);
            System.out.println("Average: " + total / tests + "ns");
            System.out.println("Min: " + min + "ns");
            System.out.println("Max: " + max + "ns");
        }
    }

    public static class Listener {

        @EventListener
        public static void benchmark1(TestEvent event2) { }
//
//        @EventListener
//        public static void benchmark2(TestEvent event2) { }
//
//        @EventListener
//        public static void benchmark3(TestEvent event2) { }
    }

    public void onTestEvent(TestEvent event) {
        System.out.println("oh wow, a test event");
    }

    public void onTestEventbutCOOLER(TestEvent event) {
        System.out.println("am cooler that the thing that's gonna execute after me");
    }

    public void onTestEventButNo(TestEvent event) {
        System.out.println("no, not me");
    }

//    public void lol(Event event) {
//        System.out.println("lol");
//    }

    public static class TestEvent extends Event {

        @Override
        protected int getEventID() {
            return ID;
        }

        public static final int ID = NEXT_ID.incrementAndGet();}
}
