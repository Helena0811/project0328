package threadhomework;

import java.awt.Canvas;
import java.awt.Graphics;

public class AniHomeDraw extends Canvas{
	String shape=null;
	int x=0, y=0, width=0, height=0;
	
	public AniHomeDraw(String shape, int x, int y, int width, int height) {
		this.shape=shape;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public void paint(Graphics g) {
		if(shape=="circle"){
			g.drawOval(x, y, width, height);
		}
		else if(shape=="rectangle"){
			g.drawRect(x, y, width, height);
		}
	}
}
