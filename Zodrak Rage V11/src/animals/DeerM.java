package animals;

import java.util.ArrayList;

import mechanisme.DNAdeer;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class DeerM {
	PApplet parent;
	ArrayList<PVector> deerm;
	
	public PVector position;
	
	DNAdeer dnadeer;
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
	
	boolean dead;

	//////test anim/////
	int animUnumFrame = 8;
	int animURnumFrame = 8;
	int animRnumFrame = 8;
	int animDRnumFrame = 8;
	int animDnumFrame = 8;
	int animDLnumFrame = 8;
	int animLnumFrame = 8;
	int animULnumFrame = 8;
	
	
	int currentFrame = 0;
	
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
	public DeerM(PVector l, DNAdeer dnadeer_, PApplet p){
		parent = p;
		position = l.get();
		xoff = p.random(3200);
		yoff = p.random(3200);

		dnadeer = dnadeer_;
		
		///////A MODIF////////////
		
		health = PApplet.map(dnadeer.genes[0], 0, 1, 50, 250);
		r = PApplet.map(dnadeer.genes[0], 0, 1, 4, 8);
		//maxspeed = PApplet.map(dnabear.genes[0], 0, 1, 1, 2);
		lifeTime = PApplet.map(dnadeer.genes[0], 0, 1, 500, 600);
		maxLifeTime = PApplet.map(dnadeer.genes[0], 0, 1, 500, 600);
		water = PApplet.map(dnadeer.genes[1], 0, 1, 200, 400);
		maxWater = PApplet.map(dnadeer.genes[1], 0, 1, 200, 400);
		food = PApplet.map(dnadeer.genes[1], 0, 1, 200, 600);
		maxFood = PApplet.map(dnadeer.genes[1], 0, 1, 200, 600);
		fieldOfView = PApplet.map(dnadeer.genes[2], 0, 1, 400, 800);
		
		speed = PApplet.map(dnadeer.genes[0], 0, 1, 2, 3);
		
		///for food 1000 = 1kg
		weight = PApplet.map(dnadeer.genes[1], 0, 1, 80000, 600000);
		foodPerDay = 0;
		maxFoodPerDay = PApplet.map(dnadeer.genes[1], 0, 1, 6000, 8000);
		
		//carac pour corpse
		meat = weight/100;
		furr = 10;
		bone = 10;
		
		acceleration = new PVector(0,0);
		velocity = new PVector(0,0);
		maxforce = (float) 0.1;

		//////test anim/////
		animDe[0] = p.loadImage("res/newAnimal/deer/Deer_dead.png");
		
		animU[0] = p.loadImage("res/newAnimal/deer/DeerU0.png");
		animU[1] = p.loadImage("res/newAnimal/deer/DeerU1.png");
		animU[2] = p.loadImage("res/newAnimal/deer/DeerU2.png");
		animU[3] = p.loadImage("res/newAnimal/deer/DeerU3.png");
		animU[4] = p.loadImage("res/newAnimal/deer/DeerU4.png");
		animU[5] = p.loadImage("res/newAnimal/deer/DeerU5.png");
		animU[6] = p.loadImage("res/newAnimal/deer/DeerU6.png");
		animU[7] = p.loadImage("res/newAnimal/deer/DeerU7.png");
		
		animUR[0] = p.loadImage("res/newAnimal/deer/DeerUR0.png");
		animUR[1] = p.loadImage("res/newAnimal/deer/DeerUR1.png");
		animUR[2] = p.loadImage("res/newAnimal/deer/DeerUR2.png");
		animUR[3] = p.loadImage("res/newAnimal/deer/DeerUR3.png");
		animUR[4] = p.loadImage("res/newAnimal/deer/DeerUR4.png");
		animUR[5] = p.loadImage("res/newAnimal/deer/DeerUR5.png");
		animUR[6] = p.loadImage("res/newAnimal/deer/DeerUR6.png");
		animUR[7] = p.loadImage("res/newAnimal/deer/DeerUR7.png");
		
		animR[0] = p.loadImage("res/newAnimal/deer/DeerR0.png");
		animR[1] = p.loadImage("res/newAnimal/deer/DeerR1.png");
		animR[2] = p.loadImage("res/newAnimal/deer/DeerR2.png");
		animR[3] = p.loadImage("res/newAnimal/deer/DeerR3.png");
		animR[4] = p.loadImage("res/newAnimal/deer/DeerR4.png");
		animR[5] = p.loadImage("res/newAnimal/deer/DeerR5.png");
		animR[6] = p.loadImage("res/newAnimal/deer/DeerR6.png");
		animR[7] = p.loadImage("res/newAnimal/deer/DeerR7.png");
		
		animDR[0] = p.loadImage("res/newAnimal/deer/DeerDR0.png");
		animDR[1] = p.loadImage("res/newAnimal/deer/DeerDR1.png");
		animDR[2] = p.loadImage("res/newAnimal/deer/DeerDR2.png");
		animDR[3] = p.loadImage("res/newAnimal/deer/DeerDR3.png");
		animDR[4] = p.loadImage("res/newAnimal/deer/DeerDR4.png");
		animDR[5] = p.loadImage("res/newAnimal/deer/DeerDR5.png");
		animDR[6] = p.loadImage("res/newAnimal/deer/DeerDR6.png");
		animDR[7] = p.loadImage("res/newAnimal/deer/DeerDR7.png");
		
		animD[0] = p.loadImage("res/newAnimal/deer/DeerD0.png");
		animD[1] = p.loadImage("res/newAnimal/deer/DeerD1.png");
		animD[2] = p.loadImage("res/newAnimal/deer/DeerD2.png");
		animD[3] = p.loadImage("res/newAnimal/deer/DeerD3.png");
		animD[4] = p.loadImage("res/newAnimal/deer/DeerD4.png");
		animD[5] = p.loadImage("res/newAnimal/deer/DeerD5.png");
		animD[6] = p.loadImage("res/newAnimal/deer/DeerD6.png");
		animD[7] = p.loadImage("res/newAnimal/deer/DeerD7.png");
		
		animDL[0] = p.loadImage("res/newAnimal/deer/DeerDL0.png");
		animDL[1] = p.loadImage("res/newAnimal/deer/DeerDL1.png");
		animDL[2] = p.loadImage("res/newAnimal/deer/DeerDL2.png");
		animDL[3] = p.loadImage("res/newAnimal/deer/DeerDL3.png");
		animDL[4] = p.loadImage("res/newAnimal/deer/DeerDL4.png");
		animDL[5] = p.loadImage("res/newAnimal/deer/DeerDL5.png");
		animDL[6] = p.loadImage("res/newAnimal/deer/DeerDL6.png");
		animDL[7] = p.loadImage("res/newAnimal/deer/DeerDL7.png");
		
		animL[0] = p.loadImage("res/newAnimal/deer/DeerL0.png");
		animL[1] = p.loadImage("res/newAnimal/deer/DeerL1.png");
		animL[2] = p.loadImage("res/newAnimal/deer/DeerL2.png");
		animL[3] = p.loadImage("res/newAnimal/deer/DeerL3.png");
		animL[4] = p.loadImage("res/newAnimal/deer/DeerL4.png");
		animL[5] = p.loadImage("res/newAnimal/deer/DeerL5.png");
		animL[6] = p.loadImage("res/newAnimal/deer/DeerL6.png");
		animL[7] = p.loadImage("res/newAnimal/deer/DeerL7.png");
		
		animUL[0] = p.loadImage("res/newAnimal/deer/DeerUL0.png");
		animUL[1] = p.loadImage("res/newAnimal/deer/DeerUL1.png");
		animUL[2] = p.loadImage("res/newAnimal/deer/DeerUL2.png");
		animUL[3] = p.loadImage("res/newAnimal/deer/DeerUL3.png");
		animUL[4] = p.loadImage("res/newAnimal/deer/DeerUL4.png");
		animUL[5] = p.loadImage("res/newAnimal/deer/DeerUL5.png");
		animUL[6] = p.loadImage("res/newAnimal/deer/DeerUL6.png");
		animUL[7] = p.loadImage("res/newAnimal/deer/DeerUL7.png");
		
			
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
		water -= 0.05;
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
		lifeTime -= 0.01;
		reproduceTime += 0.1;
		eating += 0.1;
		if(eating > 20) eating = 20;
		
		lifeTime -= 0.01;
		if(lifeTime < 0) lifeTime = 0; 
		////plus ils veillissent plus il ralentissent
		
		if(health < 0){
			speed = 0; 
		}
		
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
		return PApplet.dist(position.x, position.y, target.x, target.y) < 50;
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
		
		/*
		p.fill(0);
		//p.text("reproduceTime " + reproduceTime, position.x+10, position.y+10);
		p.text("food " + food, position.x+10,position.y+10);
		p.text("eating " + eating, position.x+10,position.y+20);
		p.text("lifetime " + lifeTime, position.x+10,position.y+30);
		p.text("reproduct time " + reproduceTime, position.x+10,position.y+40);
		//p.text("Male", position.x+10,position.y+50);
		p.text("water " + water, position.x+10,position.y+60);
		//p.text("health " + health , position.x +10, position.y +20);
		p.noFill();
		*/
		
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
	    	
	    	if(dead == false)p.image(animU[currentFrame],position.x-48,position.y-48);
	    	if(dead == true)p.image(animDe[0],position.x-48,position.y-48);

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
	    	
	    	if(dead == false)p.image(animUR[currentFrame],position.x-48,position.y-48);
	    	if(dead == true)p.image(animDe[0],position.x-48,position.y-48);

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
	    	
	    	if(dead == false)p.image(animR[currentFrame],position.x-48,position.y-48);
	    	if(dead == true)p.image(animDe[0],position.x-48,position.y-48);

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
	    	
	    	if(dead == false)p.image(animDR[currentFrame],position.x-48,position.y-48);
	    	if(dead == true)p.image(animDe[0],position.x-48,position.y-48);

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
	    	
	    	if(dead == false)p.image(animD[currentFrame],position.x-48,position.y-48);
	    	if(dead == true)p.image(animDe[0],position.x-48,position.y-48);

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
	    	
	    	if(dead == false)p.image(animDL[currentFrame],position.x-48,position.y-48);
	    	if(dead == true)p.image(animDe[0],position.x-48,position.y-48);

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
	    	
	    	if(dead == false)p.image(animL[currentFrame],position.x-48,position.y-48);
	    	if(dead == true)p.image(animDe[0],position.x-48,position.y-48);

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
	    	
	    	if(dead == false)p.image(animUL[currentFrame],position.x-48,position.y-48);
	    	if(dead == true)p.image(animDe[0],position.x-48,position.y-48);

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
	
	public DNAdeer getDNAdeer(){
		return dnadeer;
	}
	
	public float getR(){
		return r;
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
	
	public ArrayList<PVector> getDeerM(){
		return deerm;
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
		water += 20;
	}
	
	public boolean NstarvingLvl1(){
		if(foodPerDay < maxFoodPerDay)return true;
		else return false;
	}

	public boolean NstarvingLvl2(){
		if(foodPerDay < maxFoodPerDay/2)return true;
		else return false;
	}

	public boolean NstarvingLvl3(){
		if(foodPerDay < maxFoodPerDay/3)return true;
		else return false;
	}
	
	////////////////////////
	
	public boolean reproduceTime(){
		if(reproduceTime > 200){
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
	

	
	
	
	
	
}
