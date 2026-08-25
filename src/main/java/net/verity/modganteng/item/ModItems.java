package net.verity.modganteng.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.verity.modganteng.ModGanteng;
import net.verity.modganteng.food.ModFoods;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ModGanteng.MOD_ID);

    public static final DeferredItem<Item> RAW_VALDERIUM = ITEMS.registerSimpleItem("raw_valderium");

    public static final DeferredItem<Item> VALDERIUM_INGOT = ITEMS.registerSimpleItem("valderium_ingot");

    public static final DeferredItem<Item> VALDERIUM_APPLE = ITEMS.registerItem("valderium_apple", properties -> new Item(properties.food(ModFoods.VALDERIUM_APPLE, ModFoods.VALDERIUM_APPLE_CONSUMABLE).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> VALDERIUM_SWORD = ITEMS.registerItem("valderium_sword", properties -> new Item(properties.sword(ModToolTiers.VALDERIUM, 4.0F, -2.0F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> VALDERIUM_PICKAXE = ITEMS.registerItem("valderium_pickaxe", properties -> new Item(properties.pickaxe(ModToolTiers.VALDERIUM, 1.0F, -1.5F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> VALDERIUM_SHOVEL = ITEMS.registerItem("valderium_shovel", properties -> new ShovelItem(ModToolTiers.VALDERIUM, 1.0F, -1.5F, properties.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> VALDERIUM_AXE = ITEMS.registerItem("valderium_axe", properties -> new AxeItem(ModToolTiers.VALDERIUM, 8.0F, -2.6F, properties.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> VALDERIUM_HOE = ITEMS.registerItem("valderium_hoe", properties -> new HoeItem(ModToolTiers.VALDERIUM, -3.0F, -0.0F, properties.component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> VALDERIUM_SPEAR = ITEMS.registerItem("valderium_spear", properties -> new Item(properties.spear(ModToolTiers.VALDERIUM, 1.3F, 0.88F, 0.88F, 3.5F, 13F, 8.5F, 5.1F, 15F, 4.67F).component(DataComponents.UNBREAKABLE, Unit.INSTANCE).fireResistant().rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
