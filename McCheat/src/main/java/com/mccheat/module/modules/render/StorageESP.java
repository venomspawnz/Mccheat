package com.mccheat.module.modules.render;
import com.mccheat.McCheat;
import com.mccheat.event.EventRender;
import com.mccheat.module.Module;
import com.mccheat.render.RenderUtil;
import net.minecraft.block.entity.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
public class StorageESP extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public StorageESP() {
        super("StorageESP", Category.RENDER, 0);
        McCheat.eventBus.subscribe(EventRender.class, this::onRender);
    }
    private void onRender(EventRender e) {
        if (!enabled || mc.world == null) return;
        mc.world.blockEntities.forEach((pos, be) -> {
            if (be instanceof ChestBlockEntity || be instanceof BarrelBlockEntity ||
                be instanceof ShulkerBoxBlockEntity) {
                RenderUtil.drawBlockOutline(e.matrices, pos, 0xFFAA00);
            }
        });
    }
}
