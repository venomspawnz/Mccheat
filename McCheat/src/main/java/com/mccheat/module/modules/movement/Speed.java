package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
public class Speed extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public float multiplier = 2.5f;
    public Speed() { super("Speed", Category.MOVEMENT, 0); }
    @Override public void onTick() {
        if (mc.player == null) return;
        if (mc.player.isOnGround() && mc.options.forwardKey.isPressed()) {
            double yaw = Math.toRadians(mc.player.getYaw());
            mc.player.setVelocity(
                -Math.sin(yaw) * multiplier * 0.1,
                mc.player.getVelocity().y,
                 Math.cos(yaw) * multiplier * 0.1
            );
        }
    }
}
