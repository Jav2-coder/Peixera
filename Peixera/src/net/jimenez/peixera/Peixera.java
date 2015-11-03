package net.jimenez.peixera;

import java.util.List;
import java.util.Random;

public class Peixera {

	List<Peix> Peixos;
	int width;
	int height;

	public Peixera(List<Peix> fish, int w, int h) {

		Peixos = fish;
		width = w;
		height = h;

	}

	public void posicionament() {

		Random rnd = new Random();

		for (int i = 0; i < Peixos.size(); i++) {

			if (Peixos.get(i).getDir() > 0) {

				if (Peixos.get(i).getEix() == 'X') {

					int posY = rnd.nextInt(height - Peixos.get(i).heightImg());

					Peixos.get(i).setPosicio(0, posY);

				} else {

					int posX = rnd.nextInt(width - Peixos.get(i).widthImg());

					Peixos.get(i).setPosicio(posX, 0);

				}
				
			} else {

				if (Peixos.get(i).getEix() == 'X') {

					int posY = rnd.nextInt(height - Peixos.get(i).heightImg());

					Peixos.get(i).setPosicio(width - Peixos.get(i).widthImg(), posY);

				} else {

					int posX = rnd.nextInt(width - Peixos.get(i).widthImg());

					Peixos.get(i).setPosicio(posX, height - Peixos.get(i).heightImg());

				}
				
			}
		}
	}
}
