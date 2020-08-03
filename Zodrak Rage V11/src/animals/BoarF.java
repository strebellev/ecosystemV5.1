package animals;

import java.util.ArrayList;

import mechanisme.DNAblaireau;
import mechanisme.DNAboar;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class BoarF {
	PApplet parent;
	ArrayList<PVector> boarf;
	
	public PVector position;
	
	DNAboar dnaboar;
	float xoff;
	float yoff;
	
	PVector velocity;
	PVector acceleration;
	
	float wandertheta;
	float maxforce;
	
	///limite de terrain
	float d = 50;
	
	////////////variables genetiques
	float water;
	float maxWater;
	float food;
	float maxFood;
	public float health;
	float r; ///la taille
	public float maxspeed;
	float lifeTime;
	float reproduceTime;
	float maxLifeTime;
	float speed;
	float fieldOfView;
	
	float eating =20;
	
	float weight;
	float foodPerDay;
	float maxFoodPerDay;

	public float meat;
	public float furr;
	public float bone;
	
	float gestation = 600;
	
	boolean dead;

	//////test anim/////
	
	int currentFrame = 0;
	
	int animUnumFrame = 8;
	int animURnumFrame = 8;
	int animRnumFrame = 8;
	int animDRnumFrame = 8;
	int animDnumFrame = 8;
	int animDLnumFrame = 8;
	int animLnumFrame = 8;
	int animULnumFrame = 8;
	
	int animDead = 1;
	
	PImage[] animDe = new PImage[animDead];
	
	PImage[] animU = new PImage[animUnumFrame];
	PImage[] animUR = new PImage[animUnumFrame];
	PImage[] animR = new PImage[animRnumFrame];
	PImage[] animDR = new PImage[animUnumFrame];
	PImage[] animD = new PImage[animDnumFrame];
	PImage[] animDL = new PImage[animUnumFrame];
	PImage[] animL = new PImage[animLnumFrame];
	PImage[] animUL = new PImage[animUnumFrame];
	

	
	int previousDisplayTime;
	int deltaTime;
	////////////////////

	@SuppressWarnings("deprecation")
	public BoarF(PVector l, DNAboar dnaboar_, PApplet p){
		parent = p;
		position = l.get();
		xoff = p.random(3200);
		yoff = p.random(3200);
		
		dnaboar = dnaboar_;
		
		///////A MODIF////////////
		
		health = PApplet.map(dnaboar.genes[0], 0, 1, 50, 250);
		r = PApplet.map(dnaboar.genes[0], 0, 1, 4, 8);
		//maxspeed = PApplet.map(dnaboar.genes[0], 0, 1, 1, 2);
		lifeTime = PApplet.map(dnaboar.genes[0], 0, 1, 500, 600);
		maxLifeTime = PApplet.map(dnaboar.genes[0], 0, 1, 500, 600);
		water = PApplet.map(dnaboar.genes[1], 0, 1, 200, 400);
		maxWater = PApplet.map(dnaboar.genes[1], 0, 1, 200, 400);
		food = PApplet.map(dnaboar.genes[1], 0, 1, 200, 600);
		maxFood = PApplet.map(dnaboar.genes[1], 0, 1, 200, 600);
		fieldOfView = PApplet.map(dnaboar.genes[2], 0, 1, 400, 800);
		
		speed = PApplet.map(dnaboar.genes[0], 0, 1, 2, 3);
		
		///for food 1000 = 1kg
		weight = PApplet.map(dnaboar.genes[1], 0, 1, 60000, 80000);
		foodPerDay = 0;
		maxFoodPerDay = PApplet.map(dnaboar.genes[1], 0, 1, 1000, 2000);

		//carac pour corpse
		meat = weight/100;
		furr = 10;
		bone = 10;

		
		acceleration = new PVector(0,0);
		velocity = new PVector(0,0);
		maxforce = (float) 0.1;

		//////test anim/////
		animDe[0] = p.loadImage("res/newAnimal/boar/Boar_dead.png");
		
		animU[0] = p.loadImage("res/newAnimal/boar/BoarU0.png");
		animU[1] = p.loadImage("res/newAnimal/boar/BoarU1.png");
		animU[2] = p.loadImage("res/newAnimal/boar/BoarU2.png");
		animU[3] = p.loadImage("res/newAnimal/boar/BoarU3.png");
		animU[4] = p.loadImage("res/newAnimal/boar/BoarU4.png");
		animU[5] = p.loadImage("res/newAnimal/boar/BoarU5.png");
		animU[6] = p.loadImage("res/newAnimal/boar/BoarU6.png");
		animU[7] = p.loadImage("res/newAnimal/boar/BoarU7.png");
		
		animUR[0] = p.loadImage("res/newAnimal/boar/BoarUR0.png");
		animUR[1] = p.loadImage("res/newAnimal/boar/BoarUR1.png");
		animUR[2] = p.loadImage("res/newAnimal/boar/BoarUR2.png");
		animUR[3] = p.loadImage("res/newAnimal/boar/BoarUR3.png");
		animUR[4] = p.loadImage("res/newAnimal/boar/BoarUR4.png");
		animUR[5] = p.loadImage("res/newAnimal/boar/BoarUR5.png");
		animUR[6] = p.loadImage("res/newAnimal/boar/BoarUR6.png");
		animUR[7] = p.loadImage("res/newAnimal/boar/BoarUR7.png");
		
		animR[0] = p.loadImage("res/newAnimal/boar/BoarR0.png");
		animR[1] = p.loadImage("res/newAnimal/boar/BoarR1.png");
		animR[2] = p.loadImage("res/newAnimal/boar/BoarR2.png");
		animR[3] = p.loadImage("res/newAnimal/boar/BoarR3.png");
		animR[4] = p.loadImage("res/newAnimal/boar/BoarR4.png");
		animR[5] = p.loadImage("res/newAnimal/boar/BoarR5.png");
		animR[6] = p.loadImage("res/newAnimal/boar/BoarR6.png");
		animR[7] = p.loadImage("res/newAnimal/boar/BoarR7.png");
		
		animDR[0] = p.loadImage("res/newAnimal/boar/BoarDR0.png");
		animDR[1] = p.loadImage("res/newAnimal/boar/BoarDR1.png");
		animDR[2] = p.loadImage("res/newAnimal/boar/BoarDR2.png");
		animDR[3] = p.loadImage("res/newAnimal/boar/BoarDR3.png");
		animDR[4] = p.loadImage("res/newAnimal/boar/BoarDR4.png");
		animDR[5] = p.loadImage("res/newAnimal/boar/BoarDR5.png");
		animDR[6] = p.loadImage("res/newAnimal/boar/BoarDR6.png");
		animDR[7] = p.loadImage("res/newAnimal/boar/BoarDR7.png");
		
		animD[0] = p.loadImage("res/newAnimal/boar/BoarD0.png");
		animD[1] = p.loadImage("res/newAnimal/boar/BoarD1.png");
		animD[2] = p.loadImage("res/newAnimal/boar/BoarD2.png");
		animD[3] = p.loadImage("res/newAnimal/boar/BoarD3.png");
		animD[4] = p.loadImage("res/newAnimal/boar/BoarD4.png");
		animD[5] = p.loadImage("res/newAnimal/boar/BoarD5.png");
		animD[6] = p.loadImage("res/newAnimal/boar/BoarD6.png");
		animD[7] = p.loadImage("res/newAnimal/boar/BoarD7.png");
		
		animDL[0] = p.loadImage("res/newAnimal/boar/BoarDL0.png");
		animDL[1] = p.loadImage("res/newAnimal/boar/BoarDL1.png");
		animDL[2] = p.loadImage("res/newAnimal/boar/BoarDL2.png");
		animDL[3] = p.loadImage("res/newAnimal/boar/BoarDL3.png");
		animDL[4] = p.loadImage("res/newAnimal/boar/BoarDL4.png");
		animDL[5] = p.loadImage("res/newAnimal/boar/BoarDL5.png");
		animDL[6] = p.loadImage("res/newAnimal/boar/BoarDL6.png");
		animDL[7] = p.loadImage("res/newAnimal/boar/BoarDL7.png");
		
		animL[0] = p.loadImage("res/newAnimal/boar/BoarL0.png");
		animL[1] = p.loadImage("res/newAnimal/boar/BoarL1.png");
		animL[2] = p.loadImage("res/newAnimal/boar/BoarL2.png");
		animL[3] = p.loadImage("res/newAnimal/boar/BoarL3.png");
		animL[4] = p.loadImage("res/newAnimal/boar/BoarL4.png");
		animL[5] = p.loadImage("res/newAnimal/boar/BoarL5.png");
		animL[6] = p.loadImage("res/newAnimal/boar/BoarL6.png");
		animL[7] = p.loadImage("res/newAnimal/boar/BoarL7.png");
		
		animUL[0] = p.loadImage("res/newAnimal/boar/BoarUL0.png");
		animUL[1] = p.loadImage("res/newAnimal/boar/BoarUL1.png");
		animUL[2] = p.loadImage("res/newAnimal/boar/BoarUL2.png");
		animUL[3] = p.loadImage("res/newAnimal/boar/BoarUL3.png");
		animUL[4] = p.loadImage("res/newAnimal/boar/BoarUL4.png");
		animUL[5] = p.loadImage("res/newAnimal/boar/BoarUL5.png");
		animUL[6] = p.loadImage("res/newAnimal/boar/BoarUL6.png");
		animUL[7] = p.loadImage("res/newAnimal/boar/BoarUL7.png");
		

			
		deltaTime = 120; // animation speed -=fast +=slow
		previousDisplayTime = 0;
			
		////////////////////

	}
	
	public void mvtUpdate(){
		position.add(velocity);
		velocity.add(acceleration);
		velocity.limit(maxspeed);
		acceleration.mult(0);
		acceleration.limit(maxspeed);
	}

	void update(){
		water -= 0.005;
		if(water < 0){
			water = 0;
		}
		if(water > maxWater){
			water = maxWater;
		}
		food -= 0.1;
		if(food < 0){
			food = 0;
		}
		if(food > maxFood){
			food = maxFood;
		}
		if(health < 0) health = 0;
		if(health > 250) health = 250;
		health -= 0.01;
		
		if(gestationTime() == false ){
			reproduceTime += 0.1;
		}
		
		gestation += 0.1;
		if(gestation > 500) gestation = 500;
		
		eating += 0.1;
		if(eating > 20) eating = 20;
		
		lifeTime -= 0.01;
		if(lifeTime < 0) lifeTime = 0; 
		
		if(health < 0){
			speed = 0; 
		}
		
		////plus ils veillissent plus il ralentissent
		maxspeed = speed * lifeTime/maxLifeTime;
		
		
		
		if(foodPerDay > maxFoodPerDay) foodPerDay = maxFoodPerDay;
	}

	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void wander(PApplet p){
		
		float wanderR = 50;  // Radius for our "wander circle"
		float wanderD = 80;  // Distance for our "wander circle"
		float change = (float) 1.03;
		wandertheta += p.random(-change, change);  // Randomly change wander theta
		
		// Now we have to calculate the new position to steer towards on the wander circle
		PVector circlepos = velocity.get();
		circlepos.normalize();
		circlepos.mult(wanderD);
		circlepos.add(position);  // Make it relative to boid's position
		
		float h = velocity.heading2D();
		
		PVector circleOffSet = new PVector(wanderR*p.cos(wandertheta+h), wanderR*p.sin(wandertheta+h));
		PVector target = PVector.add(circlepos, circleOffSet);
		seek(target);
		
	}

	void applyForce(PVector force){
		acceleration.add(force);
	}
	
	void seek(PVector target){
		PVector desired = PVector.sub(target, position);
		desired.normalize();
		desired.mult(maxspeed);
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}

	public void boundaries(){
		PVector desired = null;
		
		if(position.x < d){
			desired = new PVector(maxspeed,velocity.y);
		}
		else if(position.x > 3800 - d){
			desired = new PVector(-maxspeed, velocity.y);
		}
		
		if(position.y < d){
			desired = new PVector(velocity.x, maxspeed);
		}
		else if(position.y > 3800 -d){
			desired = new PVector(velocity.x, -maxspeed);
		}
		
		if(desired != null){
			desired.normalize();
			desired.mult(maxspeed);
			PVector steer = PVector.sub(desired, velocity);
			steer.limit(maxforce);
			applyForce(steer);
		}
	}

	public boolean isTooClose(PVector target){
		return PApplet.dist(position.x, position.y, target.x, target.y) < 10;
	}
	
	public void goAway(PVector target){
		PVector desired = new PVector(position.x - target.x, position.y - target.y);
		desired.normalize();
		desired.mult(maxspeed);
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}

	public boolean isInDanger(PVector target){
		return PApplet.dist(position.x, position.y, target.x, target.y) < 150;
	}
	
	public void runaway(PVector target){
		PVector desired = new PVector(position.x - target.x, position.y - target.y);
		desired.normalize();
		desired.mult(maxspeed);
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}

	public void run(PApplet p){
		update();
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	public void display(PApplet p){
		/*
		float theta = velocity.heading2D() + p.radians(90);
		p.fill(91,175,8);
		p.stroke(255,0,0, lifeTime);
		p.strokeWeight(1);
		p.pushMatrix();
		p.translate(position.x, position.y);
		p.rotate(theta);
		p.beginShape(p.TRIANGLES);
		p.vertex(0, -r*2);
		p.vertex(-r, r*2);
		p.vertex(r, r*2);
		p.endShape(PConstants.CLOSE);
		p.popMatrix();
		p.ellipse(position.x,position.y,r*2,r*2);
		*/
		
		p.fill(0);
		//p.text("reproduceTime " + reproduceTime, position.x+10, position.y+10);
		//p.text("food " + food, position.x+10,position.y+10);
		//p.text("eating " + eating, position.x+10,position.y+20);
		//p.text("lifetime " + lifeTime, position.x+10,position.y+30);
		//p.text("Maxlifetime " + maxLifeTime, position.x+10,position.y+40);
		//p.text("reproduct time " + reproduceTime, position.x+10,position.y+40);
		//p.text("water " + water, position.x+10,position.y+60);
		//p.text("health " + health , position.x +10, position.y +20);
		p.noFill();
		
		p.fill(0);
		//if(health < 0) p.text("DEAD", position.x+10,position.y+10);
		p.noFill();
		
		
		/////test sprite fct parfait////
		
		int dir = p.round(8 * (velocity.heading2D() + PApplet.radians(90)) /  PApplet.TWO_PI + 8) % 8;
	    switch(dir) {
	    case 0:
	    	//p.text("up",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	
	    	if(dead == false)p.image(animU[currentFrame],position.x-32,position.y-32);
	    	if(dead == true)p.image(animDe[0],position.x-32,position.y-32);
	    	break;
	    case 1:
	    	//p.text("right",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	
	    	if(dead == false)p.image(animUR[currentFrame],position.x-32,position.y-32);
	    	if(dead == true)p.image(animDe[0],position.x-32,position.y-32);

	    	break;
	    case 2:
	    	//p.text("down",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	
	    	if(dead == false)p.image(animR[currentFrame],position.x-32,position.y-32);
	    	if(dead == true)p.image(animDe[0],position.x-32,position.y-32);

	    	break;
	    case 3:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	
	    	if(dead == false)p.image(animDR[currentFrame],position.x-32,position.y-32);
	    	if(dead == true)p.image(animDe[0],position.x-32,position.y-32);

	    	break;
	    case 4:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	
	    	if(dead == false)p.image(animD[currentFrame],position.x-32,position.y-32);
	    	if(dead == true)p.image(animDe[0],position.x-32,position.y-32);

	    	break;	
	    case 5:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	
	    	if(dead == false)p.image(animDL[currentFrame],position.x-32,position.y-32);
	    	if(dead == true)p.image(animDe[0],position.x-32,position.y-32);

	    	break;	
	    case 6:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	
	    	if(dead == false)p.image(animL[currentFrame],position.x-32,position.y-32);
	    	if(dead == true)p.image(animDe[0],position.x-32,position.y-32);

	    	break;
	    case 7:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 7) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	
	    	if(dead == false)p.image(animUL[currentFrame],position.x-32,position.y-32);
	    	if(dead == true)p.image(animDe[0],position.x-32,position.y-32);

	    	break;	
	    }
		////////////////////
		
	}

	public void findFood(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 10){
			float m = PApplet.map(d, 0, 10, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	public void findWater(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 10){
			float m = PApplet.map(d, 0, 10, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}

	
	public void findPray(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 10){
			float m = PApplet.map(d, 0, 10, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}


	public void findFemale(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 100){
			float m = PApplet.map(d, 0, 10, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}

	public void goToNest(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 100){
			float m = PApplet.map(d, 0, 10, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	public void stayInPack(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 100){
			float m = PApplet.map(d, 0, 10, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}


	public DNAboar getDNAboar(){
		return dnaboar;
	}
	
	public float getR(){
		return r;
	}

	public ArrayList<PVector> getBoarF(){
		return boarf;
	}

	public boolean dead(){
		if(health <= 0.0 || lifeTime <= 0.0){
			dead = true;
			return true;
		}
		else {
			dead = false;
			return false;
		}
	}
	
	public boolean soif(){
		if(water < 50){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void drinkWater(){
		water += 200;
	}

	/////new food model/////
	public float getWeight(){
		return weight;
	}

	public boolean wellFed(){
		if(foodPerDay >= maxFoodPerDay) return true;
		else return false;
	}
	
	public void resetWellFed(){
		foodPerDay = 0;
	}
	
	public void eat(float food){
		foodPerDay += food;
	}
	
	public boolean NstarvingLvl1(){
		if(food < maxFood){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean NstarvingLvl2(){
		if(food < maxFood/2){
			return true;
		}
		else{
			return false;
		}
	}
	////////////////////////

	public float getfieldOfView(){
		return fieldOfView;
	}

	
	public boolean reproduceTime(){
		if(reproduceTime > 20){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void resetReproduce(){
		reproduceTime = 0;
	}
	
	public boolean eatingTime(){
		if(eating < 10) return true;
		else return false;
	}
	
	public void resetEating(){
		eating = 0;
	}
	
	public void gettingOld(){
		float randomAge = parent.random(20, 50);
		lifeTime -= randomAge;
	}

	public boolean pup(){
		float x = maxLifeTime/5;
		if(lifeTime > maxLifeTime-x){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean young(){
		float x = maxLifeTime/5;
		float y = maxLifeTime/6;
		if(lifeTime > maxLifeTime-x && lifeTime < maxLifeTime-y){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean old(){
		float x = maxLifeTime/5;
		if(lifeTime < x){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean gestationTime(){
		if(gestation < 400) return true;
		else return false;
	}
	
	public boolean gestationReady(){
		if(gestation > 100 && gestation < 400) return true;
		else return false;
	}
	
	public void resetGestation(){
		gestation = 0;
	}
	
	public void gestationFinish(){
		gestation = 500;
	}


	
}
