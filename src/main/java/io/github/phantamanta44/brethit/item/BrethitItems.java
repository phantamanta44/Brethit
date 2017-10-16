package io.github.phantamanta44.brethit.item;

import io.github.phantamanta44.brethit.BrethitMod;

import java.lang.reflect.InvocationTargetException;

public class BrethitItems {

    public static class WEAPON {

        public static void init() {

        }

    }

    public static class TOOL {

        public static void init() {

        }

    }

    public static class ARMOUR {

        public static void init() {

        }

    }

    public static class SHIELD {

        public static void init() {

        }

    }

    public static class BOW {

        public static void init() {

        }

    }

    public static class FOOD {

        public static void init() {

        }

    }

    public static class MATERIAL {

        public static void init() {

        }

    }

    public static void init() {
        for (Class<?> clazz : BrethitItems.class.getDeclaredClasses()) {
            try {
                clazz.getDeclaredMethod("init").invoke(null);
            } catch (InvocationTargetException e) {
                BrethitMod.LOGGER.error("Failed to initialize items!");
                e.printStackTrace();
            } catch (IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
