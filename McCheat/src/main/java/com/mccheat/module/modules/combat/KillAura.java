package com.mccheat.module.modules.combat;
import com.mccheat.McCheat;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KillAura extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public float range = 4.5f;
    public boolean onlyPlayers = false;
    public boolean rotate = true;

    public KillAura() { super("KillAura", Category.COMBAT, 0); }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) return;

        List<LivingEntity> targets = mc.world.getEntities()
            .stream()
            .filter(e -> e instanceof LivingEntity)
            .map(e -> (LivingEntity) e)
            .filter(e -> e != mc.player)
            .filter(e -> !e.isDead())
            .filter(e -> (!onlyPlayers || e instanceof PlayerEntity))
            .filter(e -> mc.player.distanceTo(e) <= range)
            .sorted(Comparator.comparingDouble(e -> mc.player.distanceTo(e)))
            .collect(Collectors.toList());

        if (targets.isEmpty()) return;
        LivingEntity target = targets.get(0);

        if (rotate) {
            rotateTowards(target);
        }

        if (mc.player.getAttackCooldownProgress(0) >= 1.0f) {
            mc.interactionManager.attackEntity(mc.player, target);
            mc.player.swingHand(Hand.MAIN_HAND);
        }
    }

    private void rotateTowards(Entity target) {
        double dx = target.getX() - mc.player.getX();
        double dy = target.getEyeY() - mc.player.getEyeY();
        double dz = target.getZ() - mc.player.getZ();
        double dist = Math.sqrt(dx*dx + dz*dz);
        float yaw   = (float)(Math.toDegrees(Math.atan2(dz, dx)) - 90.0);
        float pitch = (float)(-Math.toDegrees(Math.atan2(dy, dist)));
        mc.player.setYaw(yaw);
        mc.player.setPitch(pitch);
    }
}
