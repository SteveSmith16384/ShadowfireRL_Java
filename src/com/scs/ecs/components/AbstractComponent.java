package com.scs.ecs.components;

public abstract class AbstractComponent {

	//public String name;
	
	public AbstractComponent(String _name) { // todo - remove param
		//name = _name;
	}

	
	public String getName() {
		return this.getClass().getSimpleName();
	}
}
