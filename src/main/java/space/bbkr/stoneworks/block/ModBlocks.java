package space.bbkr.stoneworks.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import space.bbkr.stoneworks.block.*;

public class ModBlocks {

    public static BlockStoneworks stoneworks = new BlockStoneworks();

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                stoneworks
        );
        GameRegistry.registerTileEntity(stoneworks.getTileEntityClass(), stoneworks.getRegistryName().toString());
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                stoneworks.createItemBlock()
        );
    }

    public static void registerModels() {
        stoneworks.registerItemModel(Item.getItemFromBlock(stoneworks));
    }

}
