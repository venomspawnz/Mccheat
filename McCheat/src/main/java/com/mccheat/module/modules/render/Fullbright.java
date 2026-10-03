package com.mccheat.module.modules.render;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
public class Fullbright extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private float prevGamma;
    public Fullbright() { super("Fullbright", Category.RENDER, 0); }
    @Override public void onEnable() {
        prevGamma = mc.options.getGamma().getValue().floatValue();
        mc.options.getGamma().setValue(1000.0);
    }
    @Override public void onDisable() {
        mc.options.getGamma().setValue((double) prevGamma);
    }
}
