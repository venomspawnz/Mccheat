package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
public class ElytraFly extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public float speed = 1.8f;
    public ElytraFly() { super("ElytraFly", Category.MOVEMENT, 0); }
    @Override public void onTick() {
        if (mc.player == null) return;
        if (mc.player.getEquippedStack(net.minecraft.entity.EquipmentSlot.CHEST).getItem() != Items.ELYTRA) return;
        if (!mc.player.isFallFlying()) {
            mc.player.networkHandler.sendPacket(
                new ClientCommandC2SPacket(mc.player, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
        }
        double yaw   = Math.toRadians(mc.player.getYaw());
        double pitch = Math.toRadians(mc.player.getPitch());
        mc.player.setVelocity(
            -Math.sin(yaw) * Math.cos(pitch) * speed,
            -Math.sin(pitch) * speed,
             Math.cos(yaw) * Math.cos(pitch) * speed
        );
    }
}
