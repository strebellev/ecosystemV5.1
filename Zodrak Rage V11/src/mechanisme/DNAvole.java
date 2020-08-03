package mechanisme;

import processing.core.PApplet;

public class DNAvole {
	PApplet parent;
	public float[] genes;
	int diffgenes = 5;
	DNAvole dnavole;
	
	public DNAvole(PApplet p){
		parent = p;
		genes = new float[diffgenes];
		for(int i = 0; i < genes.length; i++){
			genes[i] = p.random(0, 1);
		}
	}
	
	DNAvole(float[] newgenes){
		genes = newgenes;
	}
	
	public DNAvole copy(){
		float[] newgenes = new float[genes.length];
		for(int i =0; i < newgenes.length; i++){
			newgenes[i] = genes[i];
		}
		return new DNAvole(newgenes);
	}
	
	DNAvole crossover(DNAvole partner,PApplet p){
		float[] child = new float[genes.length];
		int crossover = (int) p.random(5);
		for(int i = 0; i < genes.length; i++){
			if(i > crossover){
				child[i] = genes[i];
			}
			else{
				child[i] = partner.genes[i];
			}
		}
		DNAvole newgenes = new DNAvole(child);
		return newgenes;
	}
	
	public DNAvole getDNAvole(){
		return dnavole;
	}
	
	public void mutate(float m){
		for(int i = 0; i < genes.length; i++){
			if(parent.random(1) < m){
				genes[i] = parent.random(0, 1);
			}
		}
	}
}
