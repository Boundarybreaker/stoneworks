package space.bbkr.stoneworks;

import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import space.bbkr.stoneworks.client.gui.ModGuiHandler;
import space.bbkr.stoneworks.proxy.CommonProxy;
import space.bbkr.stoneworks.block.ModBlocks;

@Mod(
        modid = Stoneworks.MOD_ID,
        name = Stoneworks.MOD_NAME,
        version = Stoneworks.VERSION
)
public class Stoneworks {

    public static final String MOD_ID = "stoneworks";
    public static final String MOD_NAME = "Stoneworks";
    public static final String VERSION = "1.0";


    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    @Mod.Instance(MOD_ID)
    public static Stoneworks instance;

    @SidedProxy(serverSide = "space.bbkr.stoneworks.proxy.CommonProxy", clientSide = "space.bbkr.stoneworks.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Too much cobble? No such thing! " + MOD_NAME + " is loading!");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            //ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            //ModItems.registerModels();
            ModBlocks.registerModels();
        }

    }
    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    public static class MySpecialItem extends Item {

    }

    public static class MySpecialBlock extends Block {

    }
    */
}
