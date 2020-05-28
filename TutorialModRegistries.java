package tutorialmod;

import org.apache.logging.log4j.Logger;
import tutorialmod.TutorialEntities;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
// registers the entity
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TutorialModRegistries {

	public static final ItemGroup TUTORIAL = TutorialMod.TUTORIAL;
	public static final Logger LOGGER = TutorialMod.LOGGER;
	public static final String MODID = TutorialMod.MODID;
	// registers the spawn egg
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				TutorialItems.tutorial_item = new Item(new Item.Properties().group(TUTORIAL)).setRegistryName(Location("tutorial_item")),
				);
		TutorialEntities.registerEntitiySpawnEggs(event);
		
		LOGGER.info("Items registered.");
		
		}
	// not really useful for what we are trying to do, don't worry too much about this part
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll();
		LOGGER.info("Blocks registered");
		
	}
	// registers the entity
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		
		event.getRegistry().registerAll(
				TutorialEntities.TUTORIAL_ENTITY	
		);
		
		TutorialEntities.registerEntityWorldSpawns();
	}
	// this returns the resource location
	public static ResourceLocation location(String name) {
		return new ResourceLocation(MODID, name);
	}
}
