package de.fisch37.chestminecartsgeneratechunks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.TicketType;

import java.util.Objects;

public class ChestMinecartsGenerateChunks implements ModInitializer {
    public static final String MOD_ID = "chest_minecarts_generate_chunks";
    public static TicketType MINECART_TICKET;
    public static final int LOAD_RADIUS = 2;
    // Minecart must move at least 0.2 m/s (one block every 5 seconds)
    // this value is somewhat conservative
    public static final double MIN_LOAD_SPEED_SQR = Math.pow(0.01, 2);

    @Override
    public void onInitialize() {
    }

    public static void registerTicketType() {
        MINECART_TICKET = Registry.register(
                BuiltInRegistries.TICKET_TYPE,
                Objects.requireNonNull(Identifier.tryBuild(MOD_ID, "minecart")),
                new TicketType(
                        40L,
                        TicketType.FLAG_PERSIST | TicketType.FLAG_LOADING
                                | TicketType.FLAG_SIMULATION | TicketType.FLAG_KEEP_DIMENSION_ACTIVE
                )
        );
    }
}
