package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
public class Flight extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public enum Mode { VANILLA, PACKET, ELYTRA }
    public Mode mode = Mode.VANILLA;
    public float speed = 0.15f;
    public Flight() { super("Flight", Category.MOVEMENT, 0); }
    @Override public void onEnable() {
        if (mc.player == null) return;
        if (mode == Mode.VANILLA) mc.player.getAbilities().allowFlying = true;
    }
    @Override public void onDisable() {
        if (mc.player == null) return;
        mc.player.getAbilities().allowFlying = false;
        mc.player.getAbilities().flying = false;
    }
    @Override public void onTick() {
        if (mc.player == null) return;
        if (mode == Mode.VANILLA) {
            mc.player.getAbilities().allowFlying = true;
            mc.player.getAbilities().setFlySpeed(speed);
        }
    }
}
