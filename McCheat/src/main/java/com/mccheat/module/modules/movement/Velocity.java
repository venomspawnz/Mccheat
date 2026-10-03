package com.mccheat.module.modules.movement;
import com.mccheat.module.Module;
public class Velocity extends Module {
    public float horizontal = 0.0f;
    public float vertical   = 0.0f;
    public Velocity() { super("Velocity", Category.MOVEMENT, 0); }
    // Mixin hook on PlayerEntity.takeKnockback multiplies by horizontal/vertical
}
