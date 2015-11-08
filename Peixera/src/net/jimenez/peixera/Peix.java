package net.jimenez.peixera;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Peix {

	String sexe;
	int movX;
	int movY;
	GImage imatge;
	boolean vida = true;
	boolean repro = true;
	
	public Peix(GImage img, String sex, int x, int y) {	
		
		imatge = img;
		sexe = sex;
		movX = x;
		movY = y;
	}
	
	public boolean getVida() {
		return vida;
	}
	
	public void setVida(boolean mort){
		vida = mort;
	}
	
	public boolean getRepro() {
		return repro;
	}
	
	public void setRepro(boolean r) {
		repro = r;
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
		return (int) imatge.getY();
	}
	
	public int getPosX() {
		return (int) imatge.getX();
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
		imatge.setLocation(X, Y);	
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
