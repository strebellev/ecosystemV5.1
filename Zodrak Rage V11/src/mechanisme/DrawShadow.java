package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class DrawShadow {
	PApplet parent;
	ArrayList<PVector> drawshadow;
	
	
	public DrawShadow(PApplet p){
		parent = p;
	}
	
	public void draw(PApplet p){
		parent.pushStyle();
		parent.noStroke();
		parent.fill(0, 150);
		parent.rect(500, 500, parent.width, parent.height);
		parent.popStyle();
	}
}
