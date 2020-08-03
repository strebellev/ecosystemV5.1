package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class BuissonFruitJaune {
	PApplet parent;
	ArrayList<PVector> buissonfruitjaune;
	public PVector position;
	
	int r;
	
	PImage img;
	
	public int randomBuissonFruit;
	int animBuissonFruit = 4;
	
	PImage[] animB = new PImage[animBuissonFruit];
	
	
	@SuppressWarnings("deprecation")
	public BuissonFruitJaune(PApplet p,PVector l){
		position = l.get();
		parent = p;
		r = 32;
		buissonfruitjaune = new ArrayList<PVector>();
		
		randomBuissonFruit = (int) p.random(4);
		
		animB[0] = p.loadImage("res/newvegetal/buissonfruit/buissonfruit0.png");
		animB[1] = p.loadImage("res/newvegetal/buissonfruit/buissonfruit1.png");
		animB[2] = p.loadImage("res/newvegetal/buissonfruit/buissonfruit2.png");
		animB[3] = p.loadImage("res/newvegetal/buissonfruit/buissonfruit3.png");
		
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		buissonfruitjaune.add(l.get());
	}
	
	public void display(PApplet p){
		if(randomBuissonFruit == 0) p.image(animB[0], position.x-53, position.y-83);
		if(randomBuissonFruit == 1) p.image(animB[1], position.x-49, position.y-49);
		if(randomBuissonFruit == 2) p.image(animB[2], position.x-49, position.y-49);
		if(randomBuissonFruit == 3) p.image(animB[3], position.x-48, position.y-104);
	}
	
	public ArrayList<PVector> getBuissonFruitRouge(){
		return buissonfruitjaune;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
