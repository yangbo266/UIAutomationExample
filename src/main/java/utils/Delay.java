package utils;

import java.util.concurrent.TimeUnit;

public class Delay {

	public Delay() {
	}
	
	public static void sleep(int millisecond) {
		try {
			TimeUnit.MILLISECONDS.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
