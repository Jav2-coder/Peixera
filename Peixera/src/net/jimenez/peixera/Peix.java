package net.jimenez.peixera;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Peix {

	String sexe;
	int movX;
	int movY;
	GImage imatge;
	int posX;
	int posY;
	boolean vida;
	
	public Peix(GImage img, String sex, int x, int y, boolean life) {	
		imatge = img;
		sexe = sex;
		movX = x;
		movY = y;	
		vida = life;
	}
	public boolean getVida() {
		return vida;
	}
	public void setVida(boolean mort){
		vida = mort;
	}
	public String getSexe() {
		return sexe;
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
		imatge.pause(1);
	}
	
	public void canviDireccio() {
		movX = movX * -1;
		movY = movY * -1;	
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
	
	public GRectangle getRect() {
		return imatge.getBounds();
	}	
}
