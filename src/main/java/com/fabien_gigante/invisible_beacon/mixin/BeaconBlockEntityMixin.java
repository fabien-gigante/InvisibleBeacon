package com.fabien_gigante.invisible_beacon.mixin;

import net.minecraft.util.ARGB;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntityMixin {

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/DyeColor;getTextureDiffuseColor()I"))
    private static int getBeamColor(@Nullable DyeColor dye) {
        return dye != null ? dye.getTextureDiffuseColor() :  0x00ffffff;
    }

	@Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/ARGB;average(II)I"))
	private static int computeAverageColor(int color1, int color2) {
		float alpha = ARGB.alphaFloat(color1) * ARGB.alphaFloat(color2);
		return ARGB.color(alpha, ARGB.average(color1, color2));
	}
}