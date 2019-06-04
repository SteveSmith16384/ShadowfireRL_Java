package com.scs.shadowfirerl.systems;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.scs.ecs.entities.AbstractEntity;
import com.scs.ecs.systems.AbstractSystem;
import com.scs.shadowfirerl.components.CanSeeForPlayerComponent;
import com.scs.shadowfirerl.components.PositionComponent;
import com.scs.shadowfirerl.models.MapData;

public class CheckVisibilitySystem extends AbstractSystem {

	private MapData map_data;

	public CheckVisibilitySystem(MapData _map_data) {
		map_data = _map_data;
	}


	@Override
	public void process(List<AbstractEntity> entities) {
		List<Point> eyes = new ArrayList<>();
		
		// Get list of "player's eyes"
		for (int y=0 ; y<map_data.getHeight() ; y++) {
			for (int x=0 ; x<map_data.getWidth() ; x++) {
				for (AbstractEntity sq : map_data.map[x][y]) {
					CanSeeForPlayerComponent gc = (CanSeeForPlayerComponent)sq.getComponent(CanSeeForPlayerComponent.class.getSimpleName());
					if (gc != null) {
						PositionComponent p = (PositionComponent)sq.getComponent(PositionComponent.class.getSimpleName());
						eyes.add(new Point(p.x, p.y));
					}
				}
			}			
		}

	
		// Get list of "player's eyes"
		for (int y=0 ; y<map_data.getHeight() ; y++) {
			for (int x=0 ; x<map_data.getWidth() ; x++) {
				// todo
			}			
		}

	}

}
