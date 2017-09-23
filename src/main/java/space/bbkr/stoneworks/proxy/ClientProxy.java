package space.bbkr.stoneworks.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import space.bbkr.stoneworks.Stoneworks;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Stoneworks.MOD_ID + ":" + id, "inventory"));
    }
}
