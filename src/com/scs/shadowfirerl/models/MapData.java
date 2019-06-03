package com.scs.shadowfirerl.models;

import java.util.ArrayList;
import java.util.List;

import com.scs.ecs.entities.AbstractEntity;
import com.scs.shadowfirerl.EntityFactory;

public class MapData {

	public List<AbstractEntity> map[][];

	public MapData() {
	}
	
	
	public void createMap(EntityFactory factory) {
		int w = 50;
		int h = 50;
		map = new ArrayList[w][h];
		for (int y=0 ; y<getHeight() ; y++) {
			for (int x=0 ; x<getWidth() ; x++) {
				map[x][y] = new ArrayList<>();
				factory.createMapSquare(x, y);
			}			
		}
	}


	public int getWidth() {
		return map.length;
	}


	public int getHeight() {
		return map[0].length;
	}


}
