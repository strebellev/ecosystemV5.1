package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PVector;

public class Light {
	PApplet parent;
	ArrayList<PVector> light;
	PImage texture;
	PGraphics mask;
	
	
	/////////////////////////////////////
	//////A BACKER//////////////////////
	////////////////////////////////////
	
	
	
	
	public PGraphics lightMask;
	
	int x, y, dist;
	
	public Light(PApplet p, int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
		parent = p;
		
		texture = p.loadImage("res/icons/light.png");
		texture.resize(dist*2, dist*2);
		mask = p.createGraphics(texture.width, texture.height);
		
	}
	
	public void draw(){
		mask.beginDraw();
		mask.background(0);
		mask.fill(255);
		mask.noStroke();
		mask.beginShape();
		
		for(float i = 0; i < 360; i++){
			PVector point = new PVector(x+dist*PApplet.sin(PApplet.radians(i)),y+dist*PApplet.cos(PApplet.radians(i)));
			mask.vertex(point.x-x+dist,point.y-y+dist);
		}
		
		mask.endShape();
		mask.endDraw();
		mask.mask(texture);
		lightMask.image(mask, x-dist, y-dist);
		
	}
	
}

