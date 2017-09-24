package space.bbkr.stoneworks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import space.bbkr.stoneworks.tileentity.TileEntityStoneworks;

public class ContainerStoneworks extends Container {

    public ContainerStoneworks(InventoryPlayer playerInv, final TileEntityStoneworks stoneworks) {
        IItemHandler inventory = stoneworks.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        addSlotToContainer(new SlotItemHandler(inventory, 0, 45, 13) {
            @Override
            public void onSlotChanged() {
                stoneworks.markDirty();
            }
        });

        addSlotToContainer(new SlotItemHandler(inventory, 1, 44, 61) {
            @Override
            public void onSlotChanged() {
                stoneworks.markDirty();
            }
        });
//
//        addSlotToContainer(new SlotItemHandler(inventory, 2, 80, 61) {
//            @Override
//            public void onSlotChanged() {
//                stoneworks.markDirty();
//            }
//        });
//
//        addSlotToContainer(new SlotItemHandler(inventory, 3, 134, 61) {
//            @Override
//            public void onSlotChanged() {
//                stoneworks.markDirty();
//            }
//        });
//
//        addSlotToContainer(new SlotItemHandler(inventory, 4, 134, 12) {
//            @Override
//            public void onSlotChanged() {
//                stoneworks.markDirty();
//            }
//        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k++) {
            addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

            if (index < containerSlots) {
                if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }
}
