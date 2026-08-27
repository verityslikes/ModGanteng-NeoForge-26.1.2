package net.verity.modganteng.item;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.verity.modganteng.tags.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final ToolMaterial VALDERIUM = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_VALDERIUM_TOOL,
            Short.MAX_VALUE, 12.0F, 9.0F, 75, ModTags.Items.VALDERIUM_REPAIRABLE);



    public static Tool createMaceTool(ToolMaterial material) {
        return new Tool(List.of(), material.speed(), 2, false);
    }

    public static ItemAttributeModifiers createMaceAttributes(ToolMaterial material) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, material.attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, material.speed(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }
}
