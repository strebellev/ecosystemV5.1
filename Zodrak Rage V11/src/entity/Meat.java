package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Meat {
	PApplet parent;
	ArrayList<PVector> meat;
	public PVector position;
	
	int r;
	int imgnum = 1;
	
	float meatLive;
	
	PImage[] imgMeat = new PImage[imgnum];
	
	@SuppressWarnings("deprecation")
	public Meat(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		imgMeat[0] = p.loadImage("res/animal/meat/meat.png");
		meatLive = 255;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		meat.add(l.get());
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		//p.fill(0);
		p.stroke(0);
		p.strokeWeight(2);
		//p.ellipse(position.x, position.y, territoire, territoire);
		p.noFill();
		p.noStroke();
		p.image(imgMeat[0], position.x-16, position.y-16);
		//p.text("meatLive " + meatLive, position.x+10, position.y);

	}
	
	public ArrayList<PVector> getMeat(){
		return meat;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
	
	public void growOld(){
		meatLive -= 0.05;
	}
	
	public boolean rotten(){
		if(meatLive < 0.0){
			return true;
		}
		else{
			return false;
		}
	}


}
