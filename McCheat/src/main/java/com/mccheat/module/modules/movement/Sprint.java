package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
public class Sprint extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public Sprint() { super("Sprint", Category.MOVEMENT, 0); }
    @Override public void onTick() { if (mc.player != null) mc.player.setSprinting(true); }
}
