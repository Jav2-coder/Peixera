package net.jimenez.peixera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class App extends GraphicsProgram {

	String [] genere = {"mascle", "femella"};
	int [] direccio = {0, 1, -1};
	List<Peix> Peixos = new ArrayList<Peix>();
	
	private static final long serialVersionUID = -9166620709533676373L;

	public void init() {
	
		setSize(600, 600);
		
	}
	
	public void run() {
		
		for(int i = 0; i < 2; i++){
			
			Peixos.add(crearPeix());
			
		}
		
		Peixera peixera = new Peixera(Peixos, getWidth(), getHeight());
		peixera.posicionament();
		
	}
	
	private Peix crearPeix() {

		Random rnd = new Random();

		String sexe = genere[rnd.nextInt(2)];
		int movX = direccio[rnd.nextInt(3)];
		int movY = 0;
		
		if (movX == 0) {
			
			movY = direccio[rnd.nextInt(2)] + 1;
			
		}
		
		GImage img;
		
		if(sexe.equals(genere[0])){	
			img = new GImage("inky.png");
			img.scale(0.1);
			add(img);	
		} else {	
			img = new GImage("pinky.png");
			img.scale(0.1);
			add(img);	
		}
		
		Peix P = new Peix(img, sexe, movX, movY);

		return P;
	}	
}
