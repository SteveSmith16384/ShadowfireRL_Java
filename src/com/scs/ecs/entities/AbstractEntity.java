package com.scs.ecs.entities;

import java.util.HashMap;

import com.scs.ecs.components.AbstractComponent;

public class AbstractEntity {

	private static int next_id = 0;
	
	public int id;
	public HashMap<String, AbstractComponent> components = new HashMap<>();
	
	public AbstractEntity() {
		id = next_id++;
	}

	
	public void addComponent(AbstractComponent component) {
		this.components.put(component.getName(), component);
	}
	
	
	public AbstractComponent getComponent(String name) {
		return this.components.get(name);
	}
}
