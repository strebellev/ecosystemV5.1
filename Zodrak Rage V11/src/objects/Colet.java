package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Colet {
	PApplet parent;
	ArrayList<PVector> colet;
	public PVector position;
	
	int r;
	
	@SuppressWarnings("deprecation")
	public Colet(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		colet = new ArrayList<PVector>();
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		colet.add(l.get());
	}
	
	public void display(PApplet p){
		PImage img = parent.loadImage("res/object/colet.png");
		p.image(img, position.x-32, position.y-16);
	}
	
	public ArrayList<PVector> getColet(){
		return colet;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
