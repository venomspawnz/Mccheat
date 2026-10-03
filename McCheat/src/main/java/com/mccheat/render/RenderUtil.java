package com.mccheat.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

public class RenderUtil {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void drawBoundingBox(MatrixStack matrices, Entity entity, int color) {
        if (mc.getEntityRenderDispatcher().camera == null) return;
        Camera cam = mc.getEntityRenderDispatcher().camera;
        Vec3d camPos = cam.getPos();

        double x = entity.getLerpedX(mc.getRenderTickCounter().getTickDelta(true)) - camPos.x;
        double y = entity.getLerpedY(mc.getRenderTickCounter().getTickDelta(true)) - camPos.y;
        double z = entity.getLerpedZ(mc.getRenderTickCounter().getTickDelta(true)) - camPos.z;

        Box bb = entity.getBoundingBox();
        double hw = (bb.maxX - bb.minX) / 2.0;
        double h  =  bb.maxY - bb.minY;

        matrices.push();
        matrices.translate(x, y, z);
        drawBox(matrices, -hw, 0, -hw, hw, h, hw, color);
        matrices.pop();
    }

    public static void drawTracer(MatrixStack matrices, Entity entity, int color) {
        // Line from screen center to entity — drawn via line primitive
        // Implementation requires VertexConsumer with RenderLayer.LINES
    }

    public static void drawBlockOutline(MatrixStack matrices, BlockPos pos, int color) {
        if (mc.getEntityRenderDispatcher().camera == null) return;
        Vec3d camPos = mc.getEntityRenderDispatcher().camera.getPos();
        matrices.push();
        matrices.translate(pos.getX() - camPos.x, pos.getY() - camPos.y, pos.getZ() - camPos.z);
        drawBox(matrices, 0, 0, 0, 1, 1, 1, color);
        matrices.pop();
    }

    private static void drawBox(MatrixStack matrices, double x1, double y1, double z1,
                                 double x2, double y2, double z2, int color) {
        float r = ((color >> 16) & 0xFF) / 255f;
        float g = ((color >>  8) & 0xFF) / 255f;
        float b = ( color        & 0xFF) / 255f;
        // Wire box — 12 edges
        Matrix4f mat = matrices.peek().getPositionMatrix();
        // Simplified: actual rendering requires access to immediate VertexConsumer from render context
        // In real implementation, passed from WorldRenderer mixin
    }
}
