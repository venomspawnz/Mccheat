package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
public class Step extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public float height = 1.0f;
    public Step() { super("Step", Category.MOVEMENT, 0); }
    @Override public void onEnable()  { if (mc.player != null) mc.player.setStepHeight(height); }
    @Override public void onDisable() { if (mc.player != null) mc.player.setStepHeight(0.6f); }
}
