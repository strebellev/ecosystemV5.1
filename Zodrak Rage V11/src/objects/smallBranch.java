package objects;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class smallBranch {
	PApplet parent;
	ArrayList<PVector> smallbranch;
	public PVector position;
	
	int r;
	
	int randomSize;
	int randomB;
	int randomS;
	
	int animSmallBranch = 3;
	int animBigBranch = 3;
	
	PImage[] animSB = new PImage[animSmallBranch];
	PImage[] animBB = new PImage[animBigBranch];
	
	@SuppressWarnings("deprecation")
	public smallBranch(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		smallbranch = new ArrayList<PVector>();
		
		randomSize = (int) p.random(2);
		randomB = (int) p.random(3);
		randomS = (int) p.random(3);
		
		animSB[0] = p.loadImage("res/object/vegetal/plantBranchS1.png");
		animSB[1] = p.loadImage("res/object/vegetal/plantBranchS2.png");
		animSB[2] = p.loadImage("res/object/vegetal/plantBranchS3.png");
		
		animBB[0] = p.loadImage("res/object/vegetal/plantBranchL1.png");
		animBB[1] = p.loadImage("res/object/vegetal/plantBranchL2.png");
		animBB[2] = p.loadImage("res/object/vegetal/plantBranchL3.png");
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		smallbranch.add(l.get());
	}

	public void display(PApplet p){
		PImage img = parent.loadImage("res/newObject/plantBranch.png");
		p.image(img, position.x-16, position.y-16);
	}
	
	public void display2(PApplet p){
		if(randomSize == 0){
			p.image(animBB[randomB], position.x-13, position.y-32);
		}
		else if(randomSize == 1){
			p.image(animSB[randomS], position.x-15, position.y-12);
		}
	}
	
	public ArrayList<PVector> getsmallBranch(){
		return smallbranch;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}

}
