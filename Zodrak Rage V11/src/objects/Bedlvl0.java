package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Bedlvl0 {
	PApplet parent;
	ArrayList<PVector> bedlvl0;
	public PVector position;
	
	int r;
	
	public boolean sleep8h;
	
	@SuppressWarnings("deprecation")
	public Bedlvl0(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		bedlvl0 = new ArrayList<PVector>();
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		bedlvl0.add(l.get());
	}
	
	public void display(PApplet p){
		PImage img = parent.loadImage("res/object/bed0.png");
		parent.fill(255,0,0);
		parent.ellipse(position.x-32, position.y-16, 10, 10);
		parent.noFill();
		p.image(img, position.x-32, position.y-16);
	}
	
	public ArrayList<PVector> getBed(){
		return bedlvl0;
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
