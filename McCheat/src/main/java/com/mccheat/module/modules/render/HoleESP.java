package com.mccheat.module.modules.render;
import com.mccheat.McCheat;
import com.mccheat.event.EventRender;
import com.mccheat.module.Module;
import com.mccheat.render.RenderUtil;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
public class HoleESP extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public HoleESP() {
        super("HoleESP", Category.RENDER, 0);
        McCheat.eventBus.subscribe(EventRender.class, this::onRender);
    }
    private void onRender(EventRender e) {
        if (!enabled || mc.world == null || mc.player == null) return;
        BlockPos origin = mc.player.getBlockPos();
        for (int x = -8; x <= 8; x++) for (int z = -8; z <= 8; z++) {
            BlockPos p = origin.add(x, -1, z);
            if (isSafeHole(p)) RenderUtil.drawBlockOutline(e.matrices, p, 0x00FFFF);
        }
    }
    private boolean isSafeHole(BlockPos p) {
        if (mc.world == null) return false;
        boolean floor = mc.world.getBlockState(p).getBlock() == Blocks.OBSIDIAN ||
                        mc.world.getBlockState(p).getBlock() == Blocks.BEDROCK;
        boolean air   = mc.world.getBlockState(p.up()).isAir();
        return floor && air;
    }
}
