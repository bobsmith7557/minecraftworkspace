package tutorialmod.client.models;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tutorialmod.entities.TutorialEntity;

// this is the model for the entity, we will also need to add to this further
@OnlyIn(Dist.CLIENT)
public class TutorialEntityModel extends EntityModel<TutorialEntity> {

}
