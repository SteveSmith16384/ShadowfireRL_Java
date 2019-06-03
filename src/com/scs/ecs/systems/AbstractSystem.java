package com.scs.ecs.systems;

import java.util.List;

import com.scs.ecs.entities.AbstractEntity;

public abstract class AbstractSystem {

	public AbstractSystem() {
		// TODO Auto-generated constructor stub
	}

	
	public void process(List<AbstractEntity> entities) {
		for (AbstractEntity entity : entities) {
			this.processEntity(entity);
		}
	}
	
	
	public abstract void processEntity(AbstractEntity entity);
}
