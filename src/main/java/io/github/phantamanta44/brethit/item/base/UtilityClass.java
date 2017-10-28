package io.github.phantamanta44.brethit.item.base;

import io.github.phantamanta44.brethit.util.HarvestPredicate;
import net.minecraft.block.state.IBlockState;

public enum UtilityClass {

    W_BAXE(0.88F, HarvestPredicate.AXE, 1.5F, Constants.AS_HEAVY),
    W_CLEAVER(1.11F, HarvestPredicate.CLEAVER, 1.44F, Constants.AS_HEAVY),
    W_CLUB(1F, HarvestPredicate.BLUNT, 1F, Constants.AS_MOD),
    W_CLUB_HEAVY(1.3F, HarvestPredicate.BLUNT, 1.5F, Constants.AS_HEAVY),
    W_DAGGER(0.9F, HarvestPredicate.SWORD, 1F, Constants.AS_DAGGER),
    W_SPEAR(1.18F, HarvestPredicate.SPEAR, 0.7F, Constants.AS_SPEAR),
    W_SWORD(1F, HarvestPredicate.SWORD, 1F, Constants.AS_MOD);

    private static class Constants {
        private static final float AS_HEAVY = 0.55F;
        private static final float AS_MOD = 0.9F;
        private static final float AS_DAGGER = 0.9F;
        private static final float AS_SPEAR = 1.3F;
    }

    public final float durabilityFactor;
    public final float atkDmgFactor;
    public final float atkSpdFactor;

    private final HarvestPredicate harvestability;

    UtilityClass(float durabilityFactor, HarvestPredicate harvestability, float atkDmgFactor, float atkSpdFactor) {
        this.durabilityFactor = durabilityFactor;
        this.harvestability = harvestability;
        this.atkDmgFactor = atkDmgFactor;
        this.atkSpdFactor = atkSpdFactor;
    }

    public boolean canHarvest(IBlockState state) {
        return harvestability.test(state);
    }

}
