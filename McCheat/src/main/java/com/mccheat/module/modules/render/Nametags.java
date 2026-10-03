package com.mccheat.module.modules.render;
import com.mccheat.module.Module;
public class Nametags extends Module {
    public boolean health = true;
    public boolean ping   = true;
    public boolean armor  = true;
    public Nametags() { super("Nametags", Category.RENDER, 0); }
    // Mixin hook on PlayerEntityRenderer to draw extended nametag overlay
}
