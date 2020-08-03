package objects;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Souche {
	PApplet parent;
	ArrayList<PVector> souche;
	public PVector position;
	
	int r;
	
	@SuppressWarnings("deprecation")
	public Souche(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		souche = new ArrayList<PVector>();
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		souche.add(l.get());
	}

	public void display(PApplet p){
		PImage img = parent.loadImage("res/vegetal/object/souche.png");
		p.image(img, position.x-16, position.y-16);
	}
	
	public ArrayList<PVector> getSouche(){
		return souche;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}

}
