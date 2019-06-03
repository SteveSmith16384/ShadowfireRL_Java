package com.scs.shadowfirerl;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.scs.ecs.BasicEcs;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.rogueframework.IGameView;
import com.scs.rogueframework.views.LanternaView;
import com.scs.shadowfirerl.components.MovementDataComponent;
import com.scs.shadowfirerl.models.MapData;
import com.scs.shadowfirerl.systems.DrawingSystem;
import com.scs.shadowfirerl.systems.MovementSystem;

import ssmith.audio.SoundCacheThread;

public class Main {

	private MapData map_data;
	private BasicEcs ecs;
	private EntityFactory factory;
	protected IGameView view;
	public SoundCacheThread sfx;

	private boolean stopNow = false;
	private AbstractEntity current_entity;

	public Main() {
		sfx = new SoundCacheThread("todo");
		view = new LanternaView();

		ecs = new BasicEcs();
		map_data = new MapData();
		factory = new EntityFactory(ecs, map_data);

		// Add systems
		ecs.systems.add(new DrawingSystem(view, map_data));
		ecs.systems.add(new MovementSystem(map_data));

		createData();

		this.mainGameLoop();

	}


	private void createData() {
		map_data.createMap(this.factory);

		current_entity = factory.createPlayersUnit(5, 5);

	}


	private void mainGameLoop() {
		while (true) {
			try {
				view.startScreen();
				view.clear();

				ecs.process();

				view.refresh();

				KeyStroke key = view.getInput();
				processInput(key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	private void processInput(KeyStroke key) {
		if (key.getKeyType() == KeyType.ArrowUp) {
			MovementDataComponent md = (MovementDataComponent)this.current_entity.getComponent(MovementDataComponent.class.getSimpleName());
			if (md != null) {
				md.offY = 1;
			}
		}
	}


	public static void main(String[] args) {
		new Main();

	}

}
