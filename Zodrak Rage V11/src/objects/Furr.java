package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;


public class Furr {
	PApplet parent;
	ArrayList<PVector> furr;
	public PVector position;
	
	int r;
	float furrLive;

	@SuppressWarnings("deprecation")
	public Furr(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		furr = new ArrayList<PVector>();
		furrLive = 255;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		furr.add(l.get());
	}

	public void display(PApplet p){
		PImage img = parent.loadImage("res/vegetal/object/furr.png");
		p.image(img, position.x-16, position.y-16);
		//parent.fill(255,255,255);
		//parent.text("furr live " + furrLive, position.x-16, position.y-16);
	}
	
	public ArrayList<PVector> getFurr(){
		return furr;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
	
	public void growOld(){
		furrLive -= 0.05;
	}
	
	public boolean rotten(){
		if(furrLive < 0.0){
			return true;
		}
		else{
			return false;
		}
	}


	
}
