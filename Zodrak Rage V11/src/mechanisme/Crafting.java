package mechanisme;

import java.util.ArrayList;
import java.util.Iterator;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import mechanisme.Inventory;
import objects.smallBranch;

public class Crafting {
	PApplet parent;
	ArrayList<PVector> crafting;
	ArrayList<Inventory> inv;
	int mode;
	public int craftSlot;
	
	public boolean craftingOpen;
	
	boolean[] keys=new boolean[1];
	
	boolean[] mouses = new boolean[2];
	
	boolean okayC = true;
	
	boolean mousseLeft = true;
	boolean mousseRight = true;
	public boolean actionLM ;
	public boolean actionRM ;
	int leftClickTime;
	
	
	public Crafting(PApplet p){
		parent = p;
		crafting = new ArrayList<PVector>();
		p.registerMethod("keyEvent", this);
		p.registerMethod("mouseEvent", this);
		
	}
	
	public void display(PApplet p, PVector pos, PVector screen){
		PImage imgmush = parent.loadImage("res/vegetal/champi/champi1.png");
		PImage imgRedBerry = parent.loadImage("res/vegetal/berry/redberry.png");
		PImage imgJellowBerry = parent.loadImage("res/vegetal/berry/jellowberry.png");
		PImage imgGrass = parent.loadImage("res/vegetal/grassfeuillu/grassfeuillu1.png");
		PImage imgRock = parent.loadImage("/res/vegetal/rock/rock3.png");
		PImage imgBranch = parent.loadImage("res/vegetal/object/branch.png");
		PImage imgLog = parent.loadImage("res/vegetal/object/log.png");
		PImage imgSmallBranch = parent.loadImage("res/vegetal/object/smallBranch.png");
		PImage imgString = parent.loadImage("res/vegetal/object/string.png");
		
		PImage imgMeat = parent.loadImage("res/animal/meat/meat.png");
		PImage imgFurr = parent.loadImage("res/vegetal/object/furr.png");
		
		PImage imgAxe = parent.loadImage("res/icons/Axe.png");
		PImage imgFireCamp = parent.loadImage("res/icons/Firecamp.png");
		PImage imgKnife = parent.loadImage("res/icons/Dagger.png");
		PImage imgSpear = parent.loadImage("res/icons/Spear.png");
		PImage imgArrow = parent.loadImage("res/icons/Arrow.png");
		PImage imgBow = parent.loadImage("res/icons/Bow.png");
		//cooked meat
		//le dernier sais pas encore

		switch(mode){
			case 0:
				craftingOpen = false;
				break;
			case 1: 
				craftingOpen = true;
				//display crafting
				
				p.fill(255);
				p.rectMode(PConstants.CORNER);
				p.rect(pos.x + screen.x -553 , pos.y +screen.y -361, 192, 96); // check position
				p.noFill();
				grid(pos, screen);
				///les icones dans le grid a gauche
				
				p.image(imgString, pos.x + screen.x -553 , pos.y +screen.y -361);
				p.image(imgAxe, pos.x + screen.x -521 , pos.y +screen.y -361);
				p.image(imgFireCamp, pos.x + screen.x -487 , pos.y +screen.y -359);
				p.image(imgKnife, pos.x + screen.x -553 , pos.y +screen.y -329);
				p.image(imgSpear, pos.x + screen.x -521 , pos.y +screen.y -329);
				p.image(imgArrow, pos.x + screen.x -489 , pos.y +screen.y -329);
				p.image(imgBow, pos.x + screen.x -553 , pos.y +screen.y -297);
				
				
				///les case craftSlot a droite
				switch(craftSlot){
					case 0:
						
						break;
					case 1:
						p.image(imgString, pos.x + screen.x -425 , pos.y +screen.y -361);
						p.image(imgSmallBranch, pos.x + screen.x -457 , pos.y +screen.y -329);
						p.fill(0);
						p.text("3", pos.x + screen.x -428 , pos.y +screen.y -300);
						p.noFill();
						break;
					case 2:
						p.image(imgAxe, pos.x + screen.x -425 , pos.y +screen.y -361);
						
						break;	
					case 3:
						p.image(imgFireCamp, pos.x + screen.x -425 , pos.y +screen.y -361);
						
						break;
					case 4:
						p.image(imgKnife, pos.x + screen.x -425 , pos.y +screen.y -361);
						
						break;
					case 5:
						p.image(imgSpear, pos.x + screen.x -425 , pos.y +screen.y -361);
						
						break;
					case 6:
						p.image(imgArrow, pos.x + screen.x -425 , pos.y +screen.y -361);
						
						break;
					case 7:
						p.image(imgBow, pos.x + screen.x -425 , pos.y +screen.y -361);
						
						break;	
					case 8:
						
						break;
				}
				break;
		}
		
	}
	
	
	
	public void checkActionLM(){
		if(actionLM) leftClickTime++;
	}
	public boolean leftClickTime(){
		if(leftClickTime > 10){
			return true;
		}
		else{
			return false;
		}
	}
	public void resetLeftClickTime(){
		leftClickTime = 0;
	}

	public void grid(PVector pos, PVector screen){
		float videoScale = 32;
		float cols = 3;
		float rows = 3;
		for (int i = 0; i < cols; i++){
			for (int j = 0; j < rows; j++){
				float x = i*videoScale + pos.x + screen.x -553; //  check pos
				float y = j*videoScale + pos.y +screen.y -361;  
				parent.noFill();
				parent.stroke(0);
				parent.strokeWeight(1);
				parent.rect(x, y, videoScale, videoScale);
			}
		}
	}

	public void leftClick(){
		if(mousseLeft && mouses[0] == true){
			mousseLeft = false;
			actionLM = true;
		}
		if(mouses[0] == false){
			mousseLeft = true;
			actionLM = false;
		}
	}

	
	public void rightClick(){
		if(mousseRight && mouses[1] == true){
			actionRM = true;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
			actionRM = false;
		}
	}

	public void pressC(){ //fct !!!!
		if(okayC && keys[0] == true ){
			mode = (mode+1)%2;
			okayC = false;
		}
		if(keys[0] == false ){
			okayC = true;
		}
	}

	public void keyEvent(KeyEvent e){ //fct 
		int keyCode = e.getKeyCode();
		char keyChar = e.getKey();
		boolean shiftDown = e.isShiftDown();
		boolean ctrlDown = e.isControlDown();
		int keyID = e.getAction();
		if(keyID == KeyEvent.PRESS){
			keyPressedProcess(keyCode, keyChar, shiftDown, ctrlDown);
		}
		if(keyID == KeyEvent.RELEASE){
			keyReleasedProcess(keyCode, keyChar, shiftDown, ctrlDown);
		}
	}

	protected void keyPressedProcess(int keyCode, char keyChar, boolean shiftDown, boolean ctrlDown){
		if (keyChar=='c') keys[0]=true;
		//if (keyChar=='e') keys[1]=true;
	}
	
	protected void keyReleasedProcess(int keyCode, char keyChar, boolean shiftDown, boolean ctrlDown){
		if (keyChar=='c') keys[0]=false;
		//if (keyChar=='e') keys[1]=false;
	}

	public void mouseEvent(MouseEvent e){
		int button = e.getButton();
		int buttonID = e.getAction();
		if(buttonID == MouseEvent.PRESS){
			moussePressedProcess(button);
		}
		if(buttonID == MouseEvent.RELEASE){
			mousseReleasedProcess(button);
		}
	}
	
	protected void moussePressedProcess(int button){
		if(button == PConstants.LEFT) mouses[0]=true;
		if(button == PConstants.RIGHT) mouses[1]=true;
	}
	
	protected void mousseReleasedProcess(int button){
		if(button == PConstants.LEFT) mouses[0]=false;
		if(button == PConstants.RIGHT) mouses[1]=false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
