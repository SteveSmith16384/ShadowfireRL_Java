package com.scs.shadowfirerl.components;

import java.util.ArrayList;
import java.util.List;

import com.scs.ecs.components.AbstractComponent;
import com.scs.ecs.entities.AbstractEntity;

public class CanCarryComponent extends AbstractComponent {

	public List<AbstractEntity> carried_items = new ArrayList<>();
	
	public CanCarryComponent() {
		// TODO Auto-generated constructor stub
	}

}
