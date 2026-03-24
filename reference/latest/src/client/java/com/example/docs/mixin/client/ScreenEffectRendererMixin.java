package com.example.docs.mixin.client;

import com.example.docs.fluid.ModFluids;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// :::1
@Mixin(ScreenEffectRenderer.class)
public class MixinScreenEffectRenderer {
    @Inject(
            method = "renderScreenEffect",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/ScreenEffectRenderer;renderWater(Lnet/minecraft/client/Minecraft;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;)V"
            ),
            cancellable = true
    )
    private void cancelVanillaWaterScreenEffect(boolean sleeping, float tickProgress, SubmitNodeCollector queue, CallbackInfo ci) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || minecraft.level == null) return;

        Player player = minecraft.player;
        FluidState fluidState = minecraft.level.getFluidState(player.blockPosition());

        // If player is in our custom fluid, cancel vanilla underwater overlay
        if (fluidState.getType() == ModFluids.ACID_STILL || fluidState.getType() == ModFluids.ACID_FLOWING) {
            System.out.println("CUSTOM FLUID DETECTED - CANCELING VANILLA OVERLAY");
            // Don't render vanilla underwater overlay for custom fluids
            // We'll handle custom overlays separately or just have no overlay
        }
    }
}
// :::1
