package tutorialmod.client.render;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import tutorialmod.entities.TutorialEntity;

// this registers the renderer of the entity
@OnlyIn(Dist.CLIENT)
public class TutorialRenderRegistry {
	
	public static void registerEntityRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(TutorialEntity.class,new TutorialEntityRender.RenderFactory());
	}
}
