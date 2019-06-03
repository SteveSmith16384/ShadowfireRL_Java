package com.scs.ecs.components;

public abstract class AbstractComponent {

	public AbstractComponent() {
	}

	
	public String getName() {
		return this.getClass().getSimpleName();
	}
}
