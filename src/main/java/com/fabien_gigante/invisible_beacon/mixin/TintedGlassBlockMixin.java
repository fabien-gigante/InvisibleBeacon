package com.fabien_gigante.invisible_beacon.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.TintedGlassBlock;

@Mixin(TintedGlassBlock.class)
public class TintedGlassBlockMixin implements BeaconBeamBlock {
    @Override
    public @Nullable DyeColor getColor() { return null; }
}