package net.jimenez.peixera;

import java.util.List;
import java.util.Random;

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

	public boolean hihaPeixos() {
		if (Peixos.size() > 0) {
			return false;
		}
		return true;
	}

	public void mourePeixos() {

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

	private void comprovarVida() {

		for (int i = Peixos.size() - 1; i >= 0; i--) {

			if (!Peixos.get(i).getVida()) {

				Peixos.remove(i);

			}
		}
	}

	private void comprovarSexe(int i, int j, GRectangle peix) {

		if (peix.intersects(Peixos.get(j).getRect())
				&& Peixos.get(i) != Peixos.get(j)) {

			String sex1 = Peixos.get(i).getSexe();
			String sex2 = Peixos.get(j).getSexe();

			if (sex1.equals(sex2)) {

				Peixos.get(i).setVida(false);
				Peixos.get(j).setVida(false);

				Peixos.get(i).setPosicio(1000, 1000);
				Peixos.get(j).setPosicio(1000, 1000);

			} else {

				if (Peixos.get(i).getRepro() && Peixos.get(j).getRepro()) {

					Peixos.get(i).setRepro(false);
					Peixos.get(j).setRepro(false);
				}
			}
		}
	}
}
