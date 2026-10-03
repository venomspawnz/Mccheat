package com.mccheat.module.modules.combat;
import com.mccheat.module.Module;
public class Reach extends Module {
    public float range = 6.0f; // default MC is 3.0
    public Reach() { super("Reach", Category.COMBAT, 0); }
    // Mixin hook in GameRendererMixin extends raycast distance
}
