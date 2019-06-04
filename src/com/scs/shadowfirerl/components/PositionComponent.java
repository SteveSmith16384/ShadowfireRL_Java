package com.scs.shadowfirerl.components;

import com.scs.ecs.components.AbstractComponent;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.shadowfirerl.models.MapData;

public class PositionComponent extends AbstractComponent {

	public int x, y;
	public boolean blocks_movement;
	
	public PositionComponent(AbstractEntity e, MapData map_data, int _x, int _y, boolean _blocks_movement) {
		super();
		
		x = _x;
		y = _y;
		blocks_movement = _blocks_movement;
		
		map_data.map[x][y].add(e);
	}

}
