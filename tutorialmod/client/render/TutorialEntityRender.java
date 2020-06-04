package tutorialmod.client.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import tutorialmod.TutorialModRegistries;
import tutorialmod.client.models.TutorialEntityModel;
import tutorialmod.entities.TutorialEntity;

// this renders the entity, we will need to add to this further
@OnlyIn(Dist.CLIENT)
public class TutorialEntityRender extends LivingRenderer<TutorialEntity, TutorialEntityModel> {

	public TutorialEntityRender(EntityRendererManager manager) {
		super(manager, new TutorialEntityModel(), 10);
		
	}
	
	@Override
	protected ResourceLocation getEntityTexture(TutorialEntity entity) {
		return TutorialModRegistries.location("textures/entity/tutorial_entity.png");
	}
	
	public static class RenderFactory implements IRenderFactory<TutorialEntity>{

		@Override
		public EntityRenderer<? super TutorialEntity> createRenderFor(EntityRendererManager manager) {
	
			return new TutorialEntityRender(manager);
		}
	}
}
