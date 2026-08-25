package net.verity.modganteng.creativemodetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.verity.modganteng.ModGanteng;
import net.verity.modganteng.block.ModBlocks;
import net.verity.modganteng.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModGanteng.MOD_ID);

    public static final Supplier<CreativeModeTab> MOD_GANTENG_TAB = CREATIVE_MODE_TABS.register("mod_ganteng_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VALDERIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.modganteng.mod_ganteng_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_VALDERIUM);
                        output.accept(ModItems.VALDERIUM_INGOT);

                        output.accept(ModItems.VALDERIUM_SWORD);
                        output.accept(ModItems.VALDERIUM_PICKAXE);
                        output.accept(ModItems.VALDERIUM_AXE);
                        output.accept(ModItems.VALDERIUM_SHOVEl);
                        output.accept(ModItems.VALDERIUM_HOE);
                        output.accept(ModItems.VALDERIUM_SPEAR);

                        output.accept(ModItems.VALDERIUM_APPLE);

                        output.accept(ModBlocks.VALDERIUM_BLOCK);
                        output.accept(ModBlocks.RAW_VALDERIUM_BLOCK);
                        output.accept(ModBlocks.VALDERIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_VALDERIUM_ORE);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
