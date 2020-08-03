package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class tileWater {
	PApplet parent;
	ArrayList<PVector> tilewater;
	public PVector position;
	
	int r;
	
	PImage img;
	
	public int skinWater;
	
	int animLeftTop = 4;
	int animRightTop = 4;
	int animSurround = 4;
	
	int currentFrame = 0;
	
	PImage[] animLT = new PImage[animLeftTop];
	PImage[] animRT = new PImage[animRightTop];
	PImage[] animS = new PImage[animSurround];
	
	int previousDisplayTime;
	int deltaTime;
	
	@SuppressWarnings("deprecation")
	public tileWater(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		tilewater = new ArrayList<PVector>();
		//img = tempImg;
		
		animLT[0] = p.loadImage("res/floor/leftTop0.png");
		animLT[1] = p.loadImage("res/floor/leftTop1.png");
		animLT[2] = p.loadImage("res/floor/leftTop0.png");
		animLT[3] = p.loadImage("res/floor/leftTop2.png");
		
		animRT[0] = p.loadImage("res/floor/rightTop0.png");
		animRT[1] = p.loadImage("res/floor/rightTop1.png");
		animRT[2] = p.loadImage("res/floor/rightTop0.png");
		animRT[3] = p.loadImage("res/floor/rightTop2.png");
		
		animS[0] = p.loadImage("res/floor/surround0.png");
		animS[1] = p.loadImage("res/floor/surround1.png");
		animS[2] = p.loadImage("res/floor/surround0.png");
		animS[3] = p.loadImage("res/floor/surround2.png");
		
		deltaTime = 300; // animation speed -=fast +=slow
		previousDisplayTime = 0;


	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		tilewater.add(l.get());
	}
	
	public void display(PApplet p){
		p.rectMode(PConstants.CENTER);
		//p.fill(153,0,153);
		p.rect(position.x, position.y, r, r);
		p.image(img, position.x, position.y);
		
	}
	
	public void display2(PApplet p){
		switch(skinWater){
		case 0:
			if (p.millis() > previousDisplayTime + deltaTime){
				currentFrame++;
				if (currentFrame > 3) {
		    	    currentFrame = 0;
		    	}
				previousDisplayTime = p.millis();
			}
			p.image(animS[currentFrame],position.x,position.y);
			break;
		case 1:
			if (p.millis() > previousDisplayTime + deltaTime){
				currentFrame++;
				if (currentFrame > 3) {
		    	    currentFrame = 0;
		    	}
				previousDisplayTime = p.millis();
			}
			p.image(animRT[currentFrame],position.x,position.y);
			break;
		case 2:
			if (p.millis() > previousDisplayTime + deltaTime){
				currentFrame++;
				if (currentFrame > 3) {
		    	    currentFrame = 0;
		    	}
				previousDisplayTime = p.millis();
			}
			p.image(animS[currentFrame],position.x,position.y);
			break;
		}
	}
	
	boolean nothingOnRight(float w1x, float w1y,float gl1x,float gl2y,float gl3y){
		boolean left = false;
		boolean right = false;
		boolean top = false;
		boolean bottom = false;
		//if(w1x +128 == w2x) right = true;
		if(w1x -128 == gl1x) left = true;
		if(w1y +128 == gl2y) bottom = true;
		if(w1y -128 == gl3y) top = true;
		if(left == true && bottom == true && top == true) return true;
		else return false;
	}
	
	boolean testRightTop(float w1x, float w1y,float w2x,float gl1x,float gl2y){
		boolean left = false;
		boolean right = false;
		boolean top = false;
		boolean bottom = false;
		if(w1x +128 == gl1x) right = true;
		if(w1x -128 == w2x) left = true;
		//if(w1y +128 == gl2y) bottom = true;
		if(w1y -128 == gl2y) top = true;
		if(right == true && left == true && top == true) return true;
		else return false;
	}
	
	boolean testLeftTop(float w1x, float w1y,float w2x,float gl1x,float gl2y){
		boolean left = false;
		boolean right = false;
		boolean top = false;
		boolean bottom = false;
		if(w1x +128 == w2x) right = true;
		if(w1x -128 == gl1x) left = true;
		//if(w1y +128 == gl2y) bottom = true;
		if(w1y -128 == gl2y) top = true;
		if(right == true && left == true && top == true) return true;
		else return false;
	}

	

	
	public ArrayList<PVector> getTileWater(){
		return tilewater;
	}
	
	public PVector position(){
		return position;
	}
}
