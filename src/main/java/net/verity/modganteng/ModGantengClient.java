package net.verity.modganteng;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.verity.modganteng.keymapping.ModKeyMappings;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = ModGanteng.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = ModGanteng.MOD_ID, value = Dist.CLIENT)
public class ModGantengClient {
    public ModGantengClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        ModKeyMappings.register();
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        ModGanteng.LOGGER.info("HELLO FROM CLIENT SETUP");
        ModGanteng.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(ModKeyMappings.PRESS_DASH.get());
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        while(ModKeyMappings.PRESS_DASH.get().consumeClick()) {
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("wow i press something"));
        }
    }
}
