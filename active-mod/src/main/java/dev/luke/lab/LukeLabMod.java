package dev.luke.lab;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LukeLabMod implements ModInitializer {
    public static final String MOD_ID = "luke_lab";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static final String LAB_MESSAGE = "Lab is loaded. Change this message, rebuild, run again.";

    @Override
    public void onInitialize() {
        LOGGER.info("Luke's Mod Lab loaded.");

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) ->
                handler.player.sendSystemMessage(Component.literal(LAB_MESSAGE)));
    }
}
