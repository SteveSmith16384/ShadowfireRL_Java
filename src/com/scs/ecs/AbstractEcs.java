package com.scs.ecs;

import java.util.ArrayList;
import java.util.List;

import com.scs.ecs.entities.AbstractEntity;
import com.scs.ecs.systems.AbstractSystem;

public class AbstractEcs {

	public List<AbstractSystem> systems = new ArrayList<>();
	public List<AbstractEntity> entities = new ArrayList<>();
	
	
	public AbstractEcs() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void process() {
		for(AbstractSystem system : systems) {
			system.process(entities);
		}
	}

}
