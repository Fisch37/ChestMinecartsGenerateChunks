package de.fisch37.chestminecartsgeneratechunks.mixins;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.entity.vehicle.minecart.MinecartChest;
import net.minecraft.world.entity.vehicle.minecart.MinecartFurnace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractMinecart.class)
public class AbstractMinecartMixin {
    @Inject(method = "tick", at = @At("RETURN"))
    private void tickINJECT$RETURN(CallbackInfo ci) {
        var myself = (AbstractMinecart)((Object)this);
        if (
                (myself instanceof MinecartChest
                    || myself instanceof MinecartFurnace
                )
                && myself.level() instanceof ServerLevel level
        ) {
            level.getChunkSource().addTicketWithRadius(
                    ChestMinecartsGenerateChunks.MINECART_TICKET,
                    myself.chunkPosition(),
                    ChestMinecartsGenerateChunks.LOAD_RADIUS
            );
        }
    }
}
