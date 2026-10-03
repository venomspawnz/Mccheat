package com.mccheat.module.modules.combat;
import com.mccheat.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
public class AutoTotem extends Module {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public AutoTotem() { super("AutoTotem", Category.COMBAT, 0); }
    @Override public void onTick() {
        if (mc.player == null) return;
        ItemStack offhand = mc.player.getOffHandStack();
        if (offhand.getItem() == Items.TOTEM_OF_UNDYING) return;
        for (int i = 0; i < mc.player.getInventory().size(); i++) {
            if (mc.player.getInventory().getStack(i).getItem() == Items.TOTEM_OF_UNDYING) {
                mc.interactionManager.clickSlot(
                    mc.player.playerScreenHandler.syncId, i, 40, SlotActionType.SWAP, mc.player);
                break;
            }
        }
    }
}
