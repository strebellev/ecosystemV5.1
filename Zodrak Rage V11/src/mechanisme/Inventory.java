package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;
import processing.event.KeyEvent;
import processing.event.MouseEvent;



public class Inventory {
	PApplet parent;
	ArrayList<PVector> inventory;
	
	
	//des int pour chaque objets et pour objets total
	
	
	int mode;
	int craftMode;
	int craftSlot;
	int craftTab;
	
	public boolean inventoryOpen;
	public boolean craftingOpen;
	
	boolean[] keys=new boolean[8];
	
	boolean[] mouses = new boolean[2];
	
	boolean okayI = true;
	boolean okayE = true;
	boolean okayC = true;
	public boolean actionE = false;
	
	boolean mousseLeft = true;
	boolean mousseRight = true;
	public boolean actionLM ;
	public boolean actionRM ;
	int rightClickTime;
	int leftClickTime;
	//dragdrop
	public boolean dragLeft;
	public boolean canDrop1;
	public boolean canDrop2;
	public boolean canDrop3;
	public boolean inHand1;
	public boolean inHand2;
	public boolean inHand3;
	public boolean locked;
	public boolean distInvSlot12;
	public boolean distInvSlot14;
	public boolean distInvSlot15;
	public boolean distHandSlot1;
	public boolean distHandSlot2;
	public boolean distHandSlot3;
	
	//racourcis
	int shortcut1;
	public boolean shortCut1;
	public boolean shortCut1Full;
	boolean okay1;
	
	int shortcut2;
	public boolean shortCut2;
	public boolean shortCut2Full;
	boolean okay2;
	
	int shortcut3;
	public boolean shortCut3;
	public boolean shortCut3Full;
	boolean okay3;
	
	//cut tree
	public boolean cutTree;
	
	//spear attack
	public boolean spearAttack;
	
	public int invMushroom = 20;
	public int invRedBerry = 20;
	public int invJellowBerry = 20;
	public int invGrass = 20;
	public int invRock = 20;
	public int invBranch = 20;
	public int invLog = 20;
	public int invSmallBranch = 20;
	public int invString = 20;
	public int invFurr = 1;
	public int invMeat = 1;
	public int invFlower = 1;
	
	public int invStoneAxe = 1;
	public int invFire = 1;
	public int invStoneKnife = 1;
	public int invStoneLance = 1;
	public int invArrow = 1;
	public int invBow = 1;
	public int invCookedMeat = 1;
	
	public int invTent = 1;
	public int invLeafTent = 1;
	public int invWoodStock;
	public int invColet;
	public int invTrap;
	public int invRope = 20;
	public int invStick = 20;
	public int invPointyStick = 20;
	public int invWell;
	public int invBed;
	public int invStock;
	
	
	PImage imgmush ;
	PImage imgRedBerry ;
	PImage imgGrass ;
	PImage imgRock ;
	PImage imgBranch ;
	PImage imgLog ; 
	PImage imgSmallBranch ;
	PImage imgString ;
	
	PImage imgMeat ;
	PImage imgFurr ;
	
	PImage imgAxe ;
	PImage imgFireCamp ;
	PImage imgKnife;
	PImage imgSpear; 
	PImage imgArrow;
	PImage imgBow;
	
	PImage imgTentLogo;
	PImage imgLeafTentLogo;
	PImage imgRope;
	PImage imgStick;
	PImage imgPointyStick;
	PImage imgCoockedMeat;
	
	PImage inventorydisplay;
	
	PImage imgCrafting;
	PImage tab0;
	PImage tab1;
	PImage tab2;
	PImage tab3;
	PImage tab4;
	PImage tab5;
	PImage slot1;
	PImage slot2;
	PImage slot3;
	
	//tab0
	PImage stringU;
	PImage ropeU;
	PImage stickU;
	PImage pointyStickU;
	
	PImage stringS;
	PImage ropeS;
	PImage stickS;
	PImage pointyStickS;
	
	//tab1
	PImage axeU;
	PImage knifeU;
	
	PImage axeS;
	PImage knifeS;
	
	//tab2
	PImage arrowU;
	PImage bowU;
	PImage spearU;
	
	PImage arrowS;
	PImage bowS;
	PImage spearS;
	
	//tab4
	
	PImage fireU;
	PImage stickTentU;
	PImage leafTentU;
	
	PImage fireS;
	PImage leafTentS;
	PImage stickTentS;
	
	PImage mouse;

	
	public Inventory(PApplet p){
		parent = p;
		inventory = new ArrayList<PVector>();
		p.registerMethod("keyEvent", this);
		p.registerMethod("mouseEvent", this);
		
		imgmush = parent.loadImage("res/newObject/mushrooms.png");
		imgRedBerry = parent.loadImage("res/newObject/berries.png");
		imgGrass = parent.loadImage("res/newObject/grass.png");
		imgRock = parent.loadImage("/res/newObject/rock.png");
		imgBranch = parent.loadImage("res/newObject/treeBranch.png");
		imgLog = parent.loadImage("res/newObject/logIcon.png"); 
		imgSmallBranch = parent.loadImage("res/newObject/plantBranch.png");
		imgString = parent.loadImage("res/newObject/string.png");
		imgRope = parent.loadImage("res/newObject/rope.png");
		
		imgMeat = parent.loadImage("res/newObject/meat.png");
		imgFurr = parent.loadImage("res/newObject/fur.png");
		
		imgAxe = parent.loadImage("res/newObject/stoneaxe.png");
		imgFireCamp = parent.loadImage("res/newObject/campfireLogo.png");
		imgKnife = parent.loadImage("res/newObject/stoneKnife.png");
		imgSpear = parent.loadImage("res/newObject/stoneSpear.png"); 
		imgArrow = parent.loadImage("res/newObject/arrow.png");
		imgBow = parent.loadImage("res/newObject/bow.png");
		
		//PImage imgTent = parent.loadImage("res/object/tent0.png");
		imgTentLogo = parent.loadImage("res/newObject/tent.png");
		imgLeafTentLogo = parent.loadImage("res/newObject/leafyTent.png");
		imgStick = parent.loadImage("res/newObject/woodenstick.png");
		imgPointyStick = parent.loadImage("res/newObject/pointyWoodenstick.png");
		imgCoockedMeat = parent.loadImage("res/newObject/cookedMeat.png");
		inventorydisplay = parent.loadImage("res/GUI/inventory/inventory.png");

		imgGrass = parent.loadImage("res/newObject/grass.png");
		imgRock = parent.loadImage("res/newObject/rock.png");
		imgString = parent.loadImage("res/newObject/string.png");
		
		
		imgAxe = parent.loadImage("res/newObject/stoneaxe.png");
		imgFireCamp = parent.loadImage("res/newObject/campfireLogo.png");
		imgKnife = parent.loadImage("res/newObject/stoneKnife.png");
		imgSpear = parent.loadImage("res/newObject/stoneSpear.png");
		imgArrow = parent.loadImage("res/newObject/arrow.png");
		imgBow = parent.loadImage("res/newObject/bow.png");
		
		imgStick = parent.loadImage("res/newObject/woodenstick.png");
		imgPointyStick = parent.loadImage("res/newObject/pointyWoodenstick.png");
		
		imgLeafTentLogo = parent.loadImage("res/newObject/leafyTent.png");
		imgRope = parent.loadImage("res/newObject/rope.png");
		
		imgCrafting = parent.loadImage("res/GUI/crafting/craftTable.png");
		tab0 = parent.loadImage("res/GUI/crafting/tab0.png");
		tab1 = parent.loadImage("res/GUI/crafting/tab1.png");
		tab2 = parent.loadImage("res/GUI/crafting/tab2.png");
		tab3 = parent.loadImage("res/GUI/crafting/tab3.png");
		tab4 = parent.loadImage("res/GUI/crafting/tab4.png");
		tab5 = parent.loadImage("res/GUI/crafting/tab5.png");
		slot1 = parent.loadImage("res/GUI/crafting/slot1.png");
		slot2 = parent.loadImage("res/GUI/crafting/slot2.png");
		slot3 = parent.loadImage("res/GUI/crafting/slot3.png");
		
		//tab0
		stringU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeString.png");
		ropeU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeRope.png");
		stickU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeWoodstick.png");
		pointyStickU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipePointyWoodstick.png");
		
		stringS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeString.png");
		ropeS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeRope.png");
		stickS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeWoodstick.png");
		pointyStickS = parent.loadImage("res/GUI/crafting/selected/selectedRecipePointyWoodstick.png");
		
		//tab1
		axeU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeStoneaxe.png");
		knifeU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeStoneknife.png");
		
		axeS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeStoneaxe.png");
		knifeS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeStoneknife.png");
		
		//tab2
		arrowU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeArrow.png");
		bowU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeBow.png");
		spearU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeStonelance.png");
		
		arrowS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeArrow.png");
		bowS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeBow.png");
		spearS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeStonelance.png");
		
		//tab4
		
		fireU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeFirecamp.png");
		stickTentU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeDryTent.png");
		leafTentU = parent.loadImage("res/GUI/crafting/unselected/unselectedRecipeLeafyTent.png");
		
		fireS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeFireCamp.png");
		leafTentS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeLeafyTent.png");
		stickTentS = parent.loadImage("res/GUI/crafting/selected/selectedRecipeDryTent.png");

		mouse = parent.loadImage("res/GUI/mouse/stoneCursor.png");
		
	}
	
	public void update(){
		if(invMushroom < 0) invMushroom = 0;
	}
	
	public void mouseDisplay(PApplet p, PVector pos){
		p.image(mouse, pos.x, pos.y);
	}
	
	public void invDisplay(PApplet p, PVector pos, PVector screen){

		
		switch(mode){
			case 0:
				inventoryOpen = false;
				break;
			case 1:
				inventoryOpen = true;
				//display inventory
				//p.fill(255);
				//p.rectMode(PConstants.CENTER);
				//p.rect(pos.x + screen.x -200 , pos.y +screen.y -152, 320, 224);
				//p.noFill();
				
				//grid(pos, screen);
				
				p.image(inventorydisplay, pos.x + screen.x -359 , pos.y +screen.y -265);
				
				
				//display text inv
				//1
				if(invMushroom > 0){
					p.fill(255);
					p.image(imgmush, pos.x + screen.x -336 , pos.y +screen.y -246);
					p.text(invMushroom, pos.x + screen.x -320 , pos.y +screen.y -216);
				}
				//2
				if(invRedBerry > 0){
					p.fill(255);
					p.image(imgRedBerry, pos.x + screen.x -296 , pos.y +screen.y -246);
					p.text(invRedBerry, pos.x + screen.x -280 , pos.y +screen.y -216);
					
				}
				//3
				if(invGrass > 0){
					p.fill(255);
					p.image(imgGrass, pos.x + screen.x -256 , pos.y +screen.y -246);
					p.text(invGrass, pos.x + screen.x -240 , pos.y +screen.y -216);
				}
				//4
				if(invRock > 0){
					p.fill(255);
					p.image(imgRock, pos.x + screen.x -216 , pos.y +screen.y -246);
					p.text(invRock, pos.x + screen.x -200 , pos.y +screen.y -216);
				}
				//5
				if(invRope > 0){
					p.fill(255);
					p.image(imgRope, pos.x + screen.x -176 , pos.y +screen.y -246);
					p.text(invRope, pos.x + screen.x -160 , pos.y +screen.y -216);
				}
				//6
				if(invBranch > 0){
					p.fill(255);
					p.image(imgBranch, pos.x + screen.x -136 , pos.y +screen.y -246);
					p.text(invBranch, pos.x + screen.x -120 , pos.y +screen.y -216);
				}
				//7
				if(invSmallBranch > 0){
					p.fill(255);
					p.image(imgSmallBranch, pos.x + screen.x -96 , pos.y +screen.y -246);
					p.text(invSmallBranch, pos.x + screen.x -80 , pos.y +screen.y -216);
				}
				//8
				if(invFurr > 0){
					p.fill(255);
					p.image(imgFurr, pos.x + screen.x -336 , pos.y +screen.y -206);
					p.text(invFurr, pos.x + screen.x -320 , pos.y +screen.y -176);
				}
				//9
				if(invMeat > 0){
					p.fill(255);
					p.image(imgMeat, pos.x + screen.x -296 , pos.y +screen.y -206);
					p.text(invMeat, pos.x + screen.x -280 , pos.y +screen.y -176);
				}
				//10 logg
				if(invLog > 0){
					p.fill(255);
					p.image(imgLog, pos.x + screen.x -256 , pos.y +screen.y -206);
					p.text(invLog, pos.x + screen.x -240 , pos.y +screen.y -176);
				}
				
				//11
				if(invString > 0){
					p.fill(255);
					p.image(imgString, pos.x + screen.x -216 , pos.y +screen.y -206);
					p.text(invString, pos.x + screen.x -200 , pos.y +screen.y -176);
				}
				//12 stone axe
				if(invStoneAxe > 0){
					p.fill(255);
					p.image(imgAxe, pos.x + screen.x -176 , pos.y +screen.y -206);
					p.text(invStoneAxe, pos.x + screen.x -160 , pos.y +screen.y -176);
				}
				//13 fire unlit
				if(invFire > 0){
					p.fill(255);
					p.image(imgFireCamp, pos.x + screen.x -136 , pos.y +screen.y -206);
					p.text(invFire, pos.x + screen.x -120 , pos.y +screen.y -176);
				}
				//14 stone knife
				if(invStoneKnife > 0){
					p.fill(255);
					p.image(imgKnife, pos.x + screen.x -96 , pos.y +screen.y -206);
					p.text(invStoneKnife, pos.x + screen.x -80 , pos.y +screen.y -176);
				}
				//15 stone spear
				if(invStoneLance > 0){
					p.fill(255);
					p.image(imgSpear, pos.x + screen.x -336 , pos.y +screen.y -166);
					p.text(invStoneLance, pos.x + screen.x -320 , pos.y +screen.y -136);
				}
				//16 arrow
				if(invArrow > 0){
					p.fill(255);
					p.image(imgArrow, pos.x + screen.x -296 , pos.y +screen.y -166);
					p.text(invArrow, pos.x + screen.x -280 , pos.y +screen.y -136);
				}
				//17 bow
				if(invBow > 0){
					p.fill(255);
					p.image(imgBow, pos.x + screen.x -256 , pos.y +screen.y -166);
					p.text(invBow, pos.x + screen.x -240 , pos.y +screen.y -136);
				}
				//18 coocked meat
				if(invCookedMeat > 0){
					p.fill(255);
					p.image(imgCoockedMeat, pos.x + screen.x -216 , pos.y +screen.y -166);
					p.text(invCookedMeat, pos.x + screen.x -200 , pos.y +screen.y -136);
				}
				//19 stick
				if(invStick > 0){
					p.fill(255);
					p.image(imgStick, pos.x + screen.x -176 , pos.y +screen.y -166);
					p.text(invStick, pos.x + screen.x -160 , pos.y +screen.y -136);
				}
				//20 pointyStick
				if(invPointyStick > 0){
					p.fill(255);
					p.image(imgPointyStick, pos.x + screen.x -136 , pos.y +screen.y -166);
					p.text(invPointyStick, pos.x + screen.x -120 , pos.y +screen.y -136);
				}
				//21 tentlvl0
				if(invTent > 0){
					p.fill(255);
					p.image(imgTentLogo, pos.x + screen.x -96 , pos.y +screen.y -166);
					p.text(invTent, pos.x + screen.x -80 , pos.y +screen.y -136);
				}
				//22 leaf tent
				if(invLeafTent > 0){
					p.fill(255);
					p.image(imgLeafTentLogo, pos.x + screen.x -336 , pos.y +screen.y -126);
					p.text(invLeafTent, pos.x + screen.x -320 , pos.y +screen.y -96);
				}
				//23 stocklvl0
				if(invStock > 0){
					//p.fill(0);
					//p.image(imgStockLogo, pos.x + screen.x -296 , pos.y +screen.y -126);
					//p.text(invStock, pos.x + screen.x -266 , pos.y +screen.y -96);
				}
				//24 woodstocklvl0
				if(invWoodStock > 0){
					//p.fill(0);
					//p.image(imgWoodStock, pos.x + screen.x -256 , pos.y +screen.y -126);
					//p.text(invWoodStock, pos.x + screen.x -216 , pos.y +screen.y -96);
				}
				//25 leaf tent
				if(invLeafTent > 0){
					//p.fill(0);
					//p.image(imgLeafTentLogo, pos.x + screen.x -216 , pos.y +screen.y -126);
					//p.text(invLeafTent, pos.x + screen.x -186 , pos.y +screen.y -96);
				}
				
				break;
		}
		
		
		//racourcis
		switch(shortcut1){
			case 0:
				shortCut1 = false;
				break;
			case 1:
				shortCut1 = true;
				if(inventoryOpen = true){
					//p.strokeWeight(2);
					//p.rect(pos.x + screen.x -336, pos.y +screen.y -86, 32, 32);
					//p.strokeWeight(1);
				}
				break;
		}
		
		switch(shortcut2){
			case 0:
				shortCut2 = false;
				break;
			case 1:
				shortCut2 = true;
				if(inventoryOpen = true){
					//p.strokeWeight(2);
					//p.rect(pos.x + screen.x -296, pos.y +screen.y -86, 32, 32);
					//p.strokeWeight(1);
				}
				break;
		}
		
		switch(shortcut3){
			case 0:
				shortCut3 = false;
				break;
			case 1:
				shortCut3 = true;
				if(inventoryOpen = true){
					//p.strokeWeight(2);
					//p.rect(pos.x + screen.x -256, pos.y +screen.y -86, 32, 32);
					//p.strokeWeight(1);
				}
				break;
		}
		
	}
	
	
	
	public void invCrafting(PApplet p, PVector pos, PVector screen){
		
		
		switch(craftMode){
		case 0:
			craftingOpen = false;
			break;
		case 1: 
			craftingOpen = true;
			//display crafting
			
			p.image(imgCrafting, pos.x + screen.x -505 , pos.y +screen.y -497);
			
			switch(craftTab){
				case 0: 
					p.image(tab0, pos.x + screen.x -328 , pos.y +screen.y -496);
					p.image(stringU, pos.x + screen.x -304 , pos.y +screen.y -440);
					p.image(ropeU, pos.x + screen.x -230 , pos.y +screen.y -447);
					p.image(stickU, pos.x + screen.x -152 , pos.y +screen.y -445);
					p.image(pointyStickU, pos.x + screen.x -78 , pos.y +screen.y -445);
					
					break;
				case 1:
					p.image(tab1, pos.x + screen.x -275 , pos.y +screen.y -495);
					p.image(axeU, pos.x + screen.x -304 , pos.y +screen.y -447);
					p.image(knifeU, pos.x + screen.x -229 , pos.y +screen.y -444);
					
					break;
				case 2:
					p.image(tab2, pos.x + screen.x -222 , pos.y +screen.y -495);
					p.image(arrowU, pos.x + screen.x -301 , pos.y +screen.y -444);
					p.image(bowU, pos.x + screen.x -228 , pos.y +screen.y -445);
					p.image(spearU, pos.x + screen.x -153 , pos.y +screen.y -445);
					
					break;
				case 3:
					p.image(tab3, pos.x + screen.x -171 , pos.y +screen.y -497);
					
					
					break;
				case 4:
					p.image(tab4, pos.x + screen.x -115 , pos.y +screen.y -497);
					p.image(fireU, pos.x + screen.x -296 , pos.y +screen.y -444);
					p.image(leafTentU, pos.x + screen.x -305 , pos.y +screen.y -352);
					p.image(stickTentU, pos.x + screen.x -231 , pos.y +screen.y -352);
					
					
					
					break;
				case 5:
					p.image(tab5, pos.x + screen.x -62 , pos.y +screen.y -497);
					
					
					break;
			}
			
			switch(craftSlot){
				case 0:
					if(craftTab == 0){
						//selected
						p.image(stringS, pos.x + screen.x -310 , pos.y +screen.y -449);
						//reciep string
						p.image(slot1, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(imgSmallBranch, pos.x + screen.x -427 , pos.y +screen.y -428);
						p.fill(255,255,255);
						p.text(invSmallBranch + "/1", pos.x + screen.x -424 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgString, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					if(craftTab == 1){
						//selected
						p.image(axeS, pos.x + screen.x -310 , pos.y +screen.y -449);
						//reciep axe
						p.image(slot1, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(slot3, pos.x + screen.x -384 , pos.y +screen.y -428);
						p.image(imgStick, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(imgRock, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(imgString, pos.x + screen.x -385 , pos.y +screen.y -428);
						p.fill(255,255,255);
						p.text(invStick + "/1", pos.x + screen.x -467 , pos.y +screen.y -384);
						p.text(invRock + "/1", pos.x + screen.x -424 , pos.y +screen.y -384);
						p.text(invString + "/1", pos.x + screen.x -380 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgAxe, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					if(craftTab == 2){
						//selected
						p.image(arrowS, pos.x + screen.x -310 , pos.y +screen.y -449);
						//reciep arrow
						p.image(slot1, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(slot3, pos.x + screen.x -384 , pos.y +screen.y -428);
						p.image(imgStick, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(imgRock, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(imgString, pos.x + screen.x -385 , pos.y +screen.y -428);
						p.fill(255,255,255);
						p.text(invStick + "/1", pos.x + screen.x -467 , pos.y +screen.y -384);
						p.text(invRock + "/1", pos.x + screen.x -424 , pos.y +screen.y -384);
						p.text(invString + "/1", pos.x + screen.x -380 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgArrow, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					if(craftTab == 4){
						//selected
						p.image(fireS, pos.x + screen.x -309 , pos.y +screen.y -449);
						//reciep fire
						p.image(slot1, pos.x + screen.x -455 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -400 , pos.y +screen.y -428);
						p.image(imgBranch, pos.x + screen.x -455 , pos.y +screen.y -428);
						p.image(imgGrass, pos.x + screen.x -400 , pos.y +screen.y -428);
						p.fill(255,255,255);
						p.text(invBranch + "/10", pos.x + screen.x -450 , pos.y +screen.y -384);
						p.text(invGrass + "/5", pos.x + screen.x -395 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgFireCamp, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					break;
				case 1:
					if(craftTab == 0){
						//selected
						p.image(ropeS, pos.x + screen.x -236 , pos.y +screen.y -449);
						//reciep rope
						p.image(slot1, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(imgGrass, pos.x + screen.x -427 , pos.y +screen.y -427);
						p.fill(255,255,255);
						p.text(invGrass + "/10", pos.x + screen.x -424 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgRope, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					if(craftTab == 1){
						//selected
						p.image(knifeS, pos.x + screen.x -236 , pos.y +screen.y -449);
						//reciep knife
						p.image(slot1, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(slot3, pos.x + screen.x -384 , pos.y +screen.y -428);
						p.image(imgStick, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(imgRock, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(imgString, pos.x + screen.x -385 , pos.y +screen.y -428);
						p.fill(255,255,255);
						p.text(invStick + "/1", pos.x + screen.x -467 , pos.y +screen.y -384);
						p.text(invRock + "/1", pos.x + screen.x -424 , pos.y +screen.y -384);
						p.text(invString + "/1", pos.x + screen.x -380 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgKnife, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					if(craftTab == 2){
						//selected
						p.image(bowS, pos.x + screen.x -235 , pos.y +screen.y -449);
						//reciep bow
						p.image(slot1, pos.x + screen.x -455 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -400 , pos.y +screen.y -428);
						p.image(imgStick, pos.x + screen.x -455 , pos.y +screen.y -428);
						p.image(imgRope, pos.x + screen.x -400 , pos.y +screen.y -428);
						p.fill(255,255,255);
						p.text(invStick + "/1", pos.x + screen.x -450 , pos.y +screen.y -384);
						p.text(invRope + "/1", pos.x + screen.x -395 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgBow, pos.x + screen.x -426 , pos.y +screen.y -366);
					}					
					break;
				case 2:
					if(craftTab == 0){
						//selected
						p.image(stickS, pos.x + screen.x -157 , pos.y +screen.y -450);
						//reciep stick
						p.image(slot1, pos.x + screen.x -455 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -400 , pos.y +screen.y -428);
						p.image(imgBranch, pos.x + screen.x -455 , pos.y +screen.y -428);
						p.image(imgKnife, pos.x + screen.x -400 , pos.y +screen.y -427);
						p.fill(255,255,255);
						p.text(invBranch + "/1", pos.x + screen.x -450 , pos.y +screen.y -384);
						p.text(invStoneKnife + "/1", pos.x + screen.x -395 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgStick, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					if(craftTab == 2){
						//selected
						p.image(spearS, pos.x + screen.x -157 , pos.y +screen.y -450);
						//reciep spear
						p.image(slot1, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(slot3, pos.x + screen.x -384 , pos.y +screen.y -428);
						p.image(imgStick, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(imgRock, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(imgString, pos.x + screen.x -385 , pos.y +screen.y -428);
						p.fill(255,255,255);
						p.text(invStick + "/1", pos.x + screen.x -467 , pos.y +screen.y -384);
						p.text(invRock + "/1", pos.x + screen.x -424 , pos.y +screen.y -384);
						p.text(invString + "/1", pos.x + screen.x -380 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgSpear, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					break;
				case 3:
					if(craftTab == 0){
						//selected
						p.image(pointyStickS, pos.x + screen.x -84 , pos.y +screen.y -450);
						//reciep pointy stick
						p.image(slot1, pos.x + screen.x -455 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -400 , pos.y +screen.y -428);
						p.image(imgStick, pos.x + screen.x -455 , pos.y +screen.y -428);
						p.image(imgKnife, pos.x + screen.x -400 , pos.y +screen.y -427);
						p.fill(255,255,255);
						p.text(invStick + "/1", pos.x + screen.x -450 , pos.y +screen.y -384);
						p.text(invStoneKnife + "/1", pos.x + screen.x -395 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgPointyStick, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					break;
				case 4:
					if(craftTab == 4){
						//selected
						p.image(leafTentS, pos.x + screen.x -309 , pos.y +screen.y -361);
						//reciep green tent
						p.image(slot1, pos.x + screen.x -490 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -450 , pos.y +screen.y -428);
						p.image(slot3, pos.x + screen.x -411 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -370 , pos.y +screen.y -428);
						p.image(imgPointyStick, pos.x + screen.x -490 , pos.y +screen.y -428);
						p.image(imgBranch, pos.x + screen.x -450 , pos.y +screen.y -428);
						p.image(imgGrass, pos.x + screen.x -411 , pos.y +screen.y -428);
						p.image(imgRope, pos.x + screen.x -370 , pos.y +screen.y -428);
						p.fill(255,255,255);
						p.text(invPointyStick + "/4", pos.x + screen.x -485 , pos.y +screen.y -384);
						p.text(invBranch + "/4", pos.x + screen.x -445 , pos.y +screen.y -384);
						p.text(invGrass + "/20", pos.x + screen.x -406 , pos.y +screen.y -384);
						p.text(invRope + "/4", pos.x + screen.x -365 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgLeafTentLogo, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					break;
				case 5:
					if(craftTab == 4){
						//selected
						p.image(stickTentS, pos.x + screen.x -235 , pos.y +screen.y -362);
						//reciep stick tent
						p.image(slot1, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(slot2, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(slot3, pos.x + screen.x -384 , pos.y +screen.y -428);
						p.image(imgPointyStick, pos.x + screen.x -472 , pos.y +screen.y -428);
						p.image(imgStick, pos.x + screen.x -428 , pos.y +screen.y -428);
						p.image(imgRope, pos.x + screen.x -385 , pos.y +screen.y -428);
						p.fill(255,255,255);
						p.text(invPointyStick + "/4", pos.x + screen.x -467 , pos.y +screen.y -384);
						p.text(invStick + "/20", pos.x + screen.x -424 , pos.y +screen.y -384);
						p.text(invRope + "/4", pos.x + screen.x -380 , pos.y +screen.y -384);
						p.noFill();
						//result
						p.image(imgTentLogo, pos.x + screen.x -426 , pos.y +screen.y -366);
					}
					break;
			}
			break;
			
		}
		
	}
	
	
	
	//objectDragAxe
	public void objectDragAxe(PApplet p,PVector dragPos){
		PImage imgAxe = parent.loadImage("res/newObject/stoneaxe.png");
		p.image(imgAxe, dragPos.x, dragPos.y);
	}
	
	public void axeInHand(PApplet p, PVector pos){
		PImage imgAxe = parent.loadImage("res/newObject/stoneaxe.png");
		p.image(imgAxe, pos.x-16, pos.y-16);
	}
	
	//objectDragknife
	public void objectDragKnife(PApplet p,PVector dragPos){
		PImage imgDagger = parent.loadImage("res/newObject/stoneKnife.png");
		p.image(imgDagger, dragPos.x, dragPos.y);
	}
	
	public void knifeInHand(PApplet p, PVector pos){
		PImage imgDagger = parent.loadImage("res/newObject/stoneKnife.png");
		p.image(imgDagger, pos.x-16, pos.y-16);
	}
	
	//objectDragspear
	public void objectDragSpear(PApplet p,PVector dragPos){
		PImage imgSpear = parent.loadImage("res/icons/Spear.png");
		p.image(imgSpear, dragPos.x, dragPos.y);
	}
	
	public void spearInHand(PApplet p, PVector pos){
		PImage imgSpear = parent.loadImage("res/icons/Spear.png");
		p.image(imgSpear, pos.x-16, pos.y-16);
	}
	
	
	//inventory
	//1
	public void addMushroom(){
		invMushroom +=1;
	}
	
	public void removeMushroom(){
		invMushroom -=1;
	}
	
	public void eatMushroom(){
		if(mousseLeft && mouses[0] == true){
			invMushroom -=1;
			mousseLeft = false;
		}
		if(mouses[0] == false){
			mousseLeft = true;
		}
	}
	public void dropMushroom(){
		if(mousseRight && mouses[1] == true){
			invMushroom -=1;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
		}
	}
	
	public float getInvMush(){
		return invMushroom;
	}
	
	//2
	public void addRedBerry(){
		invRedBerry +=1;
	}
	
	public void eatRedBerry(){
		if(mousseLeft && mouses[0] == true){
			invRedBerry -=1;
			mousseLeft = false;
		}
		if(mouses[0] == false){
			mousseLeft = true;
		}
	}
	
	//dropberry test//
	public void dropRedBerry(){
		if(mousseRight && mouses[1] == true){
			invRedBerry -=1;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
		}
	}
	
	//3 grass
	public void addGrass(){
		invGrass +=1;
	}
	
	public void dropGrass(){
		if(mousseRight && mouses[1] == true){
			invGrass -=1;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
		}
	}
	
	//4 rock
	public void addRock(){
		invRock += 1;
	}
	
	public void dropRock(){
		if(mousseRight && mouses[1] == true){
			invRock -=1;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
		}
	}
	
	//5 yellowberry
	public void addYellowBerry(){
		invJellowBerry +=1;
	}
	
	public void eatYellowBerry(){
		if(mousseLeft && mouses[0] == true){
			invJellowBerry -=1;
			mousseLeft = false;
		}
		if(mouses[0] == false){
			mousseLeft = true;
		}
	}
	
	//dropberry test//
	public void dropYellowBerry(){
		if(mousseRight && mouses[1] == true){
			invJellowBerry -=1;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
		}
	}
	//6
	public void addBranch(){
		invBranch += 1;
	}
	public void dropBranch(){
		if(mousseRight && mouses[1] == true){
			invBranch -=1;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
		}
	}
	//7
	public void addSmallBranch(){
		invSmallBranch += 1;
	}
	public void dropSmallBranch(){
		if(mousseRight && mouses[1] == true){
			invSmallBranch -=1;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
		}
	}
	//8
	public void addFurr(){
		invFurr += 1;
	}
	public void dropFurr(){
		if(mousseRight && mouses[1] == true){
			invFurr -=1;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
		}
	}
	//9
	public void addMeat(){
		invMeat +=1;
	}
	
	public void eatMeat(){
		if(mousseLeft && mouses[0] == true){
			invMeat -=1;
			mousseLeft = false;
		}
		if(mouses[0] == false){
			mousseLeft = true;
		}
	}
	public void dropMeat(){
		if(mousseRight && mouses[1] == true){
			invMeat -=1;
			mousseRight = false;
		}
		if(mouses[1] == false){
			mousseRight = true;
		}
	}
	//10
	public void addLog(){
		invLog += 1;
	}
	//11
	
	
	
	//left mouse
	public void checkActionLM(){
		if(actionLM) leftClickTime +=5;
		if(actionLM == false) resetLeftClickTime();
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
	
	public void blockLMCount(){
		if(leftClickTime > 10){
			actionLM = false;
		}
	}
	
	//right mouse
	public void checkActionRM(){
		if(actionRM) rightClickTime+=5;
		if(actionRM == false) resetRightClickTime();
	}
	public boolean rightClickTime(){
		if(rightClickTime > 10){
			return true;
		}
		else{
			return false;
		}
	}
	public void resetRightClickTime(){
		rightClickTime = 0;
	}
	
	public void blockRMCount(){
		if(rightClickTime > 10){
			actionRM = false;
		}
	}
	//////////////////


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
	
	public void cutTree(){
		if(mouses[0] == true){
			cutTree = true;
		}
		if(mouses[0] == false){
			cutTree = false;
		}
	}
	
	public void cutTree2(){
		if(mousseLeft && mouses[0] == true){
			mousseLeft = false;
			cutTree = true;
		}
		if(mouses[0] == false){
			mousseLeft = true;
			cutTree = false;
		}
	}
	
	public void spearAttack(){
		if(mouses[0] == true){
			spearAttack = true;
		}
		if(mouses[0] == false){
			spearAttack = false;
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
	
	public void pressI(){ //fct !!!!
		if(okayI && keys[0] == true ){
			mode = (mode+1)%2;
			okayI = false;
		}
		if(keys[0] == false ){
			okayI = true;
		}
	}
	
	public void pressE(){ //fct 
		if(okayE && keys[1] == true ){
			okayE = false;
			actionE = true;
		}
		if(keys[1] == false ){
			okayE = true;
			actionE = false;
		}
	}
	
	//craft
	public void pressC(){ //fct !!!!
		if(okayC && keys[2] == true ){
			craftMode = (craftMode+1)%2;
			okayC = false;
		}
		if(keys[2] == false ){
			okayC = true;
		}
	}
	
	//dragDrop
	public void dragLeft(){
		if(mouses[0] == true){
			dragLeft = true;
		}
		if(mouses[0] == false){
			dragLeft = false;
			inHand1 = false;
			inHand2 = false;
			inHand3 = false;
			distInvSlot12 = false;
			distInvSlot14 = false;
			distInvSlot15 = false;
			distHandSlot1 = false;
			distHandSlot2 = false;
			distHandSlot3 = false;
		}
	}
	
	//racourcis 1234567890
	public void press1(){ 
		if(okay1 && keys[3] == true ){
			shortcut1 = (shortcut1+1)%2;
			okay1 = false;
		}
		if(keys[3] == false ){
			okay1 = true;
		}
	}
	
	public void press2(){ 
		if(okay2 && keys[4] == true ){
			shortcut2 = (shortcut2+1)%2;
			okay2 = false;
		}
		if(keys[4] == false ){
			okay2 = true;
		}
	}
	
	public void press3(){ 
		if(okay3 && keys[5] == true ){
			shortcut3 = (shortcut3+1)%2;
			parent.save("test.png");
			okay3 = false;
		}
		if(keys[5] == false ){
			okay3 = true;
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
		if (keyChar=='i') keys[0]=true;
		if (keyChar=='e') keys[1]=true;
		if (keyChar=='c') keys[2]=true;
		if (keyChar=='&') keys[3]=true;
		if (keyChar=='é') keys[4]=true;
		if (keyChar=='"') keys[5]=true;
		if (keyChar=='w') keys[6]=true;
		if (keyChar=='x') keys[7]=true;
	}
	
	protected void keyReleasedProcess(int keyCode, char keyChar, boolean shiftDown, boolean ctrlDown){
		if (keyChar=='i') keys[0]=false;
		if (keyChar=='e') keys[1]=false;
		if (keyChar=='c') keys[2]=false;
		if (keyChar=='&') keys[3]=false;
		if (keyChar=='é') keys[4]=false;
		if (keyChar=='"') keys[5]=false;
		if (keyChar=='w') keys[6]=false;
		if (keyChar=='x') keys[7]=false;
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
