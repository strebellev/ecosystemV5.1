package animals;

import java.util.ArrayList;

import mechanisme.DNAsouris;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class SourisF {
	PApplet parent;
	ArrayList<PVector> sourism;
	
	public PVector position;
	
	DNAsouris dnasouris;
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
	float food;
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

	
	//////test anim/////
	int animUnumFrame = 4;
	int animURnumFrame = 4;
	int animRnumFrame = 4;
	int animDRnumFrame = 4;
	int animDnumFrame = 4;
	int animDLnumFrame = 4;
	int animLnumFrame = 4;
	int animULnumFrame = 4;
	
	
	int currentFrame = 0;
	
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
	public SourisF(PVector l, DNAsouris dnasouris_, PApplet p){
		parent = p;
		position = l.get();
		xoff = p.random(3200);
		yoff = p.random(3200);
		
		dnasouris = dnasouris_;
		
		health = PApplet.map(dnasouris.genes[0], 0, 1, 50, 250);
		r = PApplet.map(dnasouris.genes[0], 0, 1, 4, 8);
		//maxspeed = PApplet.map(dnasouris.genes[0], 0, 1, 1, 2);
		lifeTime = PApplet.map(dnasouris.genes[0], 0, 1, 200, 300);
		maxLifeTime = PApplet.map(dnasouris.genes[0], 0, 1, 200, 300);
		//water = PApplet.map(dnasouris.genes[1], 0, 1, 100, 200);
		food = PApplet.map(dnasouris.genes[1], 0, 1, 100, 200);
		fieldOfView = PApplet.map(dnasouris.genes[2], 0, 1, 200, 300);
		
		speed = PApplet.map(dnasouris.genes[0], 0, 1, (float)0.7, 1);
		
		///for food 1000 = 1kg
		weight = PApplet.map(dnasouris.genes[1], 0, 1, 400, 600);
		foodPerDay = 0;
		maxFoodPerDay = PApplet.map(dnasouris.genes[1], 0, 1, 30, 60);

		//carac pour corpse
		meat = weight/100;
		furr = 0;
		bone = 1;

		acceleration = new PVector(0,0);
		velocity = new PVector(0,0);
		maxforce = (float) 0.1;
		
		//////test anim/////
		animU[0] = p.loadImage("res/newAnimal/Mouse/MouseU0.png");
		animU[1] = p.loadImage("res/newAnimal/Mouse/MouseU1.png");
		animU[2] = p.loadImage("res/newAnimal/Mouse/MouseU2.png");
		animU[3] = p.loadImage("res/newAnimal/Mouse/MouseU3.png");
		
		animUR[0] = p.loadImage("res/newAnimal/Mouse/MouseUR0.png");
		animUR[1] = p.loadImage("res/newAnimal/Mouse/MouseUR1.png");
		animUR[2] = p.loadImage("res/newAnimal/Mouse/MouseUR2.png");
		animUR[3] = p.loadImage("res/newAnimal/Mouse/MouseUR3.png");
		
		animR[0] = p.loadImage("res/newAnimal/Mouse/MouseR0.png");
		animR[1] = p.loadImage("res/newAnimal/Mouse/MouseR1.png");
		animR[2] = p.loadImage("res/newAnimal/Mouse/MouseR2.png");
		animR[3] = p.loadImage("res/newAnimal/Mouse/MouseR3.png");
		
		animDR[0] = p.loadImage("res/newAnimal/Mouse/MouseDR0.png");
		animDR[1] = p.loadImage("res/newAnimal/Mouse/MouseDR1.png");
		animDR[2] = p.loadImage("res/newAnimal/Mouse/MouseDR2.png");
		animDR[3] = p.loadImage("res/newAnimal/Mouse/MouseDR3.png");
		
		animD[0] = p.loadImage("res/newAnimal/Mouse/MouseD0.png");
		animD[1] = p.loadImage("res/newAnimal/Mouse/MouseD1.png");
		animD[2] = p.loadImage("res/newAnimal/Mouse/MouseD2.png");
		animD[3] = p.loadImage("res/newAnimal/Mouse/MouseD3.png");
		
		animDL[0] = p.loadImage("res/newAnimal/Mouse/MouseDL0.png");
		animDL[1] = p.loadImage("res/newAnimal/Mouse/MouseDL1.png");
		animDL[2] = p.loadImage("res/newAnimal/Mouse/MouseDL2.png");
		animDL[3] = p.loadImage("res/newAnimal/Mouse/MouseDL3.png");
		
		animL[0] = p.loadImage("res/newAnimal/Mouse/MouseL0.png");
		animL[1] = p.loadImage("res/newAnimal/Mouse/MouseL1.png");
		animL[2] = p.loadImage("res/newAnimal/Mouse/MouseL2.png");
		animL[3] = p.loadImage("res/newAnimal/Mouse/MouseL3.png");
		
		animUL[0] = p.loadImage("res/newAnimal/Mouse/MouseUL0.png");
		animUL[1] = p.loadImage("res/newAnimal/Mouse/MouseUL1.png");
		animUL[2] = p.loadImage("res/newAnimal/Mouse/MouseUL2.png");
		animUL[3] = p.loadImage("res/newAnimal/Mouse/MouseUL3.png");
			
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
		if(water > 200){
			water = 200;
		}
		food -= 0.05;
		if(food < 0){
			food = 0;
		}
		if(food >200){
			food = 200;
		}
		if(health < 0) health = 0;
		if(health > 250) health = 250;
		health -= 0.01;
		//lifeTime -= 0.01;
		reproduceTime += 0.1;
		eating += 0.1;
		if(eating > 20) eating = 20;
		
		lifeTime -= 0.001;
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
	    	    if (currentFrame > 3) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animU[currentFrame],position.x-16,position.y-16);
	    	break;
	    case 1:
	    	//p.text("right",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 3) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animUR[currentFrame],position.x-16,position.y-16);
	    	break;
	    case 2:
	    	//p.text("down",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 3) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animR[currentFrame],position.x-16,position.y-16);
	    	break;
	    case 3:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 3) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animDR[currentFrame],position.x-16,position.y-16);
	    	break;
	    case 4:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 3) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animD[currentFrame],position.x-16,position.y-16);
	    	break;	
	    case 5:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 3) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animDL[currentFrame],position.x-16,position.y-16);
	    	break;	
	    case 6:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 3) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animL[currentFrame],position.x-16,position.y-16);
	    	break;
	    case 7:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 3) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animUL[currentFrame],position.x-16,position.y-16);
	    	break;
	    }
		////////////////////
		//p.text("health " + health , position.x +10, position.y +20);
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
	
	public void findMale(PVector target){
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
	
	public DNAsouris getDNAsouris(){
		return dnasouris;
	}
	
	public float getR(){
		return r;
	}
	
	public ArrayList<PVector> getSourisM(){
		return sourism;
	}
	
	public boolean dead(){
		if(health <= 0.0 || lifeTime <= 0.0)return true;
		else 	return false;
		
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
	
	public boolean Nfaim(){
		if(foodPerDay < maxFoodPerDay){
			return true;
		}
		else{
			return false;
		}
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
