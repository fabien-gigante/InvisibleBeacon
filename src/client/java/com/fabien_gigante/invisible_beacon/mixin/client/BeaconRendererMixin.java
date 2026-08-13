package com.fabien_gigante.invisible_beacon.mixin.client;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.vertex.PoseStack;

@Mixin(BeaconRenderer.class)
public abstract class BeaconRendererMixin {
	@Inject(
		method = "submitBeaconBeam(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/resources/Identifier;FFIIIFF)V",
		at = @At("HEAD"), cancellable = true
	)
	private static void skipInvisibleBeam(
		PoseStack poseStack, SubmitNodeCollector submitNodeCollector, Identifier beamLocation, float scale, float animationTime, int beamStart, int height, int color, float solidBeamRadius, float beamGlowRadius, CallbackInfo ci
	) {
		if (ARGB.alpha(color) == 0) ci.cancel();
	}	
}
