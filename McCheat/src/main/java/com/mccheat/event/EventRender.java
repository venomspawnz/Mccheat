package com.mccheat.event;
import net.minecraft.client.util.math.MatrixStack;
public class EventRender {
    public final MatrixStack matrices;
    public final float tickDelta;
    public EventRender(MatrixStack matrices, float tickDelta) {
        this.matrices = matrices; this.tickDelta = tickDelta;
    }
}
