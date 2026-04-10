package alwayslan;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

@Mod("alwayslan")
public class AlwaysLan {

    public AlwaysLan() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
    }

    @Mod.EventBusSubscriber(modid = "alwayslan", value = Dist.CLIENT)
    public static class Events {

        @SubscribeEvent
        public static void join(ClientPlayerNetworkEvent.LoggingIn e) {
            var mc = Minecraft.getInstance();
            var s = mc.getSingleplayerServer();

            if (mc.isLocalServer() && s != null && !s.isPublished()) {
                s.publishServer(
                        Config.MODE.get(),
                        Config.CHEATS.get(),
                        Config.PORT.get()
                );
            }
        }
    }
}