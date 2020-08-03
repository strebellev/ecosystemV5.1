package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class InGameClock {
	PApplet parent;
	ArrayList<PVector> ingameclock;
	
	public int time = 0;
	int seconds;
	int minutes;
	public float hour;
	int day;
	int week;
	int month;
	int year;
	
	
	
	public int startingTime = 8;
	
	public InGameClock(PApplet p){
		parent = p;
		ingameclock = new ArrayList<PVector>();
	}
	
	
	public void clocktick(){
		time = parent.millis();
		seconds = (int) (time/1000)*720;
		minutes = seconds/60;
		hour = minutes/60 + startingTime ;
		day = (int) (hour/24);
		month = day/30;
		year = month/12;
		
		hour -= day*24;
		minutes -= day*24*60 +hour*60;
		seconds -= day*24*60*60 +hour*60*60 + minutes*60;
	}
	
	public void sleep8h(){
		hour += 8;
	}
	
	public float getTime(){
		return time;
	}
	
	public float getSeconds(){
		return seconds;
	}
	
	public float getMinutes(){
		return minutes;
	}
	
	public float gethour(){
		return hour;
	}

	public float getday(){
		return day;
	}
	
	public boolean newDay(){
		if(hour <=1) return true;
		else return false;
	}
	
	
}
