package net.jimenez.peixera;

import acm.graphics.GImage;

public class Peix {

	String sexe;
	char eix;
	GImage imatge;
	int direccio;
	int posX;
	int posY;
	
	public Peix(GImage img, String sex, int dir) {
		
		imatge = img;
		sexe = sex;
		direccio = dir;
		
	}
	
	public char getEix() {
		
		return eix;
		
	}
	
	public int posY() {
		return posY;
	}
	
	public int getDir() {
		
		return direccio;
		
	}
	
	public void setEix(char e) {
		
		eix = e;
		
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
}
