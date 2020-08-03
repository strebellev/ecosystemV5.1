package objects;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class vegetalString {
	PApplet parent;
	ArrayList<PVector> vegetalstring;
	public PVector position;
	
	int r;
	
	@SuppressWarnings("deprecation")
	public vegetalString(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		vegetalstring = new ArrayList<PVector>();
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		vegetalstring.add(l.get());
	}

	public void display(PApplet p){
		PImage img = parent.loadImage("res/vegetal/object/string.png");
		p.image(img, position.x-16, position.y-16);
	}
	
	public ArrayList<PVector> getVegetalString(){
		return vegetalstring;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}

}
