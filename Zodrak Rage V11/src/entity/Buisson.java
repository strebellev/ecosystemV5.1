package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Buisson {
	PApplet parent;
	ArrayList<PVector> buisson;
	public PVector position;
	
	int r;
	
	public int randomBuisson;
	int animBuisson = 8;
	public boolean dropPlantBranch;
	
	PImage[] animB = new PImage[animBuisson];
	
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public Buisson(PApplet p,PVector l){
		position = l.get();
		parent = p;
		r = 32;
		buisson = new ArrayList<PVector>();
		//img = tempImg;
		
		randomBuisson = (int) p.random(8);
		
		animB[0] = p.loadImage("res/newvegetal/buisson/buisson0.png");
		animB[1] = p.loadImage("res/newvegetal/buisson/buisson1.png");
		animB[2] = p.loadImage("res/newvegetal/buisson/buisson2.png");
		animB[3] = p.loadImage("res/newvegetal/buisson/buisson3.png");
		animB[4] = p.loadImage("res/newvegetal/buisson/buisson4.png");
		animB[5] = p.loadImage("res/newvegetal/buisson/buisson5.png");
		animB[6] = p.loadImage("res/newvegetal/buisson/buisson6.png");
		animB[7] = p.loadImage("res/newvegetal/buisson/buisson7.png");
		
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		buisson.add(l.get());
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		p.fill(0);
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-16, position.y-16);
	}
	
	public void display2(PApplet p){
		if(randomBuisson == 0){
			p.image(animB[0], position.x-23, position.y-62);
		}
		if(randomBuisson == 1){
			p.image(animB[1], position.x-14, position.y-70);
			dropPlantBranch = true;
		}
		if(randomBuisson == 2){
			p.image(animB[2], position.x-17, position.y-64);
			dropPlantBranch = true;
		}
		if(randomBuisson == 3){
			p.image(animB[3], position.x-12, position.y-83);
			dropPlantBranch = true;
		}
		if(randomBuisson == 4){
			p.image(animB[4], position.x-47, position.y-38);
			dropPlantBranch = true;
		}
		if(randomBuisson == 5){
			p.image(animB[5], position.x-42, position.y-29);
		}
		if(randomBuisson == 6){
			p.image(animB[6], position.x-29, position.y-82);
			dropPlantBranch = true;
		}
		if(randomBuisson == 7){
			p.image(animB[4], position.x-30, position.y-83);
			dropPlantBranch = true;
		}
		
	}
	
	public ArrayList<PVector> getBuisson(){
		return buisson;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
