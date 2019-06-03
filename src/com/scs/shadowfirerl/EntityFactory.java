package com.scs.shadowfirerl;

import com.googlecode.lanterna.TextColor;
import com.scs.ecs.BasicEcs;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.shadowfirerl.components.GraphicComponent;
import com.scs.shadowfirerl.components.PositionComponent;
import com.scs.shadowfirerl.models.MapData;

public class EntityFactory {

	private BasicEcs ecs;
	private MapData map_data;
	
	public EntityFactory(BasicEcs _ecs, MapData _map_data) {
		ecs = _ecs;
		map_data = _map_data;
	}

	
	public AbstractEntity createMapSquare(int x, int y) {
		AbstractEntity e = new AbstractEntity();
		e.addComponent(new PositionComponent(e, map_data, x, y));
		e.addComponent(new GraphicComponent('.', TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
		ecs.entities.add(e);
		return e;
	}
	
	
	public AbstractEntity createPlayersUnit(int x, int y) {
		AbstractEntity e = new AbstractEntity();
		e.addComponent(new PositionComponent(e, map_data, x, y));
		e.addComponent(new GraphicComponent('1', TextColor.ANSI.GREEN, TextColor.ANSI.BLACK));
		ecs.entities.add(e);
		return e;
	}
}
