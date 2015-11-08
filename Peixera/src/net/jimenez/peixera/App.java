package net.jimenez.peixera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GRectangle;
import acm.program.GraphicsProgram;

public class App extends GraphicsProgram {

	String [] genere = {"mascle", "femella"};
	int [] direccio = {0, 1, -1};
	List<Peix> Peixos = new ArrayList<Peix>();
	Random rnd;
	
	private static final long serialVersionUID = -9166620709533676373L;

	public void init() {
	
		setSize(600, 700);
		
	}
	
	public void run() {
		
		GRectangle recipient = new GRectangle(0, 0, getWidth(), getHeight());
		
		for(int i = 0; i < 50; i++){
			
			if (i < 25) {
			Peixos.add(crearPeix("mascle"));
			} else {
				Peixos.add(crearPeix("femella"));	
			}
		}
		
		Peixera peixera = new Peixera(Peixos, getWidth(), getHeight(), recipient);
		peixera.posicionament();
		comprovaPeixos(peixera);
		
	}
	
	private void comprovaPeixos(Peixera peixera){
		while (!peixera.hihaPeixos()){
			peixera.mourePeixos();
		}
	}
	
	private Peix crearPeix(String sexe) {

		rnd = new Random();

		int movX = direccio[rnd.nextInt(3)];
		int movY = 0;
		
		if (movX == 0) {
			
			movY = direccio[rnd.nextInt(2) + 1];
			
		}
		
		GImage img;
		
		if(sexe.equals("mascle")){	
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
