package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;
import processing.event.KeyEvent;
import processing.event.MouseEvent;


public class Player2 extends PApplet {
	PApplet parent;
	ArrayList<PVector> player2;
	
	public PVector position;
	
	////test anim souris
	PVector centerPoint;
	////////////
	
	float r = 5;
	PVector velocity;
	PVector acceleration;
	float maxspeed;
	float maxforce;
	
	//////test anim/////
	//walk
	int animLnumFrame = 8;
	int animRnumFrame = 8;
	int animUnumFrame = 8;
	int animULnumFrame = 8;
	int animURnumFrame = 8;
	int animDnumFrame = 8;
	int animDLnumFrame = 8;
	int animDRnumFrame = 8;
		
	//idle
	int animIdLnumFrame = 3;
	int animIdRnumFrame = 3;
	int animIdUnumFrame = 3;
	int animIdULnumFrame = 3;
	int animIdURnumFrame = 3;
	int animIdDnumFrame = 3;
	int animIdDLnumFrame = 3;
	int animIdDRnumFrame = 3;
	
	//walk axe
	int animAxLnumFrame = 8;
	int animAxRnumFrame = 8;
	int animAxUnumFrame = 8;
	int animAxULnumFrame = 8;
	int animAxURnumFrame = 8;
	int animAxDnumFrame = 8;
	int animAxDLnumFrame = 8;
	int animAxDRnumFrame = 8;
	
	//idle axe
	int animIdAxLnumFrame = 3;
	int animIdAxRnumFrame = 3;
	int animIdAxUnumFrame = 3;
	int animIdAxULnumFrame = 3;
	int animIdAxURnumFrame = 3;
	int animIdAxDnumFrame = 3;
	int animIdAxDLnumFrame = 3;
	int animIdAxDRnumFrame = 3;
	
	//chop tree
	int animChopLnumFrame = 6;
	int animChopRnumFrame = 6;
	int animChopUnumFrame = 6;
	int animChopULnumFrame = 6;
	int animChopURnumFrame = 6;
	int animChopDnumFrame = 6;
	int animChopDLnumFrame = 6;
	int animChopDRnumFrame = 6;
	
	//spear
	int animLSnumFrame = 9;
	int animRSnumFrame = 9;
	int animUSnumFrame = 9;
	int animDSnumFrame = 9;
	
	
	PImage[] animLeft = new PImage[animLnumFrame];
	PImage[] animRight = new PImage[animRnumFrame];
	PImage[] animUp = new PImage[animUnumFrame];
	PImage[] animUpL = new PImage[animULnumFrame];
	PImage[] animUpR = new PImage[animURnumFrame];
	PImage[] animDown = new PImage[animDnumFrame];
	PImage[] animDownL = new PImage[animDLnumFrame];
	PImage[] animDownR = new PImage[animDRnumFrame];
	
	PImage[] animIdLeft = new PImage[animIdLnumFrame];
	PImage[] animIdRight = new PImage[animIdRnumFrame];
	PImage[] animIdUp = new PImage[animIdUnumFrame];
	PImage[] animIdUpL = new PImage[animIdULnumFrame];
	PImage[] animIdUpR = new PImage[animIdURnumFrame];
	PImage[] animIdDown = new PImage[animIdDnumFrame];
	PImage[] animIdDownL = new PImage[animIdDLnumFrame];
	PImage[] animIdDownR = new PImage[animIdDRnumFrame];
	
	PImage[] animAxLeft = new PImage[animAxLnumFrame];
	PImage[] animAxRight = new PImage[animAxRnumFrame];
	PImage[] animAxUp = new PImage[animAxUnumFrame];
	PImage[] animAxUpL = new PImage[animAxULnumFrame];
	PImage[] animAxUpR = new PImage[animAxURnumFrame];
	PImage[] animAxDown = new PImage[animAxDnumFrame];
	PImage[] animAxDownL = new PImage[animAxDLnumFrame];
	PImage[] animAxDownR = new PImage[animAxDRnumFrame];
	
	PImage[] animIdAxLeft = new PImage[animIdAxLnumFrame];
	PImage[] animIdAxRight = new PImage[animIdAxRnumFrame];
	PImage[] animIdAxUp = new PImage[animIdAxUnumFrame];
	PImage[] animIdAxUpL = new PImage[animIdAxULnumFrame];
	PImage[] animIdAxUpR = new PImage[animIdAxURnumFrame];
	PImage[] animIdAxDown = new PImage[animIdAxDnumFrame];
	PImage[] animIdAxDownL = new PImage[animIdAxDLnumFrame];
	PImage[] animIdAxDownR = new PImage[animIdAxDRnumFrame];
	
	PImage[] animChopLeft = new PImage[animChopLnumFrame];
	PImage[] animChopRight = new PImage[animChopRnumFrame];
	PImage[] animChopUp = new PImage[animChopUnumFrame];
	PImage[] animChopUpL = new PImage[animChopULnumFrame];
	PImage[] animChopUpR = new PImage[animChopURnumFrame];
	PImage[] animChopDown = new PImage[animChopDnumFrame];
	PImage[] animChopDownL = new PImage[animChopDLnumFrame];
	PImage[] animChopDownR = new PImage[animChopDRnumFrame];
	
	PImage[] animSLeft = new PImage[animLSnumFrame];
	PImage[] animSRight = new PImage[animRSnumFrame];
	PImage[] animSUp = new PImage[animUSnumFrame];
	PImage[] animSDown = new PImage[animDSnumFrame];
	
	int previousDisplayTime;
	int deltaTime;
	
	int previousDisplayTimeIdle;
	int deltaTimeIdle;
	
	int previousDisplayTimeAxeWalk;
	int deltaTimeAxeWalk;
	
	int previousDisplayTimeAxeChop;
	int deltaTimeAxeChop;
	////////////////////
	
	
	/////test mvt complex, fct !!!!
	boolean[] keys=new boolean[4];
	boolean[] mouses = new boolean[2];
	
	boolean mousseLeft = true;
	boolean mousseRight = true;

	boolean playerMove;
	boolean left,right,up,down;
	boolean idle;

	int currentFrameWalkNoAxe = 0;
	int currentFrameChop = 0;
	int currentFrameIdleNoAxe = 0;
	int currentFrameIdleAxe = 0;
	int currentFrameWalkAxe = 0;
	
	boolean idleAxe = false;
	public boolean chop;
	
	public float food;
	public float water;
	float cold;
	float tired;
	float endurance;
	float HP;
	
	float foodMax;
	float waterMax;
	float coldMax;
	float tiredMax;
	float enduranceMax;
	float HPMax;
	
	//boolean pour le changement de skin en fct des raccourcis
	public boolean axeInHand;
	public boolean spearInHand;
	public boolean knifeInHand;

	@SuppressWarnings("deprecation")
	public Player2(PVector l, PApplet p){
		parent = p;
		position = l.get();
		
	    acceleration = new PVector(0, 0);
	    velocity = new PVector(0, 0);
	    velocity.mult(5);
	    maxspeed = 1;
	    maxforce = (float) 0.15;
	    
	    ///test mvt complex
		p.registerMethod("keyEvent", this);
		p.registerMethod("mouseEvent", this);
		
		//////test anim/////
		
		//hand free
		animLeft[0] = p.loadImage("res/newplayer/walk/walkL0.png");
		animLeft[1] = p.loadImage("res/newplayer/walk/walkL1.png");
		animLeft[2] = p.loadImage("res/newplayer/walk/walkL2.png");
		animLeft[3] = p.loadImage("res/newplayer/walk/walkL3.png");
		animLeft[4] = p.loadImage("res/newplayer/walk/walkL4.png");
		animLeft[5] = p.loadImage("res/newplayer/walk/walkL5.png");
		animLeft[6] = p.loadImage("res/newplayer/walk/walkL6.png");
		animLeft[7] = p.loadImage("res/newplayer/walk/walkL7.png");
		
		animRight[0] = p.loadImage("res/newplayer/walk/walkR0.png");
		animRight[1] = p.loadImage("res/newplayer/walk/walkR1.png");
		animRight[2] = p.loadImage("res/newplayer/walk/walkR2.png");
		animRight[3] = p.loadImage("res/newplayer/walk/walkR3.png");
		animRight[4] = p.loadImage("res/newplayer/walk/walkR4.png");
		animRight[5] = p.loadImage("res/newplayer/walk/walkR5.png");
		animRight[6] = p.loadImage("res/newplayer/walk/walkR6.png");
		animRight[7] = p.loadImage("res/newplayer/walk/walkR7.png");
			
		animUp[0] = p.loadImage("res/newplayer/walk/walkU0.png");
		animUp[1] = p.loadImage("res/newplayer/walk/walkU1.png");
		animUp[2] = p.loadImage("res/newplayer/walk/walkU2.png");
		animUp[3] = p.loadImage("res/newplayer/walk/walkU3.png");
		animUp[4] = p.loadImage("res/newplayer/walk/walkU4.png");
		animUp[5] = p.loadImage("res/newplayer/walk/walkU5.png");
		animUp[6] = p.loadImage("res/newplayer/walk/walkU6.png");
		animUp[7] = p.loadImage("res/newplayer/walk/walkU7.png");
		
		animUpR[0] = p.loadImage("res/newplayer/walk/walkUR0.png");
		animUpR[1] = p.loadImage("res/newplayer/walk/walkUR1.png");
		animUpR[2] = p.loadImage("res/newplayer/walk/walkUR2.png");
		animUpR[3] = p.loadImage("res/newplayer/walk/walkUR3.png");
		animUpR[4] = p.loadImage("res/newplayer/walk/walkUR4.png");
		animUpR[5] = p.loadImage("res/newplayer/walk/walkUR5.png");
		animUpR[6] = p.loadImage("res/newplayer/walk/walkUR6.png");
		animUpR[7] = p.loadImage("res/newplayer/walk/walkUR7.png");
		
		animUpL[0] = p.loadImage("res/newplayer/walk/walkUL0.png");
		animUpL[1] = p.loadImage("res/newplayer/walk/walkUL1.png");
		animUpL[2] = p.loadImage("res/newplayer/walk/walkUL2.png");
		animUpL[3] = p.loadImage("res/newplayer/walk/walkUL3.png");
		animUpL[4] = p.loadImage("res/newplayer/walk/walkUL4.png");
		animUpL[5] = p.loadImage("res/newplayer/walk/walkUL5.png");
		animUpL[6] = p.loadImage("res/newplayer/walk/walkUL6.png");
		animUpL[7] = p.loadImage("res/newplayer/walk/walkUL7.png");
			
		animDown[0] = p.loadImage("res/newplayer/walk/walkD0.png");
		animDown[1] = p.loadImage("res/newplayer/walk/walkD1.png");
		animDown[2] = p.loadImage("res/newplayer/walk/walkD2.png");
		animDown[3] = p.loadImage("res/newplayer/walk/walkD3.png");
		animDown[4] = p.loadImage("res/newplayer/walk/walkD4.png");
		animDown[5] = p.loadImage("res/newplayer/walk/walkD5.png");
		animDown[6] = p.loadImage("res/newplayer/walk/walkD6.png");
		animDown[7] = p.loadImage("res/newplayer/walk/walkD7.png");
		
		animDownR[0] = p.loadImage("res/newplayer/walk/walkDR0.png");
		animDownR[1] = p.loadImage("res/newplayer/walk/walkDR1.png");
		animDownR[2] = p.loadImage("res/newplayer/walk/walkDR2.png");
		animDownR[3] = p.loadImage("res/newplayer/walk/walkDR3.png");
		animDownR[4] = p.loadImage("res/newplayer/walk/walkDR4.png");
		animDownR[5] = p.loadImage("res/newplayer/walk/walkDR5.png");
		animDownR[6] = p.loadImage("res/newplayer/walk/walkDR6.png");
		animDownR[7] = p.loadImage("res/newplayer/walk/walkDR7.png");
		
		animDownL[0] = p.loadImage("res/newplayer/walk/walkDL0.png");
		animDownL[1] = p.loadImage("res/newplayer/walk/walkDL1.png");
		animDownL[2] = p.loadImage("res/newplayer/walk/walkDL2.png");
		animDownL[3] = p.loadImage("res/newplayer/walk/walkDL3.png");
		animDownL[4] = p.loadImage("res/newplayer/walk/walkDL4.png");
		animDownL[5] = p.loadImage("res/newplayer/walk/walkDL5.png");
		animDownL[6] = p.loadImage("res/newplayer/walk/walkDL6.png");
		animDownL[7] = p.loadImage("res/newplayer/walk/walkDL7.png");

		
		//idle
		animIdLeft[0] = p.loadImage("res/newplayer/walk/walkL0.png");
		animIdLeft[1] = p.loadImage("res/newplayer/walk/walkL0.png");
		animIdLeft[2] = p.loadImage("res/newplayer/walk/walkL0.png");
		
		animIdRight[0] = p.loadImage("res/newplayer/walk/walkR0.png");
		animIdRight[1] = p.loadImage("res/newplayer/walk/walkR0.png");
		animIdRight[2] = p.loadImage("res/newplayer/walk/walkR0.png");
		
		animIdUp[0] = p.loadImage("res/newplayer/walk/walkU0.png");
		animIdUp[1] = p.loadImage("res/newplayer/walk/walkU0.png");
		animIdUp[2] = p.loadImage("res/newplayer/walk/walkU0.png");
		
		animIdUpR[0] = p.loadImage("res/newplayer/walk/walkUR0.png");
		animIdUpR[1] = p.loadImage("res/newplayer/walk/walkUR0.png");
		animIdUpR[2] = p.loadImage("res/newplayer/walk/walkUR0.png");
		
		animIdUpL[0] = p.loadImage("res/newplayer/walk/walkUL0.png");
		animIdUpL[1] = p.loadImage("res/newplayer/walk/walkUL0.png");
		animIdUpL[2] = p.loadImage("res/newplayer/walk/walkUL0.png");
		
		animIdDown[0] = p.loadImage("res/newplayer/walk/walkD0.png");
		animIdDown[1] = p.loadImage("res/newplayer/walk/walkD0.png");
		animIdDown[2] = p.loadImage("res/newplayer/walk/walkD0.png");
		
		animIdDownR[0] = p.loadImage("res/newplayer/walk/walkDR0.png");
		animIdDownR[1] = p.loadImage("res/newplayer/walk/walkDR0.png");
		animIdDownR[2] = p.loadImage("res/newplayer/walk/walkDR0.png");
		
		animIdDownL[0] = p.loadImage("res/newplayer/walk/walkDL0.png");
		animIdDownL[1] = p.loadImage("res/newplayer/walk/walkDL0.png");
		animIdDownL[2] = p.loadImage("res/newplayer/walk/walkDL0.png");
		
		//walk axe
		animAxLeft[0] = p.loadImage("res/newplayer/walkaxe/walkaxeL0.png");
		animAxLeft[1] = p.loadImage("res/newplayer/walkaxe/walkaxeL1.png");
		animAxLeft[2] = p.loadImage("res/newplayer/walkaxe/walkaxeL2.png");
		animAxLeft[3] = p.loadImage("res/newplayer/walkaxe/walkaxeL3.png");
		animAxLeft[4] = p.loadImage("res/newplayer/walkaxe/walkaxeL4.png");
		animAxLeft[5] = p.loadImage("res/newplayer/walkaxe/walkaxeL5.png");
		animAxLeft[6] = p.loadImage("res/newplayer/walkaxe/walkaxeL6.png");
		animAxLeft[7] = p.loadImage("res/newplayer/walkaxe/walkaxeL7.png");
		
		animAxRight[0] = p.loadImage("res/newplayer/walkaxe/walkaxeR0.png");
		animAxRight[1] = p.loadImage("res/newplayer/walkaxe/walkaxeR1.png");
		animAxRight[2] = p.loadImage("res/newplayer/walkaxe/walkaxeR2.png");
		animAxRight[3] = p.loadImage("res/newplayer/walkaxe/walkaxeR3.png");
		animAxRight[4] = p.loadImage("res/newplayer/walkaxe/walkaxeR4.png");
		animAxRight[5] = p.loadImage("res/newplayer/walkaxe/walkaxeR5.png");
		animAxRight[6] = p.loadImage("res/newplayer/walkaxe/walkaxeR6.png");
		animAxRight[7] = p.loadImage("res/newplayer/walkaxe/walkaxeR7.png");
			
		animAxUp[0] = p.loadImage("res/newplayer/walkaxe/walkaxeU0.png");
		animAxUp[1] = p.loadImage("res/newplayer/walkaxe/walkaxeU1.png");
		animAxUp[2] = p.loadImage("res/newplayer/walkaxe/walkaxeU2.png");
		animAxUp[3] = p.loadImage("res/newplayer/walkaxe/walkaxeU3.png");
		animAxUp[4] = p.loadImage("res/newplayer/walkaxe/walkaxeU4.png");
		animAxUp[5] = p.loadImage("res/newplayer/walkaxe/walkaxeU5.png");
		animAxUp[6] = p.loadImage("res/newplayer/walkaxe/walkaxeU6.png");
		animAxUp[7] = p.loadImage("res/newplayer/walkaxe/walkaxeU7.png");
		
		animAxUpR[0] = p.loadImage("res/newplayer/walkaxe/walkaxeUR0.png");
		animAxUpR[1] = p.loadImage("res/newplayer/walkaxe/walkaxeUR1.png");
		animAxUpR[2] = p.loadImage("res/newplayer/walkaxe/walkaxeUR2.png");
		animAxUpR[3] = p.loadImage("res/newplayer/walkaxe/walkaxeUR3.png");
		animAxUpR[4] = p.loadImage("res/newplayer/walkaxe/walkaxeUR4.png");
		animAxUpR[5] = p.loadImage("res/newplayer/walkaxe/walkaxeUR5.png");
		animAxUpR[6] = p.loadImage("res/newplayer/walkaxe/walkaxeUR6.png");
		animAxUpR[7] = p.loadImage("res/newplayer/walkaxe/walkaxeUR7.png");
		
		animAxUpL[0] = p.loadImage("res/newplayer/walkaxe/walkaxeUL0.png");
		animAxUpL[1] = p.loadImage("res/newplayer/walkaxe/walkaxeUL1.png");
		animAxUpL[2] = p.loadImage("res/newplayer/walkaxe/walkaxeUL2.png");
		animAxUpL[3] = p.loadImage("res/newplayer/walkaxe/walkaxeUL3.png");
		animAxUpL[4] = p.loadImage("res/newplayer/walkaxe/walkaxeUL4.png");
		animAxUpL[5] = p.loadImage("res/newplayer/walkaxe/walkaxeUL5.png");
		animAxUpL[6] = p.loadImage("res/newplayer/walkaxe/walkaxeUL6.png");
		animAxUpL[7] = p.loadImage("res/newplayer/walkaxe/walkaxeUL7.png");
			
		animAxDown[0] = p.loadImage("res/newplayer/walkaxe/walkaxeD0.png");
		animAxDown[1] = p.loadImage("res/newplayer/walkaxe/walkaxeD1.png");
		animAxDown[2] = p.loadImage("res/newplayer/walkaxe/walkaxeD2.png");
		animAxDown[3] = p.loadImage("res/newplayer/walkaxe/walkaxeD3.png");
		animAxDown[4] = p.loadImage("res/newplayer/walkaxe/walkaxeD4.png");
		animAxDown[5] = p.loadImage("res/newplayer/walkaxe/walkaxeD5.png");
		animAxDown[6] = p.loadImage("res/newplayer/walkaxe/walkaxeD6.png");
		animAxDown[7] = p.loadImage("res/newplayer/walkaxe/walkaxeD7.png");
		
		animAxDownR[0] = p.loadImage("res/newplayer/walkaxe/walkaxeDR0.png");
		animAxDownR[1] = p.loadImage("res/newplayer/walkaxe/walkaxeDR1.png");
		animAxDownR[2] = p.loadImage("res/newplayer/walkaxe/walkaxeDR2.png");
		animAxDownR[3] = p.loadImage("res/newplayer/walkaxe/walkaxeDR3.png");
		animAxDownR[4] = p.loadImage("res/newplayer/walkaxe/walkaxeDR4.png");
		animAxDownR[5] = p.loadImage("res/newplayer/walkaxe/walkaxeDR5.png");
		animAxDownR[6] = p.loadImage("res/newplayer/walkaxe/walkaxeDR6.png");
		animAxDownR[7] = p.loadImage("res/newplayer/walkaxe/walkaxeDR7.png");
		
		animAxDownL[0] = p.loadImage("res/newplayer/walkaxe/walkaxeDL0.png");
		animAxDownL[1] = p.loadImage("res/newplayer/walkaxe/walkaxeDL1.png");
		animAxDownL[2] = p.loadImage("res/newplayer/walkaxe/walkaxeDL2.png");
		animAxDownL[3] = p.loadImage("res/newplayer/walkaxe/walkaxeDL3.png");
		animAxDownL[4] = p.loadImage("res/newplayer/walkaxe/walkaxeDL4.png");
		animAxDownL[5] = p.loadImage("res/newplayer/walkaxe/walkaxeDL5.png");
		animAxDownL[6] = p.loadImage("res/newplayer/walkaxe/walkaxeDL6.png");
		animAxDownL[7] = p.loadImage("res/newplayer/walkaxe/walkaxeDL7.png");
		
		//idle axe
		animIdAxLeft[0] = p.loadImage("res/newplayer/walkaxe/walkaxeL0.png");
		animIdAxLeft[1] = p.loadImage("res/newplayer/walkaxe/walkaxeL0.png");
		animIdAxLeft[2] = p.loadImage("res/newplayer/walkaxe/walkaxeL0.png");
		
		animIdAxRight[0] = p.loadImage("res/newplayer/walkaxe/walkaxeR0.png");
		animIdAxRight[1] = p.loadImage("res/newplayer/walkaxe/walkaxeR0.png");
		animIdAxRight[2] = p.loadImage("res/newplayer/walkaxe/walkaxeR0.png");
		
		animIdAxUp[0] = p.loadImage("res/newplayer/walkaxe/walkaxeU0.png");
		animIdAxUp[1] = p.loadImage("res/newplayer/walkaxe/walkaxeU0.png");
		animIdAxUp[2] = p.loadImage("res/newplayer/walkaxe/walkaxeU0.png");
		
		animIdAxUpR[0] = p.loadImage("res/newplayer/walkaxe/walkaxeUR0.png");
		animIdAxUpR[1] = p.loadImage("res/newplayer/walkaxe/walkaxeUR0.png");
		animIdAxUpR[2] = p.loadImage("res/newplayer/walkaxe/walkaxeUR0.png");
		
		animIdAxUpL[0] = p.loadImage("res/newplayer/walkaxe/walkaxeUL0.png");
		animIdAxUpL[1] = p.loadImage("res/newplayer/walkaxe/walkaxeUL0.png");
		animIdAxUpL[2] = p.loadImage("res/newplayer/walkaxe/walkaxeUL0.png");
		
		animIdAxDown[0] = p.loadImage("res/newplayer/walkaxe/walkaxeD0.png");
		animIdAxDown[1] = p.loadImage("res/newplayer/walkaxe/walkaxeD0.png");
		animIdAxDown[2] = p.loadImage("res/newplayer/walkaxe/walkaxeD0.png");
		
		animIdAxDownR[0] = p.loadImage("res/newplayer/walkaxe/walkaxeDR0.png");
		animIdAxDownR[1] = p.loadImage("res/newplayer/walkaxe/walkaxeDR0.png");
		animIdAxDownR[2] = p.loadImage("res/newplayer/walkaxe/walkaxeDR0.png");
		
		animIdAxDownL[0] = p.loadImage("res/newplayer/walkaxe/walkaxeDL0.png");
		animIdAxDownL[1] = p.loadImage("res/newplayer/walkaxe/walkaxeDL0.png");
		animIdAxDownL[2] = p.loadImage("res/newplayer/walkaxe/walkaxeDL0.png");
		
		//chop tree
		animChopLeft[0] = p.loadImage("res/newplayer/chop/chopL0.png");
		animChopLeft[1] = p.loadImage("res/newplayer/chop/chopL1.png");
		animChopLeft[2] = p.loadImage("res/newplayer/chop/chopL2.png");
		animChopLeft[3] = p.loadImage("res/newplayer/chop/chopL3.png");
		animChopLeft[4] = p.loadImage("res/newplayer/chop/chopL4.png");
		animChopLeft[5] = p.loadImage("res/newplayer/chop/chopL5.png");
		
		animChopRight[0] = p.loadImage("res/newplayer/chop/chopR0.png");
		animChopRight[1] = p.loadImage("res/newplayer/chop/chopR1.png");
		animChopRight[2] = p.loadImage("res/newplayer/chop/chopR2.png");
		animChopRight[3] = p.loadImage("res/newplayer/chop/chopR3.png");
		animChopRight[4] = p.loadImage("res/newplayer/chop/chopR4.png");
		animChopRight[5] = p.loadImage("res/newplayer/chop/chopR5.png");
			
		animChopUp[0] = p.loadImage("res/newplayer/chop/chopU0.png");
		animChopUp[1] = p.loadImage("res/newplayer/chop/chopU1.png");
		animChopUp[2] = p.loadImage("res/newplayer/chop/chopU2.png");
		animChopUp[3] = p.loadImage("res/newplayer/chop/chopU3.png");
		animChopUp[4] = p.loadImage("res/newplayer/chop/chopU4.png");
		animChopUp[5] = p.loadImage("res/newplayer/chop/chopU5.png");
		
		animChopUpR[0] = p.loadImage("res/newplayer/chop/chopUR0.png");
		animChopUpR[1] = p.loadImage("res/newplayer/chop/chopUR1.png");
		animChopUpR[2] = p.loadImage("res/newplayer/chop/chopUR2.png");
		animChopUpR[3] = p.loadImage("res/newplayer/chop/chopUR3.png");
		animChopUpR[4] = p.loadImage("res/newplayer/chop/chopUR4.png");
		animChopUpR[5] = p.loadImage("res/newplayer/chop/chopUR5.png");
		
		animChopUpL[0] = p.loadImage("res/newplayer/chop/chopUL0.png");
		animChopUpL[1] = p.loadImage("res/newplayer/chop/chopUL1.png");
		animChopUpL[2] = p.loadImage("res/newplayer/chop/chopUL2.png");
		animChopUpL[3] = p.loadImage("res/newplayer/chop/chopUL3.png");
		animChopUpL[4] = p.loadImage("res/newplayer/chop/chopUL4.png");
		animChopUpL[5] = p.loadImage("res/newplayer/chop/chopUL5.png");
			
		animChopDown[0] = p.loadImage("res/newplayer/chop/chopD0.png");
		animChopDown[1] = p.loadImage("res/newplayer/chop/chopD1.png");
		animChopDown[2] = p.loadImage("res/newplayer/chop/chopD2.png");
		animChopDown[3] = p.loadImage("res/newplayer/chop/chopD3.png");
		animChopDown[4] = p.loadImage("res/newplayer/chop/chopD4.png");
		animChopDown[5] = p.loadImage("res/newplayer/chop/chopD5.png");
		
		animChopDownR[0] = p.loadImage("res/newplayer/chop/chopDR0.png");
		animChopDownR[1] = p.loadImage("res/newplayer/chop/chopDR1.png");
		animChopDownR[2] = p.loadImage("res/newplayer/chop/chopDR2.png");
		animChopDownR[3] = p.loadImage("res/newplayer/chop/chopDR3.png");
		animChopDownR[4] = p.loadImage("res/newplayer/chop/chopDR4.png");
		animChopDownR[5] = p.loadImage("res/newplayer/chop/chopDR5.png");
		
		animChopDownL[0] = p.loadImage("res/newplayer/chop/chopDL0.png");
		animChopDownL[1] = p.loadImage("res/newplayer/chop/chopDL1.png");
		animChopDownL[2] = p.loadImage("res/newplayer/chop/chopDL2.png");
		animChopDownL[3] = p.loadImage("res/newplayer/chop/chopDL3.png");
		animChopDownL[4] = p.loadImage("res/newplayer/chop/chopDL4.png");
		animChopDownL[5] = p.loadImage("res/newplayer/chop/chopDL5.png");
		
		//spear
		animSLeft[0] = p.loadImage("res/player2/spear/L0.png");
		animSLeft[1] = p.loadImage("res/player2/spear/L1.png");
		animSLeft[2] = p.loadImage("res/player2/spear/L2.png");
		animSLeft[3] = p.loadImage("res/player2/spear/L3.png");
		animSLeft[4] = p.loadImage("res/player2/spear/L4.png");
		animSLeft[5] = p.loadImage("res/player2/spear/L5.png");
		animSLeft[6] = p.loadImage("res/player2/spear/L6.png");
		animSLeft[7] = p.loadImage("res/player2/spear/L7.png");
		animSLeft[8] = p.loadImage("res/player2/spear/L8.png");
		
		animSRight[0] = p.loadImage("res/player2/spear/R0.png");
		animSRight[1] = p.loadImage("res/player2/spear/R1.png");
		animSRight[2] = p.loadImage("res/player2/spear/R2.png");
		animSRight[3] = p.loadImage("res/player2/spear/R3.png");
		animSRight[4] = p.loadImage("res/player2/spear/R4.png");
		animSRight[5] = p.loadImage("res/player2/spear/R5.png");
		animSRight[6] = p.loadImage("res/player2/spear/R6.png");
		animSRight[7] = p.loadImage("res/player2/spear/R7.png");
		animSRight[8] = p.loadImage("res/player2/spear/R8.png");
		
		animSUp[0] = p.loadImage("res/player2/spear/U0.png");
		animSUp[1] = p.loadImage("res/player2/spear/U1.png");
		animSUp[2] = p.loadImage("res/player2/spear/U2.png");
		animSUp[3] = p.loadImage("res/player2/spear/U3.png");
		animSUp[4] = p.loadImage("res/player2/spear/U4.png");
		animSUp[5] = p.loadImage("res/player2/spear/U5.png");
		animSUp[6] = p.loadImage("res/player2/spear/U6.png");
		animSUp[7] = p.loadImage("res/player2/spear/U7.png");
		animSUp[8] = p.loadImage("res/player2/spear/U8.png");
		
		animSDown[0] = p.loadImage("res/player2/spear/D0.png");
		animSDown[1] = p.loadImage("res/player2/spear/D1.png");
		animSDown[2] = p.loadImage("res/player2/spear/D2.png");
		animSDown[3] = p.loadImage("res/player2/spear/D3.png");
		animSDown[4] = p.loadImage("res/player2/spear/D4.png");
		animSDown[5] = p.loadImage("res/player2/spear/D5.png");
		animSDown[6] = p.loadImage("res/player2/spear/D6.png");
		animSDown[7] = p.loadImage("res/player2/spear/D7.png");
		animSDown[8] = p.loadImage("res/player2/spear/D8.png");
		
		deltaTime = 150; // animation speed -=fast +=slow
		previousDisplayTime = 0;
		
		deltaTimeIdle = 150; // animation speed -=fast +=slow
		previousDisplayTimeIdle = 0;
		
		deltaTimeAxeWalk = 150;
		previousDisplayTimeAxeWalk = 0;
		
		deltaTimeAxeChop = 150;
		previousDisplayTimeAxeChop = 0;
		
		
		////////////////////

		///food wter ect
		food = 300;
		water = 300;
		HP = 100;
		
		foodMax = 300;
		waterMax = 300;
		coldMax = 100;
		tiredMax = 100;
		HPMax = 100;

	}
	
	public void move() {
		if (keys[0]){
			position.y += 10; 
			
		}
	    if (keys[1]){
	    	position.y -= 10; 
	    	
	    }
	    if (keys[2]){
	    	position.x -= 10;  
	    	
	    }
	    if (keys[3]){
	    	position.x += 10;	
	    	
	    }
	}
	
	/*
	//pas besoin pour l'instant, fct tres bien sans
	public void animCondition(){ //attention idle est inversé, pas complet manque des conditions
		if(idle == false){
			idleAxe = false;
			walk = false;
			walkAxe = false;
			chop = false;
		}
		if(idleAxe == true){
			idle = true;
			walk = false;
			walkAxe = false;
			chop = false;
		}
		if(walk == true){
			idle = true;
			idleAxe = false;
			walkAxe = false;
			chop = false;
		}
		if(walkAxe == true){
			idle = true;
			idleAxe = false;
			walk = false;
			chop = false;
		}
		if(chop == true){
			idle = true;
			idleAxe = false;
			walk = false;
			walkAxe = false;
		}
		
	}
	*/
	
	@SuppressWarnings("deprecation")
	public void display(PApplet p,PVector MP){
		//parent.fill(255,0,0);
		//parent.stroke(255,0,0);
		//parent.noFill();
		//parent.ellipse(position.x, position.y, 400, 400);
		//parent.noStroke();
		//parent.fill(255,0,0);
		//parent.text("pos x " + position.x + "pos y " + position.y, position.x + 10,  position.y + 10);
		//parent.text("mp x " + MP.x + "mp y " + MP.y, position.x + 10,  position.y + 30);
		
		
		////test anim souris fct parfait mais à bouger pour le idle et mouvement
		centerPoint = new PVector(position.x,position.y);
		float angle = angleBetweenPV_PV(centerPoint, new PVector(MP.x, MP.y));
		angle=fixAngle(angle);
		
		int dir=0;
		float angleInDegrees=PApplet.degrees(angle);
		float scliceDegree = 360/8 ;  //4

		dir = 0;
		if       ( isBetween (angleInDegrees, 0*scliceDegree, 1*scliceDegree) ){
			dir = 0; //right
		}
		else  if ( isBetween (angleInDegrees, 1*scliceDegree, 2*scliceDegree) ){
			dir = 1; //rightdown
		}
		else  if ( isBetween (angleInDegrees, 2*scliceDegree, 3*scliceDegree) ){
			dir = 2; //down
		}
		else if  ( isBetween (angleInDegrees, 3*scliceDegree, 4*scliceDegree) ){
			dir = 3; //downleft
		}
		else if  ( isBetween (angleInDegrees, 4*scliceDegree, 5*scliceDegree) ){
			dir = 4; //left
		}
		else if  ( isBetween (angleInDegrees, 5*scliceDegree, 6*scliceDegree) ){
			dir = 5; //leftup
		}
		else if  ( isBetween (angleInDegrees, 6*scliceDegree, 7*scliceDegree) ){
			dir = 6; //up
		}
		else if  ( isBetween (angleInDegrees, 7*scliceDegree, 8*scliceDegree) ){
			dir = 7; //upright
		}
		
		
		//parent.text(angle +"\n" +PApplet.degrees(angle) + "\n" + dir + ": " + textFromDir[ dir ], position.x +10, position.y +40);
		
		if(idle == true){
			//parent.text("idle false", position.x + 20,  position.y + 20);
		}
		
		if(idle == false){
			//parent.text("idle true", position.x + 20,  position.y + 20);
		}
		
		if(axeInHand){
			//parent.text("AXE", position.x + 20,  position.y + 20);
		}
		
		if(spearInHand){
			parent.text("SPEAR", position.x + 10,  position.y + 20);
		}
		
		if(knifeInHand){
			parent.text("KNIFE", position.x + 10,  position.y + 20);
		}
		
		///ici on met l'anim
		switch(dir){
		case 0:
	    	//idle without axe
	    	if(idle == true && axeInHand == false && playerMove == false){
	    		if (p.millis() > previousDisplayTimeIdle + deltaTimeIdle) {
	    			currentFrameIdleNoAxe++;
		    	    if (currentFrameIdleNoAxe > 2) { 
		    	    	currentFrameIdleNoAxe = 0;
		    	    }
		    	    previousDisplayTimeIdle = p.millis();
		    	}
	    		p.image(animIdRight[currentFrameIdleNoAxe],position.x-22,position.y-22);
	    	}
	    	//idle axe
	    	if(axeInHand == true && idle == true && chop == false && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
	    			currentFrameIdleAxe++;
		    	    if (currentFrameIdleAxe > 2) { 
		    	    	currentFrameIdleAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animIdAxRight[currentFrameIdleAxe],position.x-22,position.y-22);
	    	}
	    	//walk axe
	    	if(axeInHand == true && idle == false && chop == false && playerMove == true){
	    		if (p.millis() > previousDisplayTimeAxeWalk + deltaTimeAxeWalk) {
	    			currentFrameWalkAxe++;
		    	    if (currentFrameWalkAxe > 7) { 
		    	    	currentFrameWalkAxe = 0;
		    	    }
		    	    previousDisplayTimeAxeWalk = p.millis();
		    	}
	    		p.image(animAxRight[currentFrameWalkAxe],position.x-22,position.y-22);
	    	}
	    	//walk without axe
	    	if(idle == false && axeInHand == false && playerMove == true){
		    	if (p.millis() > previousDisplayTime + deltaTime) {
		    		currentFrameWalkNoAxe++;
		    	    if (currentFrameWalkNoAxe > 7) { 
		    	    	currentFrameWalkNoAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animRight[currentFrameWalkNoAxe],position.x-22,position.y-22);
	    	}
	    	//chop 
	    	if(chop == true && axeInHand == true && idle == true && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
		    	    currentFrameChop++;
		    	    if (currentFrameChop > 5) { 
		    	    	currentFrameChop = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animChopRight[currentFrameChop],position.x-22,position.y-22);
	    	}
	    	
	    	break;
		case 1:
	    	
	    	//idle without axe
	    	if(idle == true && axeInHand == false && playerMove == false){
	    		if (p.millis() > previousDisplayTimeIdle + deltaTimeIdle) {
	    			currentFrameIdleNoAxe++;
		    	    if (currentFrameIdleNoAxe > 2) { 
		    	    	currentFrameIdleNoAxe = 0;
		    	    }
		    	    previousDisplayTimeIdle = p.millis();
		    	}
	    		p.image(animIdDownR[currentFrameIdleNoAxe],position.x-22,position.y-22);
	    	}
	    	//idle axe
	    	if(axeInHand == true && idle == true && chop == false && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
	    			currentFrameIdleAxe++;
		    	    if (currentFrameIdleAxe > 2) { 
		    	    	currentFrameIdleAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animIdAxDownR[currentFrameIdleAxe],position.x-22,position.y-22);
	    	}
	    	//walk axe
	    	if(axeInHand == true && idle == false && chop == false && playerMove == true){
	    		if (p.millis() > previousDisplayTimeAxeWalk + deltaTimeAxeWalk) {
	    			currentFrameWalkAxe++;
		    	    if (currentFrameWalkAxe > 7) { 
		    	    	currentFrameWalkAxe = 0;
		    	    }
		    	    previousDisplayTimeAxeWalk = p.millis();
		    	}
	    		p.image(animAxDownR[currentFrameWalkAxe],position.x-22,position.y-22);
	    	}
	    	//walk without axe
	    	if(idle == false && axeInHand == false && playerMove == true){
		    	if (p.millis() > previousDisplayTime + deltaTime) {
		    		currentFrameWalkNoAxe++;
		    	    if (currentFrameWalkNoAxe > 7) { 
		    	    	currentFrameWalkNoAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animDownR[currentFrameWalkNoAxe],position.x-22,position.y-22);
	    	}
	    	//chop 
	    	if(chop == true && axeInHand == true && idle == true && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
		    	    currentFrameChop++;
		    	    if (currentFrameChop > 5) { 
		    	    	currentFrameChop = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animChopDownR[currentFrameChop],position.x-22,position.y-22);
	    	}
	    	
	    	break;
		case 2:
	    	
	    	//idle without axe
	    	if(idle == true && axeInHand == false && playerMove == false){
	    		if (p.millis() > previousDisplayTimeIdle + deltaTimeIdle) {
	    			currentFrameIdleNoAxe++;
		    	    if (currentFrameIdleNoAxe > 2) { 
		    	    	currentFrameIdleNoAxe = 0;
		    	    }
		    	    previousDisplayTimeIdle = p.millis();
		    	}
	    		p.image(animIdDown[currentFrameIdleNoAxe],position.x-22,position.y-22);
	    	}
	    	//idle axe
	    	if(axeInHand == true && idle == true && chop == false && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
	    			currentFrameIdleAxe++;
		    	    if (currentFrameIdleAxe > 2) { 
		    	    	currentFrameIdleAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animIdAxDown[currentFrameIdleAxe],position.x-22,position.y-22);
	    	}
	    	//walk axe
	    	if(axeInHand == true && idle == false && chop == false && playerMove == true){
	    		if (p.millis() > previousDisplayTimeAxeWalk + deltaTimeAxeWalk) {
	    			currentFrameWalkAxe++;
		    	    if (currentFrameWalkAxe > 7) { 
		    	    	currentFrameWalkAxe = 0;
		    	    }
		    	    previousDisplayTimeAxeWalk = p.millis();
		    	}
	    		p.image(animAxDown[currentFrameWalkAxe],position.x-22,position.y-22);
	    	}
	    	//walk without axe
	    	if(idle == false && axeInHand == false && playerMove == true){
		    	if (p.millis() > previousDisplayTime + deltaTime) {
		    		currentFrameWalkNoAxe++;
		    	    if (currentFrameWalkNoAxe > 7) { 
		    	    	currentFrameWalkNoAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animDown[currentFrameWalkNoAxe],position.x-22,position.y-22);
	    	}
	    	//chop 
	    	if(chop == true && axeInHand == true && idle == true && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
		    	    currentFrameChop++;
		    	    if (currentFrameChop > 5) { 
		    	    	currentFrameChop = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animChopDown[currentFrameChop],position.x-22,position.y-22);
	    	}
	    	
	    	break;
		case 3:
	    	
	    	//idle without axe
	    	if(idle == true && axeInHand == false && playerMove == false){
	    		if (p.millis() > previousDisplayTimeIdle + deltaTimeIdle) {
	    			currentFrameIdleNoAxe++;
		    	    if (currentFrameIdleNoAxe > 2) { 
		    	    	currentFrameIdleNoAxe = 0;
		    	    }
		    	    previousDisplayTimeIdle = p.millis();
		    	}
	    		p.image(animIdDownL[currentFrameIdleNoAxe],position.x-22,position.y-22);
	    	}
	    	//idle axe
	    	if(axeInHand == true && idle == true && chop == false && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
	    			currentFrameIdleAxe++;
		    	    if (currentFrameIdleAxe > 2) { 
		    	    	currentFrameIdleAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animIdAxDownL[currentFrameIdleAxe],position.x-22,position.y-22);
	    	}
	    	//walk axe
	    	if(axeInHand == true && idle == false && chop == false && playerMove == true){
	    		if (p.millis() > previousDisplayTimeAxeWalk + deltaTimeAxeWalk) {
	    			currentFrameWalkAxe++;
		    	    if (currentFrameWalkAxe > 7) { 
		    	    	currentFrameWalkAxe = 0;
		    	    }
		    	    previousDisplayTimeAxeWalk = p.millis();
		    	}
	    		p.image(animAxDownL[currentFrameWalkAxe],position.x-22,position.y-22);
	    	}
	    	//walk without axe
	    	if(idle == false && axeInHand == false && playerMove == true){
		    	if (p.millis() > previousDisplayTime + deltaTime) {
		    		currentFrameWalkNoAxe++;
		    	    if (currentFrameWalkNoAxe > 7) { 
		    	    	currentFrameWalkNoAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animDownL[currentFrameWalkNoAxe],position.x-22,position.y-22);
	    	}
	    	//chop 
	    	if(chop == true && axeInHand == true && idle == true && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
		    	    currentFrameChop++;
		    	    if (currentFrameChop > 5) { 
		    	    	currentFrameChop = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animChopDownL[currentFrameChop],position.x-22,position.y-22);
	    	}
	    	
	    	break;
	    	
		case 4:
	    	
	    	//idle without axe
	    	if(idle == true && axeInHand == false && playerMove == false){
	    		if (p.millis() > previousDisplayTimeIdle + deltaTimeIdle) {
	    			currentFrameIdleNoAxe++;
		    	    if (currentFrameIdleNoAxe > 2) { 
		    	    	currentFrameIdleNoAxe = 0;
		    	    }
		    	    previousDisplayTimeIdle = p.millis();
		    	}
	    		p.image(animIdLeft[currentFrameIdleNoAxe],position.x-22,position.y-22);
	    	}
	    	//idle axe
	    	if(axeInHand == true && idle == true && chop == false && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
	    			currentFrameIdleAxe++;
		    	    if (currentFrameIdleAxe > 2) { 
		    	    	currentFrameIdleAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animIdAxLeft[currentFrameIdleAxe],position.x-22,position.y-22);
	    	}
	    	//walk axe
	    	if(axeInHand == true && idle == false && chop == false && playerMove == true){
	    		if (p.millis() > previousDisplayTimeAxeWalk + deltaTimeAxeWalk) {
	    			currentFrameWalkAxe++;
		    	    if (currentFrameWalkAxe > 7) { 
		    	    	currentFrameWalkAxe = 0;
		    	    }
		    	    previousDisplayTimeAxeWalk = p.millis();
		    	}
	    		p.image(animAxLeft[currentFrameWalkAxe],position.x-22,position.y-22);
	    	}
	    	//walk without axe
	    	if(idle == false && axeInHand == false && playerMove == true){
		    	if (p.millis() > previousDisplayTime + deltaTime) {
		    		currentFrameWalkNoAxe++;
		    	    if (currentFrameWalkNoAxe > 7) { 
		    	    	currentFrameWalkNoAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animLeft[currentFrameWalkNoAxe],position.x-22,position.y-22);
	    	}
	    	//chop 
	    	if(chop == true && axeInHand == true && idle == true && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
		    	    currentFrameChop++;
		    	    if (currentFrameChop > 5) { 
		    	    	currentFrameChop = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animChopLeft[currentFrameChop],position.x-22,position.y-22);
	    	}
	    	
	    	break;
	    	
		case 5:
	    	
	    	//idle without axe
	    	if(idle == true && axeInHand == false && playerMove == false){
	    		if (p.millis() > previousDisplayTimeIdle + deltaTimeIdle) {
	    			currentFrameIdleNoAxe++;
		    	    if (currentFrameIdleNoAxe > 2) { 
		    	    	currentFrameIdleNoAxe = 0;
		    	    }
		    	    previousDisplayTimeIdle = p.millis();
		    	}
	    		p.image(animIdUpL[currentFrameIdleNoAxe],position.x-22,position.y-22);
	    	}
	    	//idle axe
	    	if(axeInHand == true && idle == true && chop == false && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
	    			currentFrameIdleAxe++;
		    	    if (currentFrameIdleAxe > 2) { 
		    	    	currentFrameIdleAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animIdAxUpL[currentFrameIdleAxe],position.x-22,position.y-22);
	    	}
	    	//walk axe
	    	if(axeInHand == true && idle == false && chop == false && playerMove == true){
	    		if (p.millis() > previousDisplayTimeAxeWalk + deltaTimeAxeWalk) {
	    			currentFrameWalkAxe++;
		    	    if (currentFrameWalkAxe > 7) { 
		    	    	currentFrameWalkAxe = 0;
		    	    }
		    	    previousDisplayTimeAxeWalk = p.millis();
		    	}
	    		p.image(animAxUpL[currentFrameWalkAxe],position.x-22,position.y-22);
	    	}
	    	//walk without axe
	    	if(idle == false && axeInHand == false && playerMove == true){
		    	if (p.millis() > previousDisplayTime + deltaTime) {
		    		currentFrameWalkNoAxe++;
		    	    if (currentFrameWalkNoAxe > 7) { 
		    	    	currentFrameWalkNoAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animUpL[currentFrameWalkNoAxe],position.x-22,position.y-22);
	    	}
	    	//chop 
	    	if(chop == true && axeInHand == true && idle == true && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
		    	    currentFrameChop++;
		    	    if (currentFrameChop > 5) { 
		    	    	currentFrameChop = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animChopUpL[currentFrameChop],position.x-22,position.y-22);
	    	}
	    	
	    	break;
	    	
		case 6:
	    	//idle without axe
	    	if(idle == true && axeInHand == false && playerMove == false){
	    		if (p.millis() > previousDisplayTimeIdle + deltaTimeIdle) {
	    			currentFrameIdleNoAxe++;
		    	    if (currentFrameIdleNoAxe > 2) { 
		    	    	currentFrameIdleNoAxe = 0;
		    	    }
		    	    previousDisplayTimeIdle = p.millis();
		    	}
	    		p.image(animIdUp[currentFrameIdleNoAxe],position.x-22,position.y-22);
	    	}
	    	//idle axe
	    	if(axeInHand == true && idle == true && chop == false && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
	    			currentFrameIdleAxe++;
		    	    if (currentFrameIdleAxe > 2) { 
		    	    	currentFrameIdleAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animIdAxUp[currentFrameIdleAxe],position.x-22,position.y-22);
	    	}
	    	//walk axe
	    	if(axeInHand == true && idle == false && chop == false && playerMove == true){
	    		if (p.millis() > previousDisplayTimeAxeWalk + deltaTimeAxeWalk) {
	    			currentFrameWalkAxe++;
		    	    if (currentFrameWalkAxe > 7) { 
		    	    	currentFrameWalkAxe = 0;
		    	    }
		    	    previousDisplayTimeAxeWalk = p.millis();
		    	}
	    		p.image(animAxUp[currentFrameWalkAxe],position.x-22,position.y-22);
	    	}
	    	//walk without axe
	    	if(idle == false && axeInHand == false && playerMove == true){
		    	if (p.millis() > previousDisplayTime + deltaTime) {
		    		currentFrameWalkNoAxe++;
		    	    if (currentFrameWalkNoAxe > 7) { 
		    	    	currentFrameWalkNoAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animUp[currentFrameWalkNoAxe],position.x-22,position.y-22);
	    	}
	    	//chop 
	    	if(chop == true && axeInHand == true && idle == true && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
		    	    currentFrameChop++;
		    	    if (currentFrameChop > 5) { 
		    	    	currentFrameChop = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animChopUp[currentFrameChop],position.x-22,position.y-22);
	    	}
	    	
	    	break;
	    	
		case 7:
	    	//idle without axe
	    	if(idle == true && axeInHand == false && playerMove == false){
	    		if (p.millis() > previousDisplayTimeIdle + deltaTimeIdle) {
	    			currentFrameIdleNoAxe++;
		    	    if (currentFrameIdleNoAxe > 2) { 
		    	    	currentFrameIdleNoAxe = 0;
		    	    }
		    	    previousDisplayTimeIdle = p.millis();
		    	}
	    		p.image(animIdUpR[currentFrameIdleNoAxe],position.x-22,position.y-22);
	    	}
	    	//idle axe
	    	if(axeInHand == true && idle == true && chop == false && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
	    			currentFrameIdleAxe++;
		    	    if (currentFrameIdleAxe > 2) { 
		    	    	currentFrameIdleAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animIdAxUpR[currentFrameIdleAxe],position.x-22,position.y-22);
	    	}
	    	//walk axe
	    	if(axeInHand == true && idle == false && chop == false && playerMove == true){
	    		if (p.millis() > previousDisplayTimeAxeWalk + deltaTimeAxeWalk) {
	    			currentFrameWalkAxe++;
		    	    if (currentFrameWalkAxe > 7) { 
		    	    	currentFrameWalkAxe = 0;
		    	    }
		    	    previousDisplayTimeAxeWalk = p.millis();
		    	}
	    		p.image(animAxUpR[currentFrameWalkAxe],position.x-22,position.y-22);
	    	}
	    	//walk without axe
	    	if(idle == false && axeInHand == false && playerMove == true){
		    	if (p.millis() > previousDisplayTime + deltaTime) {
		    		currentFrameWalkNoAxe++;
		    	    if (currentFrameWalkNoAxe > 7) { 
		    	    	currentFrameWalkNoAxe = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animUpR[currentFrameWalkNoAxe],position.x-22,position.y-22);
	    	}
	    	//chop 
	    	if(chop == true && axeInHand == true && idle == true && playerMove == false){
	    		if (p.millis() > previousDisplayTime + deltaTime) {
		    	    currentFrameChop++;
		    	    if (currentFrameChop > 5) { 
		    	    	currentFrameChop = 0;
		    	    }
		    	    previousDisplayTime = p.millis();
		    	}
	    		
	    		p.image(animChopUpR[currentFrameChop],position.x-22,position.y-22);
	    	}
	    	
	    	break;
	    	
	    	
	    	
		}
	}
	
	String[] textFromDir = {
		"Right", 
		"Right,down", 
		"down", 
		"down, left", 
		"left", 
		"left up", 
		"up", 
		"up right", 
	}; 
	
	boolean isBetween(float inputValue, float down, float up) {
		return inputValue>down- 360/16 && inputValue<up- 360/16;
	}
	
	float angleBetweenPV_PV(PVector centerPV, PVector movingPV) {
		// calc angle : the core of the sketch 
		PVector d = new PVector();
		// calc angle
		// delta 
		d.x = movingPV.x - centerPV.x;
		d.y = movingPV.y - centerPV.y;
		// angle 
		float angle1 = PApplet.atan2(d.y, d.x);
		return angle1;
	} 

	float fixAngle(float angle1) {
		// if > 2xPI 
		if (angle1>PConstants.TWO_PI) angle1-=PConstants.TWO_PI; 
		if (angle1>PConstants.TWO_PI) angle1-=PConstants.TWO_PI; 

		// if < 0 (negative angles like -40 should be expressed as positive angles like 320)
		if (angle1<0.0) {
			angle1 = PConstants.TWO_PI + angle1;
		}
		if (angle1<0.0) angle1 = PConstants.TWO_PI + angle1;
			return angle1;
	}
	
	public void PlayerMvt(PApplet p){
		if(p.keyPressed){
			if(p.key == PConstants.CODED){
				if(p.keyCode == PConstants.UP){
					position.y -= 20;
				}
				if(p.keyCode == PConstants.DOWN){
					position.y += 20;
				}
				if(p.keyCode == PConstants.LEFT){
					position.x -= 20;
				}
				if(p.keyCode == PConstants.RIGHT){
					position.x += 20;
				}
			}
		}
	}
	
	public void eatRedBerry(){
		if(mousseLeft && mouses[0] == true){
			food += 20;
			if(food > foodMax) food = foodMax;
			mousseLeft = false;
		}
		if(mouses[0] == false){
			mousseLeft = true;
		}
	}
	
	public void eatYellowBerry(){
		if(mousseLeft && mouses[0] == true){
			food += 20;
			if(food > foodMax) food = foodMax;
			mousseLeft = false;
		}
		if(mouses[0] == false){
			mousseLeft = true;
		}
	}

	public void eatMushroom(){
		if(mousseLeft && mouses[0] == true){
			food += 20;
			if(food > foodMax) food = foodMax;
			mousseLeft = false;
		}
		if(mouses[0] == false){
			mousseLeft = true;
		}
	}

	public void updateCarac(){
		food -= 0.03;
	    if( food < 0) food = 0;
	    if(food > foodMax) food = foodMax;
	    water -= 0.04;
	    if( water < 0) water = 0;
	    if(water > waterMax) water = waterMax;
	    
	    if(HP < 0) HP = 0;
	}

	
	public void displayBar(PVector pos, PVector screen){ //chiffre à modif 
		
		PImage logoPV = parent.loadImage("res/icons/life.png");
		PImage logoFood = parent.loadImage("res/icons/food.png");
		PImage logoWater = parent.loadImage("res/icons/water.png");
		
		PImage frontBars = parent.loadImage("res/GUI/bars/frontBars.png");
		PImage backBars = parent.loadImage("res/GUI/bars/backBars.png");
		
		/*
		// barre de base (vide)
		parent.noFill();
		parent.stroke(0);
		parent.rectMode(PConstants.CORNER);
		//parent.rect(pos.x - screen.x +50 , pos.y + screen.y -100 , 200, 10); //6
		//parent.rect(pos.x - screen.x +50 , pos.y + screen.y -115 , 200, 10); //5
		//parent.rect(pos.x - screen.x +50 , pos.y + screen.y -130 , 200, 10); //4
		parent.rect(pos.x - screen.x +50 , pos.y + screen.y -111 , 200, 10); //3
		parent.rect(pos.x - screen.x +50 , pos.y + screen.y -143 , 200, 10); //2
		parent.rect(pos.x - screen.x +50 , pos.y + screen.y -175 , 200, 10); //1
		
		//barre pleine 
		//1: HP
		
		
		//2: food
		parent.fill(76,153,0);
		parent.rect(pos.x - screen.x +50 , pos.y + screen.y -143 , (food/foodMax)*200, 10);
		parent.image(logoFood, pos.x - screen.x +18 , pos.y + screen.y -153);
		parent.noFill();
		
		//3: water
		parent.fill(0,153,153);
		parent.rect(pos.x - screen.x +50 , pos.y + screen.y -111 , (water/waterMax)*200, 10);
		parent.image(logoWater, pos.x - screen.x +18 , pos.y + screen.y -121);
		parent.noFill();
		*/
		
		//back bars
		parent.image(backBars, pos.x - screen.x, pos.y - screen.y);
		
		
		//bars interactives
		//hp
		parent.rectMode(PConstants.CORNER);
		parent.fill(255,0,0,125);
		parent.rect(pos.x - screen.x +12 , pos.y - screen.y +10 , 55, (HP/HPMax)*50);
		parent.noFill();
		//food
		parent.fill(76,153,0,125);
		parent.rect(pos.x - screen.x +66, pos.y - screen.y +10 , 57, (food/foodMax)*50);
		parent.noFill();
		//water
		parent.fill(0,153,153,125);
		parent.rect(pos.x - screen.x +132 , pos.y - screen.y +10 , 55, (water/waterMax)*50);
		parent.noFill();
		
		//front bars
		parent.image(frontBars, pos.x - screen.x, pos.y - screen.y);
		
		
		
	}
	
	public void keyEvent(KeyEvent e){
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
	
	public void checkInputAnimation(){
		if(down == true || up == true || left == true || right == true){
			playerMove = true;
		}
		if(left == false && up == false && down == false && right == false){
			playerMove = false;
		}
		if(playerMove == true) idle = false;
		if(playerMove == false) idle = true;
	}

	
	public void keyPressedProcess(int keyCode, char keyChar, boolean shiftDown, boolean ctrlDown){
		if (keyChar=='s'){
			keys[0]=true;
			down = true;
		}
	    if (keyChar=='z'){
	    	keys[1]=true;
	    	up = true;
	    }
	    if (keyChar=='q'){
	    	keys[2]=true;
	    	left = true;
	    }
	    if (keyChar=='d'){
	    	keys[3]=true;
	    	right = true;
	    }
	}
	
	public void keyReleasedProcess(int keyCode, char keyChar, boolean shiftDown, boolean ctrlDown){
		if (keyChar=='s'){
			keys[0]=false;
			down = false;
		}
	    if (keyChar=='z'){
	    	keys[1]=false;
	    	up = false;
	    }
	    if (keyChar=='q'){
	    	keys[2]=false;
	    	left = false;
	    }
	    if (keyChar=='d'){
	    	keys[3]=false;
	    	right = false;
	    }
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
