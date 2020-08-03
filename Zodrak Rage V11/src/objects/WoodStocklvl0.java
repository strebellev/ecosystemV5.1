package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class WoodStocklvl0 {
	PApplet parent;
	ArrayList<PVector> woodStocklvl0;
	public PVector position;
	
	int r;
	
	@SuppressWarnings("deprecation")
	public WoodStocklvl0(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		woodStocklvl0 = new ArrayList<PVector>();
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		woodStocklvl0.add(l.get());
	}
	
	public void display(PApplet p){
		PImage img = parent.loadImage("res/object/woodstock0.png");
		p.image(img, position.x-32, position.y-16);
	}
	
	public ArrayList<PVector> getTent(){
		return woodStocklvl0;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
