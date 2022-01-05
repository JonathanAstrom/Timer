package application;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Time {

	private int hour;
	private int minute;
	private int second;
	private int mill;



	public Time(int hour, int minute, int second, int mill) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.mill = mill;
	}
	
	public Time(String currentTime) {
		String[] time = currentTime.split(":");
		hour = Integer.parseInt(time[0]);
		minute = Integer.parseInt(time[1]);
		second = Integer.parseInt(time[2]);
		mill = Integer.parseInt(time[3]);
	}
	
	public String getCurrentTime() {
		NumberFormat formatter = new DecimalFormat("00");
		return formatter.format(hour) + ":" + formatter.format(minute) + ":" + formatter.format(second) + ":" + mill;
	}
//	public String getCurrentDate() {
//		NumberFormat formatter = new DecimalFormat("00");
//		return formatter.format(hour) + ":" + formatter.format(minute) + ":" + formatter.format(second) + ":" + mill;
//	}
	
	public void oneSecondPassed() {
		mill++;
		if (mill == 100) {
			second++;
			mill = 0;
			if (second == 60) {
				minute++;
				second = 0;
				if (minute == 60) {
					hour++;
					minute = 0;
					if (hour == 24) {
						hour = 0;
					}
				}
			}
		}
	}

}
