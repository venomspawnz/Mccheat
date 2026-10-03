package com.mccheat.module.modules.combat;
import com.mccheat.module.Module;
public class HitboxExpander extends Module {
    public float expand = 0.3f;
    public HitboxExpander() { super("HitboxExpander", Category.COMBAT, 0); }
    // Mixin hook on Entity.getBoundingBox expands box by expand value
}
