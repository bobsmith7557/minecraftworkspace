package tutorialmod;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.item.Item;
import tutorialmod.entities.TutorialEntity;
import tutorialmod.TutorialModRegistries;
// sets up creating a new entity 
public class TutorialEntities {
	// this creates a new entity
	public static EntityType<?> TUTORIAL_ENTITY = EntityType.Builder.create(TutorialEntity::new, EntityClassification.MONSTER).build(TutorialModRegistries.MODID + ":tutorial entity").setRegistryName(TutorialModRegistries.location("tutorial entity"));
	// this creates a spawn egg for the entity
	public static void registerEntitiySpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
			TutorialItems.tutorial_entity_egg = registerEntitySpawnEgg(TUTORIAL_ENTITY, 0x326ba8, 0x3296a8,"yeti")
			);
	}
	
	// this tells where the entity will spawn
	public static void registerEntityWorldSpawns() {
		
		registerEntityWorldSpawn(TUTORIAL_ENTITY, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST, Biomes.SNOWY_MOUNTAINS,
				Biomes.SNOWY_TUNDRA, Biomes.SNOWY_TAIGA);
	}
	// this creates what the color of the egg will look like
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name){
		SpawnEggItem Item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(MainClass.TUTORIAL));
		item.setRegistryName(TutorialModRegistries.location(name));
		return Item;
	}
	// registers how many can spawn near each other
	public static void registerEntityWorldSpawn(EntityType<?> entity,Biome...biomes) {
		
		for(Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 5, 1, 2));
			}
		}
	}
	
}
