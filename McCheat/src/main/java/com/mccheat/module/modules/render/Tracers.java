package com.mccheat.module.modules.render;
import com.mccheat.McCheat;
import com.mccheat.event.EventRender;
import com.mccheat.module.Module;
import com.mccheat.render.RenderUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
public class Tracers extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public Tracers() {
        super("Tracers", Category.RENDER, 0);
        McCheat.eventBus.subscribe(EventRender.class, this::onRender);
    }
    private void onRender(EventRender e) {
        if (!enabled || mc.world == null) return;
        mc.world.getEntities().forEach(entity -> {
            if (entity instanceof PlayerEntity && entity != mc.player)
                RenderUtil.drawTracer(e.matrices, entity, 0xFF4444);
        });
    }
}
