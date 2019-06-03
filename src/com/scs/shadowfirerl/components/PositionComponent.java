package com.scs.shadowfirerl.components;

import com.scs.ecs.components.AbstractComponent;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.shadowfirerl.models.MapData;

public class PositionComponent extends AbstractComponent {

	public int x, y;
	
	public PositionComponent(AbstractEntity e, MapData map_data, int _x, int _y) {
		super();
		
		x = _x;
		y = _y;
		
		map_data.map[x][y].add(e);
	}

}
