package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class FireCampLvl1 {
	PApplet parent;
	ArrayList<PVector> firecamplvl1;
	public PVector position;
	
	int r;
	
	public boolean gotFuel;
	public boolean lit;
	public boolean unlit;
	public boolean dead;
	
	public float fuel;
	public float noMoreFuel;
	
	int animCampFireUnlit = 1;
	int animCampFireLit = 8;
	int animCampFireDead = 8;
	
	PImage[] animCFU = new PImage[animCampFireUnlit];
	PImage[] animCFL = new PImage[animCampFireLit];
	PImage[] animCFD = new PImage[animCampFireDead];
	
	int currentFrame = 0;
	
	
	int previousDisplayTime;
	int deltaTime;
	
	@SuppressWarnings("deprecation")
	public FireCampLvl1(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		
		fuel = 200;
		noMoreFuel = 200;
		
		animCFU[0] = p.loadImage("res/object/fireCamplvl1/campfireUnlit.png");
		
		animCFL[0] = p.loadImage("res/object/fireCamplvl1/campFireLit0.png");
		animCFL[1] = p.loadImage("res/object/fireCamplvl1/campFireLit1.png");
		animCFL[2] = p.loadImage("res/object/fireCamplvl1/campFireLit2.png");
		animCFL[3] = p.loadImage("res/object/fireCamplvl1/campFireLit3.png");
		animCFL[4] = p.loadImage("res/object/fireCamplvl1/campFireLit4.png");
		animCFL[5] = p.loadImage("res/object/fireCamplvl1/campFireLit5.png");
		animCFL[6] = p.loadImage("res/object/fireCamplvl1/campFireLit6.png");
		animCFL[7] = p.loadImage("res/object/fireCamplvl1/campFireLit7.png");
		
		animCFD[0] = p.loadImage("res/object/fireCamplvl1/campFireDead0.png");
		animCFD[1] = p.loadImage("res/object/fireCamplvl1/campFireDead1.png");
		animCFD[2] = p.loadImage("res/object/fireCamplvl1/campFireDead2.png");
		animCFD[3] = p.loadImage("res/object/fireCamplvl1/campFireDead3.png");
		animCFD[4] = p.loadImage("res/object/fireCamplvl1/campFireDead4.png");
		animCFD[5] = p.loadImage("res/object/fireCamplvl1/campFireDead5.png");
		animCFD[6] = p.loadImage("res/object/fireCamplvl1/campFireDead6.png");
		animCFD[7] = p.loadImage("res/object/fireCamplvl1/campFireDead7.png");
		
		
		
		
		deltaTime = 100; // animation speed +=fast -=slow
		previousDisplayTime = 0;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		firecamplvl1.add(l.get());
	}

	public void display(PApplet p){
		//p.fill(255,0,0);
		//p.ellipse(position.x, position.y, 5, 5);
		//p.noFill();	
		if(unlit == true ){
			
			p.image(animCFU[0],position.x-27,position.y-128);
			
		}
		
		if(lit == true){
			if(p.millis() > previousDisplayTime + deltaTime){
				currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
			}
			p.image(animCFL[currentFrame],position.x-27,position.y-128);
		}
		if(dead == true){
			if(p.millis() > previousDisplayTime + deltaTime){
				currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
			}
			p.image(animCFD[currentFrame],position.x-27,position.y-128);
		}
	}
	
	public void checkFire(){
		if(fuel > 0){
			unlit = true;
		}
		if(lit == true){
			unlit = false;
			fuel --;
		}
		if(fuel <= 0){
			//unlit = true;
			lit = false;
			dead = true;
		}
		if(dead == true){
			noMoreFuel --;
		}
		if(noMoreFuel <=0){
			unlit = true;
			dead = false;
		}
	}
	
	public ArrayList<PVector> getSouche(){
		return firecamplvl1;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
