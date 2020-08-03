package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;


public class Log {
	PApplet parent;
	ArrayList<PVector> log;
	public PVector position;
	
	int r;

	public int treeSpecies;
	
	int randomLog;
	int beechLog = 2;
	int birchLog = 2;
	int chestLog = 2;
	int oakLog = 2;
	
	PImage[] beechL = new PImage[beechLog];
	PImage[] birchL = new PImage[birchLog];
	PImage[] chestL = new PImage[chestLog];
	PImage[] oakL = new PImage[oakLog];
	
	@SuppressWarnings("deprecation")
	public Log(PApplet p, PVector pos){
		position = pos.get();
		parent = p;
		r = 32;
		log = new ArrayList<PVector>();
		
		randomLog = (int) p.random(2);
		
		beechL[0] = p.loadImage("res/object/vegetal/beechLog1.png");
		beechL[1] = p.loadImage("res/object/vegetal/beechLog2.png");
		
		birchL[0] = p.loadImage("res/object/vegetal/birchLog1.png");
		birchL[1] = p.loadImage("res/object/vegetal/birchLog2.png");
		
		chestL[0] = p.loadImage("res/object/vegetal/chestnutLog1.png");
		chestL[1] = p.loadImage("res/object/vegetal/chestnutLog2.png");
		
		oakL[0] = p.loadImage("res/object/vegetal/oakLog1.png");
		oakL[1] = p.loadImage("res/object/vegetal/oakLog2.png");

	}
	
	public void display(PApplet p){
		switch(treeSpecies){
			case 0:
				break;
			case 1:
				p.image(beechL[randomLog], position.x-16, position.y-16);
				break;
			case 2:
				p.image(birchL[randomLog], position.x-16, position.y-16);
				break;
			case 3:
				p.image(chestL[randomLog], position.x-16, position.y-16);
				break;
			case 4:
				p.image(oakL[randomLog], position.x-16, position.y-16);
				break;
		}
	}
	
	
	public ArrayList<PVector> getLog(){
		return log;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
	
}
