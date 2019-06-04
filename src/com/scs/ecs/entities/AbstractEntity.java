package com.scs.ecs.entities;

import java.util.HashMap;

import com.scs.ecs.components.AbstractComponent;

public class AbstractEntity {

	private static int next_id = 0;
	
	public final int id;
	public final String name;
	public HashMap<String, AbstractComponent> components = new HashMap<>();
	
	public AbstractEntity(String _name) {
		id = next_id++;
		name = _name;
	}

	
	public void addComponent(AbstractComponent component) {
		this.components.put(component.getName(), component);
	}
	
	
	public AbstractComponent getComponent(String name) {
		return this.components.get(name);
	}
}
