package com.scs.shadowfirerl;

import com.scs.ecs.AbstractEcs;
import com.scs.shadowfirerl.models.MapData;
import com.scs.shadowfirerl.systems.DrawingSystem;

public class Main {

	private MapData map_data;
	private AbstractEcs ecs;
	private EntityFactory factory;
	
	public Main() {
		ecs = new AbstractEcs();
		factory = new EntityFactory(ecs);
		map_data = new MapData();
		
		ecs.systems.add(new DrawingSystem());
		
		factory.createPlayersUnit();
		
		this.mainGameLoop();
		
	}
	
	
	private void mainGameLoop() {
		while (true) {
			ecs.process();
		}
	}
	

	public static void main(String[] args) {
		new Main();

	}

}
