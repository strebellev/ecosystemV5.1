package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Feuillu {
	PApplet parent;
	ArrayList<PVector> feuillu;
	public PVector position;
	
	int r;
	public float PV;
	public boolean dead;
	PImage img;
	
	public int dropBranch;
	public float delayDropBranch;
	
	public int dropLog;
	
	public int treeSpecies;
	int treeAge;
	
	int beechFull;
	int birchFull;
	int chestnutFull;
	int oakFull;
	
	public boolean beech = false;
	public boolean birch = false;
	public boolean chest = false;
	public boolean oak = false;
	
	public boolean young;
	public boolean old;
	
	int animBeechFull0 = 1;
	int animBeechFull1 = 1;
	int animBeechFull2 = 1;
	int animBeechGrow0 = 1;
	int animBeechGrow1 = 1;
	int animBeechGrow2 = 1;
	int animBeechGrow3 = 1;
	int animBeechGrow4 = 1;
	
	int animBeechStump0 = 1;
	int animBeechStump1 = 1;
	int animBeechStump2 = 1;
	
	int animBirchFull0 = 1;
	int animBirchFull1 = 1;
	int animBirchFull2 = 1;
	int animBirchGrow0 = 1;
	int animBirchGrow1 = 1;
	int animBirchGrow2 = 1;
	int animBirchGrow3 = 1;
	int animBirchGrow4 = 1;
	
	int animBirchStump0 = 1;
	int animBirchStump1 = 1;
	int animBirchStump2 = 1;
	
	int animChestnutFull0 = 1;
	int animChestnutFull1 = 1;
	int animChestnutFull2 = 1;
	int animChestnutGrow0 = 1;
	int animChestnutGrow1 = 1;
	int animChestnutGrow2 = 1;
	int animChestnutGrow3 = 1;
	int animChestnutGrow4 = 1;
	
	int animChestStump0 = 1;
	int animChestStump1 = 1;
	int animChestStump2 = 1;
	
	int animOakFull0 = 1;
	int animOakFull1 = 1;
	int animOakFull2 = 1;
	int animOakGrow0 = 1;
	int animOakGrow1 = 1;
	int animOakGrow2 = 1;
	int animOakGrow3 = 1;
	int animOakGrow4 = 1;
	
	int animOakStump0 = 1;
	int animOakStump1 = 1;
	int animOakStump2 = 1;
	
	int currentFrame = 0;
	
	PImage[] animBeF0 = new PImage[animBeechFull0];
	PImage[] animBeF1 = new PImage[animBeechFull1];
	PImage[] animBeF2 = new PImage[animBeechFull2];
	PImage[] animBeG0 = new PImage[animBeechGrow0];
	PImage[] animBeG1 = new PImage[animBeechGrow1];
	PImage[] animBeG2 = new PImage[animBeechGrow2];
	PImage[] animBeG3 = new PImage[animBeechGrow3];
	PImage[] animBeG4 = new PImage[animBeechGrow4];
	
	PImage[] animBeS0 = new PImage[animBeechStump0];
	PImage[] animBeS1 = new PImage[animBeechStump1];
	PImage[] animBeS2 = new PImage[animBeechStump2];
	
	PImage[] animBiF0 = new PImage[animBirchFull0];
	PImage[] animBiF1 = new PImage[animBirchFull1];
	PImage[] animBiF2 = new PImage[animBirchFull2];
	PImage[] animBiG0 = new PImage[animBirchGrow0];
	PImage[] animBiG1 = new PImage[animBirchGrow1];
	PImage[] animBiG2 = new PImage[animBirchGrow2];
	PImage[] animBiG3 = new PImage[animBirchGrow3];
	PImage[] animBiG4 = new PImage[animBirchGrow4];
	
	PImage[] animBiS0 = new PImage[animBirchStump0];
	PImage[] animBiS1 = new PImage[animBirchStump1];
	PImage[] animBiS2 = new PImage[animBirchStump2];
	
	PImage[] animCF0 = new PImage[animChestnutFull0];
	PImage[] animCF1 = new PImage[animChestnutFull1];
	PImage[] animCF2 = new PImage[animChestnutFull2];
	PImage[] animCG0 = new PImage[animChestnutGrow0];
	PImage[] animCG1 = new PImage[animChestnutGrow1];
	PImage[] animCG2 = new PImage[animChestnutGrow2];
	PImage[] animCG3 = new PImage[animChestnutGrow3];
	PImage[] animCG4 = new PImage[animChestnutGrow4];
	
	PImage[] animCS0 = new PImage[animChestStump0];
	PImage[] animCS1 = new PImage[animChestStump1];
	PImage[] animCS2 = new PImage[animChestStump2];
	
	PImage[] animOF0 = new PImage[animOakFull0];
	PImage[] animOF1 = new PImage[animOakFull1];
	PImage[] animOF2 = new PImage[animOakFull2];
	PImage[] animOG0 = new PImage[animOakGrow0];
	PImage[] animOG1 = new PImage[animOakGrow1];
	PImage[] animOG2 = new PImage[animOakGrow2];
	PImage[] animOG3 = new PImage[animOakGrow3];
	PImage[] animOG4 = new PImage[animOakGrow4];
	
	PImage[] animOS0 = new PImage[animOakStump0];
	PImage[] animOS1 = new PImage[animOakStump1];
	PImage[] animOS2 = new PImage[animOakStump2];
	
	int previousDisplayTime;
	int deltaTime;
	
	
	
	
	@SuppressWarnings("deprecation")
	public Feuillu(PApplet p,PVector l){
		position = l.get();
		parent = p;
		r = 32;
		feuillu = new ArrayList<PVector>();
		//img = tempImg;
		PV = 200;
		dropBranch = 5;
		dropLog = 1;
		
		treeSpecies = (int) p.random(4);
		treeAge = (int) p.random(10000);
		
		beechFull = (int) p.random(3);
		birchFull = (int) p.random(3);
		chestnutFull = (int) p.random(3);
		oakFull = (int) p.random(3);
		
		animBeF0[0] = p.loadImage("res/newvegetal/feuillu/beechFull0.png");
		animBeF1[0] = p.loadImage("res/newvegetal/feuillu/beechFull1.png");
		animBeF2[0] = p.loadImage("res/newvegetal/feuillu/beechFull2.png");
		animBeG0[0] = p.loadImage("res/newvegetal/feuillu/beechGrow0.png");
		animBeG1[0] = p.loadImage("res/newvegetal/feuillu/beechGrow1.png");
		animBeG2[0] = p.loadImage("res/newvegetal/feuillu/beechGrow2.png");
		animBeG3[0] = p.loadImage("res/newvegetal/feuillu/beechGrow3.png");
		animBeG4[0] = p.loadImage("res/newvegetal/feuillu/beechGrow4.png");
		
		animBeS0[0] = p.loadImage("res/newvegetal/feuillu/treeStumpBeech1.png");
		animBeS1[0] = p.loadImage("res/newvegetal/feuillu/treeStumpBeech2.png");
		animBeS2[0] = p.loadImage("res/newvegetal/feuillu/treeStumpBeech3.png");
		
		animBiF0[0] = p.loadImage("res/newvegetal/feuillu/birchFull0.png");
		animBiF1[0] = p.loadImage("res/newvegetal/feuillu/birchFull1.png");
		animBiF2[0] = p.loadImage("res/newvegetal/feuillu/birchFull2.png");
		animBiG0[0] = p.loadImage("res/newvegetal/feuillu/birchGrow0.png");
		animBiG1[0] = p.loadImage("res/newvegetal/feuillu/birchGrow1.png");
		animBiG2[0] = p.loadImage("res/newvegetal/feuillu/birchGrow2.png");
		animBiG3[0] = p.loadImage("res/newvegetal/feuillu/birchGrow3.png");
		animBiG4[0] = p.loadImage("res/newvegetal/feuillu/birchGrow4.png");
		
		animBiS0[0] = p.loadImage("res/newvegetal/feuillu/treeStumpBirch1.png");
		animBiS1[0] = p.loadImage("res/newvegetal/feuillu/treeStumpBirch2.png");
		animBiS2[0] = p.loadImage("res/newvegetal/feuillu/treeStumpBirch3.png");
		
		animCF0[0] = p.loadImage("res/newvegetal/feuillu/chestnutFull0.png");
		animCF1[0] = p.loadImage("res/newvegetal/feuillu/chestnutFull1.png");
		animCF2[0] = p.loadImage("res/newvegetal/feuillu/chestnutFull2.png");
		animCG0[0] = p.loadImage("res/newvegetal/feuillu/chestnutGrow0.png");
		animCG1[0] = p.loadImage("res/newvegetal/feuillu/chestnutGrow1.png");
		animCG2[0] = p.loadImage("res/newvegetal/feuillu/chestnutGrow2.png");
		animCG3[0] = p.loadImage("res/newvegetal/feuillu/chestnutGrow3.png");
		animCG4[0] = p.loadImage("res/newvegetal/feuillu/chestnutGrow4.png");
		
		animCS0[0] = p.loadImage("res/newvegetal/feuillu/treeStumpChestnut1.png");
		animCS1[0] = p.loadImage("res/newvegetal/feuillu/treeStumpChestnut2.png");
		animCS2[0] = p.loadImage("res/newvegetal/feuillu/treeStumpChestnut3.png");
		
		animOF0[0] = p.loadImage("res/newvegetal/feuillu/oakFull0.png");
		animOF1[0] = p.loadImage("res/newvegetal/feuillu/oakFull1.png");
		animOF2[0] = p.loadImage("res/newvegetal/feuillu/oakFull2.png");
		animOG0[0] = p.loadImage("res/newvegetal/feuillu/oakGrow0.png");
		animOG1[0] = p.loadImage("res/newvegetal/feuillu/oakGrow1.png");
		animOG2[0] = p.loadImage("res/newvegetal/feuillu/oakGrow2.png");
		animOG3[0] = p.loadImage("res/newvegetal/feuillu/oakGrow3.png");
		animOG4[0] = p.loadImage("res/newvegetal/feuillu/oakGrow4.png");
		
		animOS0[0] = p.loadImage("res/newvegetal/feuillu/treeStumpOak1.png");
		animOS1[0] = p.loadImage("res/newvegetal/feuillu/treeStumpOak2.png");
		animOS2[0] = p.loadImage("res/newvegetal/feuillu/treeStumpOak3.png");
		
		deltaTime = 120; // animation speed -=fast +=slow
		previousDisplayTime = 0;
		
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		feuillu.add(l.get());
	}
	
	public void checkDead(){
		if(PV <= 0) dead = true;
	}
	
	public boolean checkDropBranch(){
		if(dropBranch > 0) return true;
		else{
			return false;
		}
	}
	
	public boolean checkDropLog(){
		if(dropLog > 0) return true;
		else{
			return false;
		}
	}

	
	public void treeGrow(){
		treeAge ++;
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		p.fill(0);
		p.text(treeSpecies, position.x, position.y);
		
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-96, position.y-180);
		//p.text(PV, position.x, position.y);
	}
	
	public void display2(PApplet p){
		//p.text(treeAge, position.x, position.y);
		if(treeSpecies == 0){
			beech = true;
			if(dead == false){	
				if(treeAge < 999){
					p.image(animBeG0[0], position.x-10, position.y-32);
					young = false;
					old = false;
				}
				if(treeAge >=1000 && treeAge < 1999){
					p.image(animBeG1[0], position.x-20, position.y-70);
					young = true;
					old = false;
				}
				if(treeAge >= 2000 && treeAge < 2999){
					p.image(animBeG2[0], position.x-46, position.y-117);
					young = true;
					old = false;
				}
				if(treeAge >=3000 && treeAge < 5999){
					p.image(animBeG3[0], position.x-56, position.y-127);
					young = false;
					old = true;
				}
				if(treeAge >= 6000 && treeAge < 9999){
					p.image(animBeG4[0], position.x-76, position.y-153);
					young = false;
					old = true;
				}
				if(treeAge >= 10000){
					young = false;
					old = true;
					if(beechFull ==0) p.image(animBeF0[0], position.x-89, position.y-167);
					if(beechFull ==1) p.image(animBeF1[0], position.x-105, position.y-158);
					if(beechFull ==2) p.image(animBeF2[0], position.x-96, position.y-183);
				}
			}	
			if(dead == true){
				if(beechFull ==0) p.image(animBeS0[0], position.x-21, position.y-19);
				if(beechFull ==1) p.image(animBeS1[0], position.x-25, position.y-22);
				if(beechFull ==2) p.image(animBeS2[0], position.x-16, position.y-23);
			}
		}
		if(treeSpecies == 1){
			birch = true;
			if(dead == false){
				if(treeAge < 999){
					young = false;
					old = false;
					p.image(animBiG0[0], position.x-8, position.y-20);
				}
				if(treeAge >=1000 && treeAge < 1999){
					young = true;
					old = false;
					p.image(animBiG1[0], position.x-18, position.y-48);
				}
				if(treeAge >= 2000 && treeAge < 2999){
					young = true;
					old = false;
					p.image(animBiG2[0], position.x-39, position.y-97);
				}
				if(treeAge >=3000 && treeAge < 5999){
					young = false;
					old = true;
					p.image(animBiG3[0], position.x-37, position.y-110);
				}
				if(treeAge >= 6000 && treeAge < 9999){
					young = false;
					old = true;
					p.image(animBiG4[0], position.x-66, position.y-149);
				}
				if(treeAge >= 10000){
					young = false;
					old = true;
					if(birchFull == 0) p.image(animBiF0[0], position.x-97, position.y-167);
					if(birchFull == 1) p.image(animBiF1[0], position.x-77, position.y-198);
					if(birchFull == 2) p.image(animBiF2[0], position.x-85, position.y-183);
				}
			}	
			if(dead == true){
				if(birchFull == 0) p.image(animBiS0[0], position.x-15, position.y-25);
				if(birchFull == 1) p.image(animBiS1[0], position.x-14, position.y-30);
				if(birchFull == 2) p.image(animBiS2[0], position.x-17, position.y-25);
			}
		}
		if(treeSpecies == 2){
			chest = true;
			if(dead == false){
				if(treeAge < 999){
					young = false;
					old = false;
					p.image(animCG0[0], position.x-1, position.y-24);
				}
				if(treeAge >=1000 && treeAge < 1999){
					young = true;
					old = false;
					p.image(animCG1[0], position.x-22, position.y-53);
				}
				if(treeAge >= 2000 && treeAge < 2999){
					young = true;
					old = false;
					p.image(animCG2[0], position.x-47, position.y-97);
				}
				if(treeAge >=3000 && treeAge < 5999){
					young = false;
					old = true;
					p.image(animCG3[0], position.x-61, position.y-138);
				}
				if(treeAge >= 6000 && treeAge < 9999){
					young = false;
					old = true;
					p.image(animCG4[0], position.x-71, position.y-141);
				}
				if(treeAge >= 10000){
					young = false;
					old = true;
					if(chestnutFull == 0) p.image(animCF0[0], position.x-70, position.y-178);
					if(chestnutFull == 1) p.image(animCF1[0], position.x-82, position.y-162);
					if(chestnutFull == 2) p.image(animCF2[0], position.x-68, position.y-178);
				}
			}	
			if(dead == true){
				if(chestnutFull == 0) p.image(animCS0[0], position.x-22, position.y-20);
				if(chestnutFull == 1) p.image(animCS1[0], position.x-6, position.y-14);
				if(chestnutFull == 2) p.image(animCS2[0], position.x-10, position.y-12);
			}
		}
		if(treeSpecies == 3){
			oak = true;
			if(dead == false){
				if(treeAge < 999){
					young = false;
					old = false;
					p.image(animOG0[0], position.x-7, position.y-18);
				}
				if(treeAge >=1000 && treeAge < 1999){
					young = true;
					old = false;
					p.image(animOG1[0], position.x-18, position.y-38);
				}
				if(treeAge >= 2000 && treeAge < 2999){
					young = true;
					old = false;
					p.image(animOG2[0], position.x-53, position.y-87);
				}
				if(treeAge >=3000 && treeAge < 5999){
					young = false;
					old = true;
					p.image(animOG3[0], position.x-64, position.y-110);
				}
				if(treeAge >= 6000 && treeAge < 9999){
					young = false;
					old = true;
					p.image(animOG4[0], position.x-90, position.y-145);
				}
				if(treeAge >= 10000){
					young = false;
					old = true;
					if(oakFull == 0) p.image(animOF0[0], position.x-102, position.y-160);
					if(oakFull == 1) p.image(animOF1[0], position.x-99, position.y-139);
					if(oakFull == 2) p.image(animOF2[0], position.x-90, position.y-158);
				}
			}	
			if(dead == true){
				if(oakFull == 0) p.image(animOS1[0], position.x-18, position.y-16);
				if(oakFull == 1) p.image(animOS0[0], position.x-17, position.y-13);
				if(oakFull == 2) p.image(animOS2[0], position.x-28, position.y-14);
			}
		}
	}
	
	public ArrayList<PVector> getFeuillu(){
		return feuillu;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
	
	public void resetDelayDropBranch(){
		delayDropBranch = 0;
	}
	
	public boolean delayDropBranch(){
		if(delayDropBranch > 20) return true;
		else return false;
	}
}
