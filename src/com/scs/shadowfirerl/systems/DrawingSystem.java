package com.scs.shadowfirerl.systems;

import java.util.List;

import com.googlecode.lanterna.TextCharacter;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.ecs.systems.AbstractSystem;
import com.scs.rogueframework.IGameView;
import com.scs.shadowfirerl.components.GraphicComponent;
import com.scs.shadowfirerl.models.MapData;

public class DrawingSystem extends AbstractSystem {

	private IGameView view;
	private MapData map_data;

	public DrawingSystem(IGameView _view, MapData _map_data) {
		view = _view;
		map_data = _map_data;
	}


	@Override
	public void process(List<AbstractEntity> entities) {
		// Draw map
		for (int y=0 ; y<map_data.getHeight() ; y++) {
			for (int x=0 ; x<map_data.getWidth() ; x++) {
				for (AbstractEntity sq : map_data.map[x][y]) {
					GraphicComponent gc = (GraphicComponent)sq.getComponent(GraphicComponent.class.getSimpleName());
					TextCharacter tc = gc.getChar();
					view.drawCharacter(x, y, tc);
				}
			}			
		}
	}

}
