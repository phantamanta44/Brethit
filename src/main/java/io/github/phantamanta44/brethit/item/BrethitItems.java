package io.github.phantamanta44.brethit.item;

import io.github.phantamanta44.brethit.BrethitMod;
import io.github.phantamanta44.brethit.item.base.UtilityClass;
import io.github.phantamanta44.brethit.item.weapon.*;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;

import java.lang.reflect.InvocationTargetException;

import static io.github.phantamanta44.brethit.item.base.UtilityArchetype.*;

public class BrethitItems {

    public static class WEAPON {

        public static Item ANCIENT_AXE, ANCIENT2_AXE, ANCIENT3_AXE,
                ANCIENT_BLADESAW, ANCIENT_SHORT_SWORD, ANCIENT_SPEAR_UNIQ,
                ANCIENT_SPEAR, ANCIENT2_SPEAR, ANCIENT3_SPEAR,
                ANCIENT_SWORD, ANCIENT2_SWORD, ANCIENT3_SWORD,
                BOKO_BAT, BOKO_CLUB, BOKO_SPEAR,
                BOKO2_BAT, BOKO2_CLUB, BOKO2_SPEAR,
                BOKO3_BAT, BOKO3_CLUB, BOKO3_SPEAR,
                STAL_ARM, STAL2_ARM, STAL3_ARM,
                BOULDER_BREAKER, LIGHTSCALE_TRIDENT, SEVEN_BLADE,
                CEREMONIAL_TRIDENT,
                GORON_CLUB, GORON2_CLUB,
                YIGA_DAGGER, YIGA2_DAGGER, YIGA2_CLEAVER,
                DOUBLE_AXE,
                DRILLSHAFT,
                DUALITY_SWORD,
                SHEIKAH_BLADE, SHEIKAH_LONGBLADE, SHEIKAH_SPEAR,
                LIZAL_DAGGER, LIZAL_SPEAR,
                LIZAL2_DAGGER, LIZAL2_SPEAR,
                LIZAL3_DAGGER, LIZAL3_SPEAR,
                FARMER_PITCHFORK, FARMER_HOE, MOP,
                RITO_SWORD, RITO_SPEAR,
                FLAME_SWORD, FLAME_SPEAR, FLAME_CLEAVER,
                FROST_SWORD, FROST_SPEAR, FROST_CLEAVER,
                THUNDER_SWORD, THUNDER_SPEAR, THUNDER_CLEAVER,
                KOROK_SWORD, KOROK_SPEAR,
                GERUDO_SWORD, GERUDO_SPEAR, GERUDO_CLEAVER,
                GODDESS_SWORD, SAGE_SWORD, BIGGORON_SWORD, FIERCE_DEITY_SWORD,
                SLEDGEHAMMER,
                RUSTY_SWORD, RUSTY_CLEAVER, RUSTY_SPEAR,
                TRAVELER_SWORD, TRAVELER_CLEAVER, TRAVELER_SPEAR,
                SOLDIER_SWORD, SOLDIER_CLEAVER, SOLDIER_SPEAR,
                KNIGHT_SWORD, KNIGHT_CLEAVER, KNIGHT_SPEAR,
                ROYAL_SWORD, ROYAL_CLEAVER, ROYAL_SPEAR,
                ROYAL_GUARD_SWORD, ROYAL_GUARD_CLEAVER, ROYAL_GUARD_SPEAR,
                LYNEL_CLUB, LYNEL_SWORD, LYNEL_SPEAR,
                LYNEL2_CLUB, LYNEL2_SWORD, LYNEL2_SPEAR,
                LYNEL3_CLUB, LYNEL3_SWORD, LYNEL3_SPEAR,
                MASTER_SWORD,
                MOBLIN_CLUB, MOBLIN2_CLUB, MOBLIN3_CLUBM,
                MOBLIN_SPEAR, MOBLIN2_SPEAR, MOBLIN3_SPEAR,
                MOONLIGHT_SCIMITAR,
                ZORA_CLEAVER, ZORA_SPEAR, ZORA_SWORD,
                SILVERSCALE_SPEAR,
                STICK,
                WOODCUTTER_AXE;

        public static void init() {
            ANCIENT_AXE = new ItemBattleaxe(ANCIENT);
            ANCIENT2_AXE = new ItemBattleaxe(ANCIENT2);
            ANCIENT3_AXE = new ItemBattleaxe(ANCIENT3);
            ANCIENT_BLADESAW = new ItemUtilityUnique("w_bladesaw", UtilityClass.W_CLEAVER, 50, 55F, 2.4F, EnumRarity.EPIC, true);
            ANCIENT_SHORT_SWORD = new ItemUtilityUnique("w_ancient_shortsword", UtilityClass.W_SWORD, 54, 40F, 2F, EnumRarity.EPIC, true);
            ANCIENT_SPEAR_UNIQ = new ItemUtilityUnique("w_ancient_spear_unique", UtilityClass.W_SPEAR, 50, 30F, 2.4F, EnumRarity.EPIC, true);
            ANCIENT_SPEAR = new ItemSpear(ANCIENT);
            ANCIENT2_SPEAR = new ItemSpear(ANCIENT2);
            ANCIENT3_SPEAR = new ItemSpear(ANCIENT3);
            ANCIENT_SWORD = new ItemSword(ANCIENT);
            ANCIENT2_SWORD = new ItemSword(ANCIENT2);
            ANCIENT3_SWORD = new ItemSword(ANCIENT3);
            BOKO_BAT = new ItemClubHeavy(BOKO);
            BOKO_CLUB = new ItemClub(BOKO);
            BOKO_SPEAR = new ItemSpear(BOKO);
            BOKO2_BAT = new ItemClubHeavy(BOKO2);
            BOKO2_CLUB = new ItemClub(BOKO2);
            BOKO2_SPEAR = new ItemSpear(BOKO2);
            BOKO3_BAT = new ItemClubHeavy(BOKO3);
            BOKO3_CLUB = new ItemClub(BOKO3);
            BOKO3_SPEAR = new ItemSpear(BOKO3);
            STAL_ARM = new ItemClub(STAL);
            STAL2_ARM = new ItemClub(STAL2);
            STAL3_ARM = new ItemClub(STAL3);
            BOULDER_BREAKER = new ItemUtilityUnique("w_champ_goron", UtilityClass.W_CLUB_HEAVY, 60, 60F, 2.1F, EnumRarity.EPIC);
            LIGHTSCALE_TRIDENT = new ItemUtilityUnique("w_champ_zora", UtilityClass.W_SPEAR, 70, 22F, 2.5F, EnumRarity.EPIC);
            SEVEN_BLADE = new ItemUtilityUnique("w_champ_gerudo", UtilityClass.W_SWORD, 60, 32F, 1.7F, EnumRarity.EPIC);
            CEREMONIAL_TRIDENT = new ItemUtilityUnique("w_ceremonial_trident", UtilityClass.W_SPEAR, 40, 14F, 1.75F, EnumRarity.UNCOMMON);
            GORON_CLUB = new ItemClubHeavy(GORON);
            GORON2_CLUB = new ItemClubHeavy(GORON2);
            YIGA_DAGGER = new ItemDagger(YIGA);
            YIGA2_DAGGER = new ItemDagger(YIGA2);
            YIGA2_CLEAVER = new ItemCleaver(YIGA2);
            DOUBLE_AXE = new ItemUtilityUnique("w_double_axe", UtilityClass.W_BAXE, 52, 18F, 1.5F, EnumRarity.UNCOMMON);
            DRILLSHAFT = new ItemUtilityUnique("w_drillshaft", UtilityClass.W_SPEAR, 50, 14F, 2F, EnumRarity.UNCOMMON);
            DUALITY_SWORD = new ItemUtilityUnique("w_duality_sword", UtilityClass.W_CLEAVER, 5, 50F, 1.8F, EnumRarity.EPIC);
            SHEIKAH_BLADE = new ItemSword(SHEIKAH);
            SHEIKAH_LONGBLADE = new ItemUtilityUnique("w_sheikah_longblade", UtilityClass.W_CLEAVER, 25, 32F, 1.75F, EnumRarity.RARE);
            SHEIKAH_SPEAR = new ItemSpear(SHEIKAH);
            LIZAL_DAGGER = new ItemDagger(LIZAL);
            LIZAL_SPEAR = new ItemSpear(LIZAL);
            LIZAL2_DAGGER = new ItemDagger(LIZAL2);
            LIZAL2_SPEAR = new ItemSpear(LIZAL2);
            LIZAL3_DAGGER = new ItemDagger(LIZAL3);
            LIZAL3_SPEAR = new ItemSpear(LIZAL3);
            FARMER_PITCHFORK = new ItemSpear(FARMER);
            FARMER_HOE = new ItemClubHeavy(FARMER);
            MOP = new ItemUtilityUnique("w_mop", UtilityClass.W_SPEAR, 8, 5F, 0.9F);
            RITO_SWORD = new ItemSword(RITO);
            RITO_SPEAR = new ItemSpear(RITO);
            FLAME_SWORD = new ItemWeaponElemental.Flame("sword", UtilityClass.W_SWORD);
            FLAME_SPEAR = new ItemWeaponElemental.Flame("spear", UtilityClass.W_SPEAR);
            FLAME_CLEAVER = new ItemWeaponElemental.Flame("cleaver", UtilityClass.W_CLEAVER);
            FROST_SWORD = new ItemWeaponElemental.Frost("sword", UtilityClass.W_SWORD);
            FROST_SPEAR = new ItemWeaponElemental.Frost("spear", UtilityClass.W_SPEAR);
            FROST_CLEAVER = new ItemWeaponElemental.Frost("cleaver", UtilityClass.W_CLEAVER);
            THUNDER_SWORD = new ItemWeaponElemental.Thunder("sword", UtilityClass.W_SWORD);
            THUNDER_SPEAR = new ItemWeaponElemental.Thunder("spear", UtilityClass.W_SPEAR);
            THUNDER_CLEAVER = new ItemWeaponElemental.Thunder("cleaver", UtilityClass.W_CLEAVER);
            KOROK_SWORD = new ItemSword(KOROK);
            KOROK_SPEAR = new ItemSpear(KOROK);
            GERUDO_SWORD = new ItemSword(GERUDO);
            GERUDO_SPEAR = new ItemSpear(GERUDO);
            GERUDO_CLEAVER = new ItemCleaver(GERUDO);
            GODDESS_SWORD = new ItemUtilityUnique("w_dlc_goddess", UtilityClass.W_SWORD, 45, 28F, 1.9F, EnumRarity.EPIC);
            SAGE_SWORD = new ItemUtilityUnique("w_dlc_sage", UtilityClass.W_SWORD, 50, 48F, 2.1F, EnumRarity.EPIC);
            BIGGORON_SWORD = new ItemUtilityUnique("w_dlc_biggoron", UtilityClass.W_CLEAVER, 60, 50F, 1.75F, EnumRarity.EPIC);
            FIERCE_DEITY_SWORD = new ItemUtilityUnique("w_dlc_majora", UtilityClass.W_SWORD, 35, 60F, 2F, EnumRarity.EPIC);
            SLEDGEHAMMER = new ItemUtilityUnique("w_sledgehammer", UtilityClass.W_CLUB_HEAVY, 40, 12F, 2F);
            RUSTY_SWORD = new ItemSword(RUSTY);
            RUSTY_CLEAVER = new ItemCleaver(RUSTY);
            RUSTY_SPEAR = new ItemSpear(RUSTY);
            TRAVELER_SWORD = new ItemSword(TRAVELER);
            TRAVELER_CLEAVER = new ItemCleaver(TRAVELER);
            TRAVELER_SPEAR = new ItemSpear(TRAVELER);
            SOLDIER_SWORD = new ItemSword(SOLDIER);
            SOLDIER_CLEAVER = new ItemCleaver(SOLDIER);
            SOLDIER_SPEAR = new ItemSpear(SOLDIER);
            KNIGHT_SWORD = new ItemSword(KNIGHT);
            KNIGHT_CLEAVER = new ItemCleaver(KNIGHT);
            KNIGHT_SPEAR = new ItemSpear(KNIGHT);
            ROYAL_SWORD = new ItemSword(ROYAL);
            ROYAL_CLEAVER = new ItemCleaver(ROYAL);
            ROYAL_SPEAR = new ItemSpear(ROYAL);
            ROYAL_GUARD_SWORD = new ItemSword(CALAMITY);
            ROYAL_GUARD_CLEAVER = new ItemCleaver(CALAMITY);
            ROYAL_GUARD_SPEAR = new ItemSpear(CALAMITY);
            LYNEL_CLUB = new ItemClubHeavy(LYNEL);
            LYNEL_SWORD = new ItemSword(LYNEL);
            LYNEL_SPEAR = new ItemSpear(LYNEL);
            LYNEL2_CLUB = new ItemClubHeavy(LYNEL2);
            LYNEL2_SWORD = new ItemSword(LYNEL2);
            LYNEL2_SPEAR = new ItemSpear(LYNEL2);
            LYNEL3_CLUB = new ItemClubHeavy(LYNEL3);
            LYNEL3_SWORD = new ItemSword(LYNEL3);
            LYNEL3_SPEAR = new ItemSpear(LYNEL3);
            MASTER_SWORD = new ItemUtilityUnique("w_master_sword", UtilityClass.W_SWORD, 40, 40F, 1.9F, EnumRarity.EPIC);
            MOBLIN_CLUB = new ItemClubHeavy(MOBLIN);
            MOBLIN2_CLUB = new ItemClubHeavy(MOBLIN2);
            MOBLIN3_CLUBM = new ItemClubHeavy(MOBLIN3);
            MOBLIN_SPEAR = new ItemSpear(MOBLIN);
            MOBLIN2_SPEAR = new ItemSpear(MOBLIN2);
            MOBLIN3_SPEAR = new ItemSpear(MOBLIN3);
            MOONLIGHT_SCIMITAR = new ItemUtilityUnique("w_moonlight_scimitar", UtilityClass.W_SWORD, 32, 25F, 1.75F, EnumRarity.RARE);
            ZORA_CLEAVER = new ItemCleaver(ZORA);
            ZORA_SPEAR = new ItemSpear(ZORA);
            ZORA_SWORD = new ItemSword(ZORA);
            SILVERSCALE_SPEAR = new ItemUtilityUnique("w_silverscale_spear", UtilityClass.W_SPEAR, 40, 12F, 2F, EnumRarity.UNCOMMON);
            STICK = new ItemUtilityUnique("w_stick", UtilityClass.W_CLUB, 4, 2F, 0.1F);
            WOODCUTTER_AXE = new ItemUtilityUnique("w_woodcutter_axe", UtilityClass.W_BAXE, 47, 3F, 1.8F);
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
