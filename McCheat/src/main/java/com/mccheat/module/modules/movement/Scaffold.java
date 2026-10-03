package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
public class Scaffold extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public Scaffold() { super("Scaffold", Category.MOVEMENT, 0); }
    @Override public void onTick() {
        if (mc.player == null || mc.world == null) return;
        // Select block in hotbar
        for (int i = 0; i < 9; i++) {
            if (mc.player.getInventory().getStack(i).getItem() instanceof BlockItem) {
                mc.player.getInventory().selectedSlot = i;
                break;
            }
        }
        BlockPos below = mc.player.getBlockPos().down();
        if (mc.world.getBlockState(below).isAir()) {
            BlockHitResult hit = new BlockHitResult(
                Vec3d.ofCenter(below), Direction.UP, below, false);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, hit);
        }
    }
}
