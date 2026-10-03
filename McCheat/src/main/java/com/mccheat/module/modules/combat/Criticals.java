package com.mccheat.module.modules.combat;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
public class Criticals extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public Criticals() { super("Criticals", Category.COMBAT, 0); }
    @Override public void onTick() {
        if (mc.player == null) return;
        if (mc.player.isOnGround() && mc.player.attacking) {
            // Packet-based crit: send slight upward then downward move
            mc.player.networkHandler.sendPacket(
                new PlayerMoveC2SPacket.PositionAndOnGround(
                    mc.player.getX(), mc.player.getY() + 0.0625, mc.player.getZ(), false));
            mc.player.networkHandler.sendPacket(
                new PlayerMoveC2SPacket.PositionAndOnGround(
                    mc.player.getX(), mc.player.getY(), mc.player.getZ(), false));
        }
    }
}
