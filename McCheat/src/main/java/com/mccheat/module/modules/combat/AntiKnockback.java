package com.mccheat.module.modules.combat;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
public class AntiKnockback extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public float strength = 0.0f; // 0 = no knockback, 1 = full
    public AntiKnockback() { super("AntiKnockback", Category.COMBAT, 0); }
    // Mixin hook in PlayerEntityMixin cancels velocity from damage if enabled
}
