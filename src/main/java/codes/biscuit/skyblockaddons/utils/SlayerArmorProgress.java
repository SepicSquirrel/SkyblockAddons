package codes.biscuit.skyblockaddons.utils;

import codes.biscuit.skyblockaddons.SkyblockAddons;
import codes.biscuit.skyblockaddons.utils.nifty.ChatFormatting;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

@Getter
public class SlayerArmorProgress {

    /** The itemstack that this progress is representing. */
    private final ItemStack itemStack;

    /** The current slayer progress of the item. */
    @Setter private String progressText;

    public SlayerArmorProgress(ItemStack itemStack) {
        this.itemStack = new ItemStack(itemStack.getItem()); // Cloned because we change the helmet color later.

        ChatFormatting color = SkyblockAddons.getInstance().getConfigValues().getRestrictedColor(Feature.SLAYER_INDICATOR);
        this.progressText = color + "55% (§a40❈" + color + ")";

        setHelmetColor();
    }

    SlayerArmorProgress(ItemStack itemStack, String progress) {
        this.itemStack = itemStack;
        this.progressText = progress;
    }

    private void setHelmetColor() {
        if (itemStack.getItem().equals(Items.leather_helmet)) {
            ((ItemArmor)itemStack.getItem()).setColor(itemStack, ChatFormatting.BLACK.getRGB());
        }
    }
}
