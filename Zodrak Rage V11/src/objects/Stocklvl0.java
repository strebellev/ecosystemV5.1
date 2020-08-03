package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Stocklvl0 {
	PApplet parent;
	ArrayList<PVector> stocklvl0;
	public PVector position;
	
	int r;
	
	@SuppressWarnings("deprecation")
	public Stocklvl0(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		stocklvl0 = new ArrayList<PVector>();
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		stocklvl0.add(l.get());
	}
	
	public void display(PApplet p){
		PImage img = parent.loadImage("res/object/stock0.png");
		p.image(img, position.x-32, position.y-16);
	}
	
	public ArrayList<PVector> getStocklvl0(){
		return stocklvl0;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
