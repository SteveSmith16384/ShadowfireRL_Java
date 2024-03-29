package com.scs.shadowfirerl.systems;

import java.util.List;

import com.scs.ecs.BasicEcs;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.ecs.systems.AbstractSystem;
import com.scs.shadowfirerl.components.MovementDataComponent;
import com.scs.shadowfirerl.components.PositionComponent;
import com.scs.shadowfirerl.models.MapData;

public class MovementSystem extends AbstractSystem {

	private MapData map_data;

	public MovementSystem(MapData _map_data) {
		map_data = _map_data;
	}


	@Override
	public void processEntity(AbstractEntity entity) {
		MovementDataComponent md = (MovementDataComponent)entity.getComponent(MovementDataComponent.class.getSimpleName());
		PositionComponent p = (PositionComponent)entity.getComponent(PositionComponent.class.getSimpleName());
		if (md != null && p != null) {
			if (md.offX != 0 || md.offY != 0) {

				// Check the square is accessible
				if (isAccessible(map_data.map[p.x+md.offX][p.y+md.offY])) {
					map_data.map[p.x][p.y].remove(entity);

					p.x += md.offX;
					p.y += md.offY;		

					map_data.map[p.x][p.y].add(entity);
				}
				// Reset movement for next turn
				md.offX = 0;
				md.offY = 0;
			}
		}
	}


	private boolean isAccessible(List<AbstractEntity> entities) {
		for (AbstractEntity entity : entities) {
			PositionComponent p = (PositionComponent)entity.getComponent(PositionComponent.class.getSimpleName());
			if (p.blocks_movement) {
				return false;
			}
		}
		return true;
	}

}
