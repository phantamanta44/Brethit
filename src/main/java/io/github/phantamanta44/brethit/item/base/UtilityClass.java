package io.github.phantamanta44.brethit.item.base;

import io.github.phantamanta44.brethit.util.HarvestPredicate;
import net.minecraft.block.state.IBlockState;

public enum UtilityClass {

    AXE(1.25F, HarvestPredicate.AXE, 1.6F, Constants.AS_HEAVY),
    SWORD(1F, HarvestPredicate.SWORD, 1F, Constants.AS_MOD);

    private static class Constants {
        private static final float AS_HEAVY = 0.6F;
        private static final float AS_MOD = 0.9F;
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
