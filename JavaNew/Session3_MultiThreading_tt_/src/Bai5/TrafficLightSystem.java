package Bai5;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TrafficLightSystem {

	public enum TrafficLightColor {
		RED, YELLOW, GREEN
	}
	
	public static void main(String[] args) {
		TrafficLightColor[] trafficLights = {TrafficLightColor.RED, TrafficLightColor.YELLOW, TrafficLightColor.GREEN};
		int currentLightIndex = 0;
		int red=0,yellow=0, green = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap cai dat den ");
		System.out.println("red: "); red=sc.nextInt();
		System.out.println("yellow: "); yellow=sc.nextInt();
		System.out.println("green: "); green=sc.nextInt();
		
		while (true) {
			TrafficLightColor currentLight = trafficLights[currentLightIndex];
			System.out.println("Den hien tai " + currentLight);
			
			switch(currentLight) {
				case RED:
					sleep(red);
					break;
				case YELLOW:
					sleep(yellow);
					break;
				case GREEN:
					sleep(green);
					break;
			}
			currentLightIndex = (currentLightIndex+1)%trafficLights.length;
		}
	}
	private static void sleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
