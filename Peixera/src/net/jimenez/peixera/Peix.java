package net.jimenez.peixera;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Peix {

	String sexe;
	int movX;
	int movY;
	GImage imatge;
	boolean vida = true;
	boolean reproduccio = true;

	public Peix(GImage img, String sex, int x, int y) {

		imatge = img;
		sexe = sex;
		movX = x;
		movY = y;
	}

	public boolean getRepro() {
		return reproduccio;
	}
	
	public void setRepro(boolean r){
		reproduccio = r;
	}
	
	public int widthImg() {
		int w = (int) imatge.getWidth();
		return w;
	}

	public String getSexe() {
		return sexe;
	}
	
	public int getPosY() {
		return (int) imatge.getY();
	}
	
	public int getPosX() {
		return (int) imatge.getX();
	}

	public void setVida(boolean life){
		vida = life;
	}
	
	public boolean sexePeixos(Peix p) {
		
		if (p.getSexe().equals(sexe)) {
			return true;
		}
		return false;
	}

	public int heightImg() {
		int h = (int) imatge.getHeight();
		return h;
	}

	public GRectangle getRectangle() {
		return imatge.getBounds();
	}

	public void movimentPeix() {
		imatge.move(movX, movY);
		imatge.pause(1);
	}

	public void canviDireccio() {
		movX = movX * -1;
		movY = movY * -1;
	}

	public void setPosicio(int X, int Y) {
		imatge.setLocation(X, Y);
	}

	public boolean getVida() {
		return vida;
	}
}
