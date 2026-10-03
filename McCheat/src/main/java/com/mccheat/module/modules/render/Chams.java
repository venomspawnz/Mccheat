package com.mccheat.module.modules.render;
import com.mccheat.module.Module;
public class Chams extends Module {
    public boolean throughWalls = true;
    public int color = 0xFF0000;
    public Chams() { super("Chams", Category.RENDER, 0); }
    // Mixin hook on EntityRenderer to override model rendering with flat color + no depth test
}
