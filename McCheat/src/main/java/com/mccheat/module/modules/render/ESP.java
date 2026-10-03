package com.mccheat.module.modules.render;
import com.mccheat.McCheat;
import com.mccheat.event.EventRender;
import com.mccheat.module.Module;
import com.mccheat.render.RenderUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
public class ESP extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public boolean players = true;
    public boolean mobs    = true;
    public ESP() {
        super("ESP", Category.RENDER, 0);
        McCheat.eventBus.subscribe(EventRender.class, this::onRender);
    }
    private void onRender(EventRender e) {
        if (!enabled || mc.world == null) return;
        for (Entity entity : mc.world.getEntities()) {
            if (entity == mc.player) continue;
            if (entity instanceof PlayerEntity && players) {
                RenderUtil.drawBoundingBox(e.matrices, entity, 0xFF0000); // red for players
            } else if (entity instanceof LivingEntity && mobs) {
                RenderUtil.drawBoundingBox(e.matrices, entity, 0x00FF00); // green for mobs
            }
        }
    }
}
