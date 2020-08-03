package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Rock {
	PApplet parent;
	ArrayList<PVector> rock;
	public PVector position;
	
	int r;
	public int rockSize;
	public int randomSR;
	public int randomBR;
	
	int animSmallRock = 2;
	int animMedRock = 1;
	int animBigRock = 2;
	
	PImage[] animSR = new PImage[animSmallRock];
	PImage[] animMR = new PImage[animMedRock];
	PImage[] animBR = new PImage[animBigRock];
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public Rock(PApplet p,PVector l){
		position = l.get();
		parent = p;
		r = 32;
		rock = new ArrayList<PVector>();
		//img = tempImg;
		
		rockSize = (int) p.random(3);
		randomSR = (int) p.random(2);
		randomBR = (int) p.random(2);
		
		animSR[0] = p.loadImage("res/object/rock/rockS1.png");
		animSR[1] = p.loadImage("res/object/rock/rockS2.png");
		animMR[0] = p.loadImage("res/object/rock/rockM.png");
		animBR[0] = p.loadImage("res/object/rock/rockL1.png");
		animBR[1] = p.loadImage("res/object/rock/rockL2.png");
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		rock.add(l.get());
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		p.fill(0);
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-16, position.y-16);
	}
	
	public void display2(PApplet p){
		if(rockSize == 0){
			p.image(animSR[randomSR], position.x-14, position.y-10);
		}
		if(rockSize == 1){
			p.image(animMR[0], position.x-23, position.y-12);
		}
		if(rockSize == 2){
			p.image(animBR[randomBR], position.x-21, position.y-21);
		}
	}
	
	public ArrayList<PVector> getRock(){
		return rock;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
