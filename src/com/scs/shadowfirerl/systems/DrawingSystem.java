package com.scs.shadowfirerl.systems;

import com.scs.ecs.components.AbstractComponent;
import com.scs.ecs.components.PositionComponent;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.ecs.systems.AbstractSystem;

public class DrawingSystem extends AbstractSystem {

	public DrawingSystem() {
	}


	@Override
	public void processEntity(AbstractEntity entity) {
		AbstractComponent c = entity.getComponent(PositionComponent.class.getSimpleName());
		
	}

}
