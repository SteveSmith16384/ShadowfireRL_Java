package com.scs.ecs;

import java.util.ArrayList;
import java.util.List;

import com.scs.ecs.entities.AbstractEntity;
import com.scs.ecs.systems.AbstractSystem;

public class BasicEcs {

	public List<AbstractSystem> systems = new ArrayList<>();
	public List<AbstractEntity> entities = new ArrayList<>();
	
	
	public BasicEcs() {

	}
	
	
	public void process() {
		for(AbstractSystem system : systems) { // todo -loop backwards
			system.process(entities);
		}
	}

}
