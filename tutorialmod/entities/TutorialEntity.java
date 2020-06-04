package tutorialmod.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import tutorialmod.TutorialEntities;
// this gives the movement and attributes of the entity
public class TutorialEntity extends CreatureEntity {

	@SuppressWarnings("unchecked")
	public TutorialEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
		super((EntityType<? extends CreatureEntity>) TutorialEntities.TUTORIAL_ENTITY, worldIn);
		
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 5));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 25, true));
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 25));
		
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(50.0d);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0d);
		this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(35.0d);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(25.0d);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.0d);
		
	}
	
	
}
