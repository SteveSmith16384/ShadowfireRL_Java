package ssmith.util;

public class NumberFunctions {

	private NumberFunctions() {
	}
	
	
	public static int Clamp(int n, int min, int max) {
		if (n < min) {
			n = min;
		} else if (n > max) {
			n = max;
		}
		return n;
	}

}
