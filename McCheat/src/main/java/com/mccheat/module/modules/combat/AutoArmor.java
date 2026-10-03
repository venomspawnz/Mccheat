package com.mccheat.module.modules.combat;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
public class AutoArmor extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public AutoArmor() { super("AutoArmor", Category.COMBAT, 0); }
    @Override public void onTick() {
        if (mc.player == null) return;
        for (int i = 0; i < mc.player.getInventory().size(); i++) {
            ItemStack stack = mc.player.getInventory().getStack(i);
            if (stack.getItem() instanceof ArmorItem armor) {
                int slot = 39 - armor.getSlotType().getEntitySlotId();
                if (mc.player.getInventory().getStack(slot).isEmpty()) {
                    mc.interactionManager.clickSlot(
                        mc.player.playerScreenHandler.syncId, i, 0, SlotActionType.QUICK_MOVE, mc.player);
                }
            }
        }
    }
}
