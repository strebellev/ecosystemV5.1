package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class GrassFeuillu {
	PApplet parent;
	ArrayList<PVector> grassfeuillu;
	public PVector position;
	
	int r;
	
	public int randomGrass;
	
	int loadAnimGrass = 2;
	
	PImage[] animGrass = new PImage[loadAnimGrass];
	
	
	@SuppressWarnings("deprecation")
	public GrassFeuillu(PApplet p,PVector l){
		position = l.get();
		parent = p;
		r = 32;
		grassfeuillu = new ArrayList<PVector>();
		randomGrass = (int) p.random(2);
		animGrass[0] = p.loadImage("res/newvegetal/grassfeuillu/grassfeuillu0.png");
		animGrass[1] = p.loadImage("res/newvegetal/grassfeuillu/grassfeuillu1.png");
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		grassfeuillu.add(l.get());
	}
	
	public void display(PApplet p){
		if(randomGrass == 0){
			p.image(animGrass[0], position.x-50, position.y-50);
		}
		else if(randomGrass == 1){
			p.image(animGrass[1], position.x-49, position.y-53);
		}
	}
	
	public ArrayList<PVector> getGrassFeuillu(){
		return grassfeuillu;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
