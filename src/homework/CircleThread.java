/*
 * ���� ǥ���� ��ü �� ������
 * -> �簢��, �ﰢ�� �� �ٸ� ������ ������ ���� ���
 * -> ��� ����(�ֻ��� Ŭ����-����)�� ����
 * ex) GameObject �ֻ��� Ŭ����
 * */
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{
	
	// �����Ǹ鼭 �� �޾ƿ���
	public CircleThread(int x, int y, int width, int height, int interval, Graphics g) {
		// this.x=x; �̹� �θ𿡼� �޾ƿ��Ƿ� �θ� �ҷ����鼭 �μ��� �ֱ�
		super(x,y,width,height,interval,g);
	}
	
	// canvas���� �׷��� �� �׸��� ���⼭ �׸���
	// ShapeThread(�θ�)�� Ŭ���� override
	public void render(){	// ĵ������ �׷��� �� g
		// ������ ���忡�� g�� ���� ������ ���� - java.lang.NullPointerException ���� �߻�
		// System.out.println("g�� "+g);
		// �׸��� ���� �� ������ �׸��� �����
		
		// �����
		// �ʷϻ� ����Ʈ�� ������ ����
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 700, 600);
		
		// �׸���
		g.setColor(Color.BLACK);
		x+=5;
		g.drawOval(x, y, width, height);
		// canvas�� repaint()�� ���?
	}
}
