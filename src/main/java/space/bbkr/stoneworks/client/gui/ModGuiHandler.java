package space.bbkr.stoneworks.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import space.bbkr.stoneworks.container.ContainerStoneworks;
import space.bbkr.stoneworks.tileentity.TileEntityStoneworks;

public class ModGuiHandler implements IGuiHandler {
    public static final int STONEWORKS = 0;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case STONEWORKS:
                return new ContainerStoneworks(player.inventory, (TileEntityStoneworks)world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case STONEWORKS:
                return new GuiStoneworks(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            default:
                return null;
        }
    }

}
