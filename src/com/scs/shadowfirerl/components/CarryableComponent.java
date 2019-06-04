package com.scs.shadowfirerl.components;

import com.scs.ecs.components.AbstractComponent;

public class CarryableComponent extends AbstractComponent {
	
	public float weight;
	
	public CarryableComponent(float _weight) {
		weight = _weight;
	}

}
