package de.fisch37.chestminecartsgeneratechunks;

import net.fabricmc.api.ModInitializer;

public class ChestMinecartsGenerateChunks implements ModInitializer {
    public static final String MOD_ID = "chest_minecarts_generate_chunks";
    public static TicketType MINECART_TICKET;
    public static final int LOAD_RADIUS = 2;

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
