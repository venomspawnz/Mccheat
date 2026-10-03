package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
public class Parkour extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public Parkour() { super("Parkour", Category.MOVEMENT, 0); }
    @Override public void onTick() {
        if (mc.player == null || mc.world == null) return;
        BlockPos pos = mc.player.getBlockPos();
        boolean edgeAhead = mc.world.getBlockState(pos.down()).isAir();
        if (edgeAhead && mc.player.isOnGround()) {
            mc.player.jump();
        }
    }
}
