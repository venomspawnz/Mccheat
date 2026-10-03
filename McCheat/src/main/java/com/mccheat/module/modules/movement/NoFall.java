package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
public class NoFall extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public NoFall() { super("NoFall", Category.MOVEMENT, 0); }
    @Override public void onTick() {
        if (mc.player == null) return;
        if (mc.player.fallDistance > 2.0f) {
            mc.player.networkHandler.sendPacket(
                new PlayerMoveC2SPacket.PositionAndOnGround(
                    mc.player.getX(), mc.player.getY(), mc.player.getZ(), true));
        }
    }
}
