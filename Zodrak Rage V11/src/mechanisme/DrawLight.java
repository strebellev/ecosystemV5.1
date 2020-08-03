package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;

public class DrawLight {
	PApplet parent;
	ArrayList<PVector> drawlight;
	
	public DrawLight(PApplet p){
		parent = p;
	}
	
	public void draw(PApplet p,float x, float y, float radius, PGraphics pg){
		pg.beginDraw();
		pg.noStroke();
		pg.fill(255);
		pg.background(0, 0);
		pg.ellipse(x, y, radius, radius);
		pg.endDraw();
	}
}
