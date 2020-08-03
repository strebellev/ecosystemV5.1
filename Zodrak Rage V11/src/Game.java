

import mechanisme.Inventory;
import mechanisme.World2;
import processing.core.PApplet;
import entity.Player2;


public class Game extends PApplet{
	
	

	public static void main(String[] args){
		PApplet.main("Game");
	}
	
	public void settings(){
		size(1200,900);
		
	}
	
	World2 world2;
	Player2 p2;
	Inventory inv;
	
	public void setup(){
		
		world2 = new World2(this);
		surface.setResizable(true);
		
	}
	
	
	public void draw(){
		world2.makeWorld();
		world2.runWorld();
		world2.launchPrey();
		world2.launchPredator();
		world2.run();
		world2.displayAll();
		world2.GUIAdmin();
		
	}
	
}
