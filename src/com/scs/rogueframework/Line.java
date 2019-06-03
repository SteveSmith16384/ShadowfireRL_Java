package com.scs.rogueframework;

import java.awt.Point;
import java.util.ArrayList;

public class Line extends ArrayList<Point> {

	private static final long serialVersionUID = 1L;

	public Line(int x0, int y0, int x1, int y1) {
		int dx = Math.abs(x1-x0);
		int dy = Math.abs(y1-y0);

		int sx = x0 < x1 ? 1 : -1;
		int sy = y0 < y1 ? 1 : -1;
		int err = dx-dy;

		while (true){
			add(new Point(x0, y0));

			if (x0==x1 && y0==y1)
				break;

			int e2 = err * 2;
			if (e2 > -dx) {
				err -= dy;
				x0 += sx;
			}
			if (e2 < dx){
				err += dx;
				y0 += sy;
			}
		}
	}


}
