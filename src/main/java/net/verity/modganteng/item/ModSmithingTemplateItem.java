package net.verity.modganteng.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {

//    private static final Identifier EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace("item/empty_slot_ingot");
//
//    private static final Identifier EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace("item/empty_armor_slot_helmet");
//    private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace("item/empty_armor_slot_chestplate");
//    private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace("item/empty_armor_slot_leggings");
//    private static final Identifier EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace("item/empty_armor_slot_boots");
//    private static final Identifier EMPTY_SLOT_HOE = Identifier.withDefaultNamespace("item/empty_slot_hoe");
//    private static final Identifier EMPTY_SLOT_AXE = Identifier.withDefaultNamespace("item/empty_slot_axe");
//    private static final Identifier EMPTY_SLOT_SWORD = Identifier.withDefaultNamespace("item/empty_slot_sword");
//    private static final Identifier EMPTY_SLOT_SHOVEL = Identifier.withDefaultNamespace("item/empty_slot_shovel");
//    private static final Identifier EMPTY_SLOT_PICKAXE = Identifier.withDefaultNamespace("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace("container/slot/helmet");
    private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace("container/slot/chestplate");
    private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace("container/slot/leggings");
    private static final Identifier EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace("container/slot/boots");
    private static final Identifier EMPTY_SLOT_HOE = Identifier.withDefaultNamespace("container/slot/hoe");
    private static final Identifier EMPTY_SLOT_AXE = Identifier.withDefaultNamespace("container/slot/axe");
    private static final Identifier EMPTY_SLOT_SWORD = Identifier.withDefaultNamespace("container/slot/sword");
    private static final Identifier EMPTY_SLOT_SHOVEL = Identifier.withDefaultNamespace("container/slot/shovel");
    private static final Identifier EMPTY_SLOT_SPEAR = Identifier.withDefaultNamespace("container/slot/spear");
    private static final Identifier EMPTY_SLOT_PICKAXE = Identifier.withDefaultNamespace("container/slot/pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace("container/slot/ingot");
    private static final Identifier EMPTY_SLOT_NAUTILUS_ARMOR = Identifier.withDefaultNamespace("container/slot/nautilus_armor");;

    // Exactly 7 parameters accepted and passed to super()
    public ModSmithingTemplateItem(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<Identifier> baseSlotEmptyIcons, List<Identifier> additionalSlotEmptyIcons, Properties properties) {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, properties.fireResistant().rarity(Rarity.EPIC));
    }

    public static ModSmithingTemplateItem createValderiumUpgradeTemplate(Properties properties) {
        return new ModSmithingTemplateItem(
                Component.translatable("item.modganteng.smithing_template.valderium_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
                Component.translatable("item.modganteng.smithing_template.valderium_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
                Component.translatable("item.modganteng.smithing_template.valderium_upgrade.base_slot_description"),
                Component.translatable("item.modganteng.smithing_template.valderium_upgrade.additions_slot_description"),
                createUpgradeIconList(),
                createUpgradeMaterialList(),
                properties
        );
    }

    private static List<Identifier> createUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_NAUTILUS_ARMOR, EMPTY_SLOT_SPEAR);
    }

    private static List<Identifier> createUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}