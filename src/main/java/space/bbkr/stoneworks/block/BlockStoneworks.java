package space.bbkr.stoneworks.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import space.bbkr.stoneworks.Stoneworks;
import space.bbkr.stoneworks.client.gui.ModGuiHandler;
import space.bbkr.stoneworks.tileentity.TileEntityStoneworks;
import space.bbkr.stoneworks.block.BlockTileEntity;

import javax.annotation.Nullable;

public class BlockStoneworks extends BlockTileEntity<TileEntityStoneworks> {

    public BlockStoneworks() {
        super(Material.ROCK, "stoneworks");
    }

    @Override
    public Class<TileEntityStoneworks> getTileEntityClass() {
        return TileEntityStoneworks.class;
    }

    @Nullable
    @Override
    public TileEntityStoneworks createTileEntity(World world, IBlockState state) {
        return new TileEntityStoneworks();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            ItemStack heldItem = player.getHeldItem(hand);
            TileEntityStoneworks tile = getTileEntity(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            player.openGui(Stoneworks.instance, ModGuiHandler.STONEWORKS, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }


}
