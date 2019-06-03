package com.scs.shadowfirerl;

import java.io.IOException;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.scs.ecs.BasicEcs;
import com.scs.ecs.entities.AbstractEntity;
import com.scs.rogueframework.IGameView;
import com.scs.rogueframework.views.LanternaView;
import com.scs.shadowfirerl.models.MapData;
import com.scs.shadowfirerl.systems.DrawingSystem;

import ssmith.audio.SoundCacheThread;

public class Main {

	private MapData map_data;
	private BasicEcs ecs;
	private EntityFactory factory;
	protected IGameView view;
	public SoundCacheThread sfx;

	private boolean stopNow = false;

	public Main() {
		sfx = new SoundCacheThread("todo");
		view = new LanternaView();

		ecs = new BasicEcs();
		map_data = new MapData();
		factory = new EntityFactory(ecs, map_data);
		
		// Add systems
		ecs.systems.add(new DrawingSystem(view, map_data));
		
		createData();
		
		this.mainGameLoop();
		
	}

	
	private void createData() {
		map_data.createMap(this.factory);
		
		factory.createPlayersUnit(5, 5);

	}

	
	private void mainGameLoop() {
		while (true) {
			view.startScreen();
			view.clear();
			
			ecs.process();
			
			view.refresh();

			try {
				KeyStroke key = view.getInput();
				processInput(key);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void processInput(KeyStroke key) {
		
	}
	

	public static void main(String[] args) {
		new Main();

	}

}
