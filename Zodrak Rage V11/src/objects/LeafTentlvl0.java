package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class LeafTentlvl0 {
	PApplet parent;
	ArrayList<PVector> leaftentlvl0;
	public PVector position;
	
	int r;
	
	public boolean sleep8h;
	
	@SuppressWarnings("deprecation")
	public LeafTentlvl0(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		leaftentlvl0 = new ArrayList<PVector>();
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		leaftentlvl0.add(l.get());
	}
	
	public void display(PApplet p){
		PImage img = parent.loadImage("res/object/tent/tentGreen2.png");
		p.image(img, position.x-50, position.y-98);
	}
	
	public ArrayList<PVector> getTent(){
		return leaftentlvl0;
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
