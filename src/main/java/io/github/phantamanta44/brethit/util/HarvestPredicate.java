package io.github.phantamanta44.brethit.util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.registries.IRegistryDelegate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class HarvestPredicate implements Predicate<IBlockState> {

    public static final HarvestPredicate SWORD = new HarvestPredicate()
            .material(Material.CACTUS).material(Material.CARPET).material(Material.GLASS)
            .material(Material.ICE).material(Material.LEAVES).material(Material.PLANTS)
            .material(Material.VINE).material(Material.WEB);
    public static final HarvestPredicate AXE = SWORD.copy()
            .material(Material.CLOTH).material(Material.CORAL).material(Material.GOURD)
            .material(Material.PISTON).material(Material.SPONGE).material(Material.WOOD);

    private final Set<Material> validMaterials = new HashSet<>();
    private final Set<IRegistryDelegate<Block>> validBlocks = new HashSet<>();
    private final Set<IRegistryDelegate<Block>> illegalBlocks = new HashSet<>();
    private final List<Predicate<? super IBlockState>> tests = new LinkedList<>();
    private final List<Predicate<? super IBlockState>> illegalTests = new LinkedList<>();

    public HarvestPredicate material(Material mat) {
        validMaterials.add(mat);
        return this;
    }

    public HarvestPredicate block(Block block) {
        validBlocks.add(block.delegate);
        return this;
    }

    public HarvestPredicate notBlock(Block block) {
        illegalBlocks.add(block.delegate);
        return this;
    }

    public HarvestPredicate pred(Predicate<? super IBlockState> pred) {
        tests.add(pred);
        return this;
    }

    public HarvestPredicate notPred(Predicate<? super IBlockState> pred) {
        illegalTests.add(pred);
        return this;
    }

    @Override
    public boolean test(IBlockState block) {
        return !(illegalBlocks.contains(block.getBlock().delegate)
                || illegalTests.stream().anyMatch(t -> t.test(block)))
                && (validMaterials.contains(block.getMaterial())
                || validBlocks.contains(block.getBlock().delegate)
                || tests.stream().anyMatch(t -> t.test(block)));
    }

    @Override
    public HarvestPredicate and(Predicate<? super IBlockState> other) {
        return other instanceof HarvestPredicate ? and((HarvestPredicate)other) : copy().pred(other);
    }

    public HarvestPredicate and(HarvestPredicate other) {
        HarvestPredicate pred = copy();
        pred.validMaterials.addAll(other.validMaterials);
        pred.validBlocks.addAll(other.validBlocks);
        pred.illegalBlocks.addAll(other.illegalBlocks);
        pred.tests.addAll(other.tests);
        pred.illegalTests.addAll(other.illegalTests);
        return pred;
    }

    public HarvestPredicate copy() {
        HarvestPredicate pred = new HarvestPredicate();
        pred.validMaterials.addAll(validMaterials);
        pred.validBlocks.addAll(validBlocks);
        pred.illegalBlocks.addAll(illegalBlocks);
        pred.tests.addAll(tests);
        pred.illegalTests.addAll(illegalTests);
        return pred;
    }

}
