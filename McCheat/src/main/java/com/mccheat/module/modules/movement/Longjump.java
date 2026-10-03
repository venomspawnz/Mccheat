package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
public class Longjump extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public float boost = 3.0f;
    public Longjump() { super("Longjump", Category.MOVEMENT, 0); }
    @Override public void onEnable() {
        if (mc.player == null) return;
        if (mc.player.isOnGround()) {
            double yaw = Math.toRadians(mc.player.getYaw());
            mc.player.setVelocity(-Math.sin(yaw) * boost, 0.5, Math.cos(yaw) * boost);
        }
    }
}
