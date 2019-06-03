package com.scs.shadowfirerl;

import com.scs.ecs.AbstractEcs;
import com.scs.ecs.components.PositionComponent;
import com.scs.ecs.entities.AbstractEntity;

public class EntityFactory {

	private AbstractEcs ecs;
	
	public EntityFactory(AbstractEcs _ecs) {
		ecs = _ecs;
	}

	
	public AbstractEntity createPlayersUnit() {
		AbstractEntity e = new AbstractEntity();
		e.addComponent(new PositionComponent());
		ecs.entities.add(e);
		return e;
	}
}
