package net.jimenez.peixera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Peixera {

	GRectangle peixera;
	List<Peix> Peixos;
	List<Peix> Bebes;
	int width;
	int height;
	
	public Peixera(List<Peix> fish, int w, int h, GRectangle recipient) {

		peixera = recipient;
		Peixos = fish;
		width = w;
		height = h;

	}

	public void posicionament() {

		Random rnd = new Random();

		for (int i = 0; i < Peixos.size(); i++) {

			if (Peixos.get(i).getMoveX() == 0) {

				if (Peixos.get(i).getMoveY() > 0) {

					int posX = rnd.nextInt(width - Peixos.get(i).widthImg());

					Peixos.get(i).setPosicio(posX, 0);

				} else {

					int posX = rnd.nextInt(width - Peixos.get(i).widthImg());
					int posY = height - Peixos.get(i).heightImg();

					Peixos.get(i).setPosicio(posX, posY);

				}

			} else {

				if (Peixos.get(i).getMoveX() > 0) {

					int posY = rnd.nextInt(height - Peixos.get(i).heightImg());

					Peixos.get(i).setPosicio(0, posY);

				} else {

					int posX = width - Peixos.get(i).widthImg();
					int posY = rnd.nextInt(height - Peixos.get(i).heightImg());

					Peixos.get(i).setPosicio(posX, posY);

				}
			}
		}
	}
	
	public boolean hihaPeixos(){
		if (Peixos.size()>0){
			return false;
		}
		return true;
	}

	public void mourePeixos() {

		while (Peixos.size() > 0) {

			for (int i = 0; i < Peixos.size(); i++) {

				GRectangle peix = Peixos.get(i).getRect();

				if (peix.intersects(peixera) && Peixos.get(i).getVida()) {

					Peixos.get(i).movimentPeix();

					for (int j = 0; j < Peixos.size(); j++) {

						comprovarSexe(i, j, peix);
					}

				} else {

					Peixos.get(i).canviDireccio();
					Peixos.get(i).movimentPeix();

				}
			}

			comprovarVida();
		}
	}

	private void comprovarVida() {
		
		for (int i = Peixos.size() - 1; i >= 0; i--) {

			if (!Peixos.get(i).getVida()) {

				Peixos.remove(i);

			}
		}
	}

	private void comprovarSexe(int i, int j, GRectangle peix) {
		
		if (peix.intersects(Peixos.get(j).getRect()) && Peixos.get(i) != Peixos.get(j)) {

			String sex1 = Peixos.get(i).getSexe();
			String sex2 = Peixos.get(j).getSexe();

			if (sex1.equals(sex2)) {

				Peixos.get(i).setVida(false);
				Peixos.get(j).setVida(false);

				Peixos.get(i).setPosicio(1000, 1000);
				Peixos.get(j).setPosicio(1000, 1000);

			} else {

				if(Peixos.get(i).getRepro() && Peixos.get(j).getRepro()){
				
				Peixos.get(i).setRepro(false);
				Peixos.get(j).setRepro(false);
				crearBebe(i, j);
				
				} 
			}
		}
	}

	private void crearBebe(int i, int j) {
		
		Bebes = new ArrayList<Peix>();
		Random rnd = new Random();
		String[] sexe = { "mascle", "femella" };
		int [] direccio = {0, 1, -1};
		int posX;
		int posY;
		int sex = rnd.nextInt(2);
		GImage nouPeix;
		
		int movX = direccio[rnd.nextInt(3)];
		int movY = 0;
		
		if (movX == 0) {
			
			movY = direccio[rnd.nextInt(2) + 1];
			
		}

		if (Peixos.get(i).getSexe().equals(sexe[sex])) {

			nouPeix = Peixos.get(i).getImage();
			posX = (int) Peixos.get(i).getImage().getX();
			posY = (int) Peixos.get(i).getImage().getY();
			
		} else {

			nouPeix = Peixos.get(j).getImage();
			posX = (int) Peixos.get(j).getImage().getX();
			posY = (int) Peixos.get(j).getImage().getY();
		}

		System.out.println(posX + " " + posY);
		
		Peix P = new Peix(nouPeix, sexe[sex], movX, movY);
		P.setPosicio(posX, posY);
		Bebes.add(P);
	}
}
