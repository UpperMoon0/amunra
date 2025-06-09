package de.katzenpapst.amunra.proxy;

import net.minecraft.server.MinecraftServer;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import de.katzenpapst.amunra.AmunRa;

public class ServerProxy extends ARSidedProxy {

    @Override
    public void init(final FMLInitializationEvent event) {
        try {
            final MinecraftServer s = MinecraftServer.getServer();
            if (!Loader.isModLoaded("hodgepodge") && s.isDedicatedServer()
                    && !s.isServerInOnlineMode()
                    && !AmunRa.isDevEnvironment()) {
                AmunRa.LOGGER.warn("Server is running in offline mode. This may cause issues with certain features.");
            }
        } catch (final Exception e) {
            AmunRa.LOGGER.error(
                    "Could not detect whenever server is in online mode. Things might break if the server is in offline mode.");
        }
    }

}
