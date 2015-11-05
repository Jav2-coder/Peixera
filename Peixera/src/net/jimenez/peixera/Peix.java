package net.jimenez.peixera;

import acm.graphics.GImage;

public class Peix {

	String sexe;
	int movX;
	int movY;
	GImage imatge;
	int posX;
	int posY;
	
	public Peix(GImage img, String sex, int x, int y) {	
		imatge = img;
		sexe = sex;
		movX = x;
		movY = y;	
	}
	
	public int getMoveX() {	
		return movX;	
	}
	
	public void setMoveX(int x) {
		movX = x;
	}
	
	public int getMoveY() {
		return movY;
	}
	
	public void setMoveY(int y) {
		movY = y;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void movimentPeix() {
		imatge.move(movX, movY);
		imatge.pause(5);
	}
	
	public void setPosicio(int X, int Y){	
		posX = X;
		posY = Y;
		imatge.setLocation(posX, posY);	
	}
	
	public int widthImg() {
		int w = (int) imatge.getWidth();
		return w;
	}
	
	public int heightImg() {
		int h = (int) imatge.getHeight();
		return h;
	}
	
	public GImage getImage() {
		return imatge;
	}
	
}
