package net.verity.modganteng.item;

import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.verity.modganteng.ModGanteng;
import net.verity.modganteng.tags.ModTags;

import java.util.Map;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));


    public static final ResourceKey<EquipmentAsset> VALDERIUM_KEY = ResourceKey.create(ROOT_ID, Identifier.fromNamespaceAndPath(ModGanteng.MOD_ID, "valderium"));

    public static final ArmorMaterial VALDERIUM_ARMOR_MATERIAL = new ArmorMaterial(
            Short.MAX_VALUE,
            makeDefense(4, 9, 7, 4, 8),
            85,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            5.0F,
            0.5f,
            ModTags.Items.VALDERIUM_REPAIRABLE,
            ModArmorMaterials.VALDERIUM_KEY
    );

    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(
                Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body)
        );
    }
}
