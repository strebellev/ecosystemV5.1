package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class TentLvl0 {
	PApplet parent;
	ArrayList<PVector> tentlvl0;
	public PVector position;
	
	int r;
	
	public boolean sleep8h;
	
	@SuppressWarnings("deprecation")
	public TentLvl0(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		tentlvl0 = new ArrayList<PVector>();
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		tentlvl0.add(l.get());
	}
	
	public void display(PApplet p){
		PImage img = parent.loadImage("res/object/tent/tentDry2.png");
		p.image(img, position.x-50, position.y-98);
	}
	
	public ArrayList<PVector> getTent(){
		return tentlvl0;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
	
	public void getToSleep(){
		sleep8h = true;
	}

}
