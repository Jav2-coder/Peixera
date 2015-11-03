package net.jimenez.peixera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class App extends GraphicsProgram {

	String [] genere = {"mascle", "femella"};
	int [] direccio = {1, -1};
	List<Peix> Peixos = new ArrayList<Peix>();
	
	private static final long serialVersionUID = -9166620709533676373L;

	public void init() {
	
		setSize(600, 600);
		
	}
	
	public void run() {
		
		for(int i = 0; i < 2; i++){
			
			Peixos.add(crearPeix());
			
		}
		
		Peixos.get(0).setEix('X');
		Peixos.get(1).setEix('Y');
		
		Peixera peixera = new Peixera(Peixos, getWidth(), getHeight());
		peixera.posicionament();
		
	}
	
	private Peix crearPeix() {

		Random rnd = new Random();

		String sexe = genere[rnd.nextInt(2)];
		int dir = direccio[rnd.nextInt(2)];
		GImage img;
		
		if(sexe.equals(genere[0])){	
			img = new GImage("inky.png");
			img.scale(0.35);
			add(img);	
		} else {	
			img = new GImage("pinky.png");
			img.scale(0.35);
			add(img);	
		}
		
		Peix P = new Peix(img, sexe, dir);

		return P;
	}	
}
