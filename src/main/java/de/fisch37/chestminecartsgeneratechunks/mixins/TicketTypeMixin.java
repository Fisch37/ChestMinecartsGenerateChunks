package de.fisch37.chestminecartsgeneratechunks.mixins;

import de.fisch37.chestminecartsgeneratechunks.ChestMinecartsGenerateChunks;
import net.minecraft.server.level.TicketType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TicketType.class)
public class TicketTypeMixin {
    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void classLoadINJECT(CallbackInfo ci) {
        ChestMinecartsGenerateChunks.registerTicketType();
    }
}
