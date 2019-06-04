package com.scs.shadowfirerl;

import com.googlecode.lanterna.TextColor;
import com.scs.ecs.BasicEcs;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.shadowfirerl.components.CanCarryComponent;
import com.scs.shadowfirerl.components.CanSeeForPlayerComponent;
import com.scs.shadowfirerl.components.CarryableComponent;
import com.scs.shadowfirerl.components.GraphicComponent;
import com.scs.shadowfirerl.components.MovementDataComponent;
import com.scs.shadowfirerl.components.PositionComponent;
import com.scs.shadowfirerl.models.MapData;

public class EntityFactory {

	private BasicEcs ecs;
	private MapData map_data;
	
	public EntityFactory(BasicEcs _ecs, MapData _map_data) {
		ecs = _ecs;
		map_data = _map_data;
	}

	
	public AbstractEntity createFloorMapSquare(int x, int y) {
		AbstractEntity e = new AbstractEntity("Floor");
		e.addComponent(new PositionComponent(e, map_data, x, y, false));
		e.addComponent(new GraphicComponent('.', TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
		ecs.entities.add(e);
		return e;
	}
	
	
	public AbstractEntity createWallMapSquare(int x, int y) {
		AbstractEntity e = new AbstractEntity("Wall");
		e.addComponent(new PositionComponent(e, map_data, x, y, true));
		e.addComponent(new GraphicComponent('#', TextColor.ANSI.GREEN, TextColor.ANSI.GREEN));
		ecs.entities.add(e);
		return e;
	}
	
	
	public AbstractEntity createPlayersUnit(String name, int x, int y) {
		AbstractEntity e = new AbstractEntity(name);
		e.addComponent(new PositionComponent(e, map_data, x, y, true));
		e.addComponent(new MovementDataComponent());
		e.addComponent(new CanSeeForPlayerComponent());
		e.addComponent(new GraphicComponent('1', TextColor.ANSI.GREEN, TextColor.ANSI.BLACK));
		e.addComponent(new CanCarryComponent());
		ecs.entities.add(e);
		return e;
	}


	public AbstractEntity createEnemyUnit(int x, int y) {
		AbstractEntity e = new AbstractEntity("Enemy");
		e.addComponent(new PositionComponent(e, map_data, x, y, true));
		e.addComponent(new MovementDataComponent());
		e.addComponent(new GraphicComponent('E', TextColor.ANSI.RED, TextColor.ANSI.BLACK));
		e.addComponent(new CanCarryComponent());
		ecs.entities.add(e);
		return e;
	}


	public AbstractEntity createGunItem(int x, int y) {
		AbstractEntity e = new AbstractEntity("Gun");
		e.addComponent(new PositionComponent(e, map_data, x, y, false));
		e.addComponent(new GraphicComponent('L', TextColor.ANSI.YELLOW, TextColor.ANSI.BLACK));
		e.addComponent(new CarryableComponent(1f));
		ecs.entities.add(e);
		return e;
	}


	public AbstractEntity createMedikitItem(int x, int y) {
		AbstractEntity e = new AbstractEntity("Medikit");
		e.addComponent(new PositionComponent(e, map_data, x, y, false));
		e.addComponent(new GraphicComponent('+', TextColor.ANSI.YELLOW, TextColor.ANSI.BLACK));
		e.addComponent(new CarryableComponent(.3f));
		ecs.entities.add(e);
		return e;
	}


}
