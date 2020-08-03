package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;


public class Branch {

	PApplet parent;
	ArrayList<PVector> branch;
	public PVector position;
	
	int r;
	
	public boolean old;
	public boolean young;
	
	int randomO;
	int randomY;
	
	
	//old small+large branch  young just small branch 
	int beechBranchO = 4;
	int beechBranchY = 2;
	int birchBranchO = 4;
	int birchBranchY = 2;
	int chestBranchO = 4;
	int chestBranchY = 2;
	int oakBranchO = 4;
	int oakBranchY = 2;
	
	public int treeSpecies;
	
	PImage[] beechBO = new PImage[beechBranchO];
	PImage[] beechBY = new PImage[beechBranchY];
	PImage[] birchBO = new PImage[birchBranchO];
	PImage[] birchBY = new PImage[birchBranchY];
	PImage[] chestBO = new PImage[chestBranchO];
	PImage[] chestBY = new PImage[chestBranchY];
	PImage[] oakBO = new PImage[oakBranchO];
	PImage[] oakBY = new PImage[oakBranchY];

	@SuppressWarnings("deprecation")
	public Branch(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		branch = new ArrayList<PVector>();
		
		randomO = (int) p.random(4);
		randomY = (int) p.random(2);
		
		beechBO[0] = p.loadImage("res/object/vegetal/beechBranchL1.png");
		beechBO[1] = p.loadImage("res/object/vegetal/beechBranchL2.png");
		beechBO[2] = p.loadImage("res/object/vegetal/beechBranchS1.png");
		beechBO[3] = p.loadImage("res/object/vegetal/beechBranchS2.png");
		
		beechBY[0] = p.loadImage("res/object/vegetal/beechBranchS1.png");
		beechBY[1] = p.loadImage("res/object/vegetal/beechBranchS2.png");
		
		birchBO[0] = p.loadImage("res/object/vegetal/birchBranchL1.png");
		birchBO[1] = p.loadImage("res/object/vegetal/birchBranchL2.png");
		birchBO[2] = p.loadImage("res/object/vegetal/birchBranchS1.png");
		birchBO[3] = p.loadImage("res/object/vegetal/birchBranchS2.png");
		
		birchBY[0] = p.loadImage("res/object/vegetal/birchBranchS1.png");
		birchBY[1] = p.loadImage("res/object/vegetal/birchBranchS2.png");
		
		chestBO[0] = p.loadImage("res/object/vegetal/chestnutBranchL1.png");
		chestBO[1] = p.loadImage("res/object/vegetal/chestnutBranchL2.png");
		chestBO[2] = p.loadImage("res/object/vegetal/chestnutBranchS1.png");
		chestBO[3] = p.loadImage("res/object/vegetal/chestnutBranchS2.png");
		
		chestBY[0] = p.loadImage("res/object/vegetal/chestnutBranchS1.png");
		chestBY[1] = p.loadImage("res/object/vegetal/chestnutBranchS2.png");
		
		
		oakBO[0] = p.loadImage("res/object/vegetal/oakBranch1.png");
		oakBO[1] = p.loadImage("res/object/vegetal/oakBranchL2.png");
		oakBO[2] = p.loadImage("res/object/vegetal/oakBranchS1.png");
		oakBO[3] = p.loadImage("res/object/vegetal/oakBranchS2.png");
		
		oakBY[0] = p.loadImage("res/object/vegetal/oakBranchS1.png");
		oakBY[1] = p.loadImage("res/object/vegetal/oakBranchS2.png");
		
		
		
		
	}

	@SuppressWarnings("deprecation")
	public void add(PVector l){
		branch.add(l.get());
	}

	public void display(PApplet p){
		PImage img = parent.loadImage("res/vegetal/object/branch.png");
		p.image(img, position.x-16, position.y-16);
	}
	
	public void display2(PApplet p){
		switch(treeSpecies){
			case 0:
				break;
			case 1:
				if(old == true) p.image(beechBO[randomO], position.x-16, position.y-16);
				if(young == true) p.image(beechBY[randomY], position.x-16, position.y-16);
				break;
			case 2:
				if(old == true) p.image(birchBO[randomO], position.x-16, position.y-16);
				if(young == true) p.image(birchBY[randomY], position.x-16, position.y-16);
				break;
			case 3:
				if(old == true) p.image(chestBO[randomO], position.x-16, position.y-16);
				if(young == true)p.image(chestBY[randomY], position.x-16, position.y-16);
				break;
			case 4:
				if(old == true) p.image(oakBO[randomO], position.x-16, position.y-16);
				if(young == true) p.image(oakBO[randomY], position.x-16, position.y-16);
				break;
		}
	}
	
	public ArrayList<PVector> getBranch(){
		return branch;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}


	
}
