package net.verity.modganteng.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.verity.modganteng.ModGanteng;
import net.verity.modganteng.food.ModFoods;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ModGanteng.MOD_ID);

    public static final DeferredItem<Item> RAW_VALDERIUM = ITEMS.registerSimpleItem("raw_valderium");

    public static final DeferredItem<Item> VALDERIUM_INGOT = ITEMS.registerSimpleItem("valderium_ingot");

    public static final DeferredItem<Item> VALDERIUM_APPLE = ITEMS.registerItem("valderium_apple",
            properties -> new Item(properties.food(ModFoods.VALDERIUM_APPLE, ModFoods.VALDERIUM_APPLE_CONSUMABLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
