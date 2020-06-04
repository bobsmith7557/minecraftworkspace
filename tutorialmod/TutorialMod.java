package tutorialmod;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import tutorialmod.client.render.TutorialRenderRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// this is suppose to bring everything together
@Mod("tutorial mod")
public class TutorialMod {
	
	public static TutorialMod instance;
	public static final String MODID = "tutorialmod";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup TUTORIAL = new TutorialItemGroup();


public TutorialMod() {
	
	instance = this;
	// this connects the entity to the servers 
	ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "tutorialmod-server.toml");
	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "tutorialmod-client.toml");
	
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
	
	Config.LoadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("tutorialmod-client.toml").toString());
	Config.LoadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("tutorialmod-server.toml").toString());
	
	MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		// don't worry about this too much, maybe
		OreGeneration.setupOreGeneration();
		LOGGER.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		
		TutorialRenderRegistry.registerEntityRenderers();
		LOGGER.info("ClientRegistries method registered.");
	}
}