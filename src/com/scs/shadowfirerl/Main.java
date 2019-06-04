package com.scs.shadowfirerl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.scs.ecs.BasicEcs;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.rogueframework.IGameView;
import com.scs.rogueframework.views.LanternaView;
import com.scs.shadowfirerl.components.MovementDataComponent;
import com.scs.shadowfirerl.models.MapData;
import com.scs.shadowfirerl.systems.DrawingSystem;
import com.scs.shadowfirerl.systems.EnemyAISystem;
import com.scs.shadowfirerl.systems.MovementSystem;

import ssmith.audio.SoundCacheThread;

public class Main {

	public static final Random RND = new Random();
	
	private MapData map_data;
	private BasicEcs ecs;
	private EntityFactory factory;
	protected IGameView view;
	public SoundCacheThread sfx;

	//private boolean stopNow = false;
	private AbstractEntity current_entity;
	private List<AbstractEntity> players_entities;
	

	public Main() {
		sfx = new SoundCacheThread("todo");
		view = new LanternaView();

		players_entities = new ArrayList<AbstractEntity>();
		
		ecs = new BasicEcs();
		map_data = new MapData();
		factory = new EntityFactory(ecs, map_data);

		// Add systems
		//ecs.systems.add(new DrawingSystem(view, map_data));
		ecs.systems.add(new MovementSystem(map_data));
		ecs.systems.add(new EnemyAISystem());

		createData();

		this.mainGameLoop();

	}


	private void createData() {
		map_data.createMap(this.factory);

		current_entity = factory.createPlayersUnit("Dallas", 5, 5);
	}


	private void mainGameLoop() {
		DrawingSystem ds = new DrawingSystem(view, map_data);
		
		while (true) {
			try {
				ecs.process();

				view.startScreen();
				view.clear();
				ds.process();
				view.refresh();

				KeyStroke key = view.getInput();
				processInput(key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	private void processInput(KeyStroke key) {
		MovementDataComponent md = (MovementDataComponent)this.current_entity.getComponent(MovementDataComponent.class.getSimpleName());
		if (md != null) {
			if (key.getKeyType() == KeyType.ArrowUp) {
				md.offY = -1;
			}
			if (key.getKeyType() == KeyType.ArrowDown) {
				md.offY = 1;
			}
			if (key.getKeyType() == KeyType.ArrowLeft) {
				md.offX = -1;
			}
			if (key.getKeyType() == KeyType.ArrowRight) {
				md.offX = 1;
			}
		}
	}


	public static void main(String[] args) {
		new Main();
	}

}
