package net.verity.modganteng.item.custom.mace;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import java.util.function.Consumer;

import static net.minecraft.world.entity.projectile.hurtingprojectile.windcharge.AbstractWindCharge.EXPLOSION_DAMAGE_CALCULATOR;

public class CorruptedMace extends MaceItem {
    private final ToolMaterial material;

    public CorruptedMace(ToolMaterial material, Properties properties) {
        super(properties);
        this.material = material;
    }

    public ToolMaterial getMaterial() {
        return this.material;
    }


    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
//        if(Minecraft.getInstance().hasShiftDown()) {
//            builder.accept(Component.translatable("tooltip.tutorialmod.metal_detector.shift_down"));
//        } else {
//            builder.accept(Component.translatable("tooltip.tutorialmod.metal_detector"));
//        }
        builder.accept(Component.translatable("tooltip.modganteng.corrupted_mace"));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}