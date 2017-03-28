/*
 * ������ ���� Ư���� ������ �ִ� �ֻ��� ���� Ŭ����
 * -> � ������ ǥ�� ������ ��ü
 * */
package homework;

import java.awt.Color;
import java.awt.Graphics;

// �ֻ����� ���� Ŭ���� = �߻� Ŭ����
public abstract class ShapeThread extends Thread{
	int x=0, y=0, width=0, height=0;
	Graphics g;
	int interval=0;	// �ð�
	
	// ������(�μ��� �޾ƿͼ� ����)
	public ShapeThread(int x, int y, int width, int height, int interval, Graphics g) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		this.g=g;
		start();	// ������ ������ ����
	}
	
	// �ڽ� Ŭ����(�پ��� ����)�� override�ϵ��� �ϼ����� ���ƾ� �� -> �߻� �޼ҵ�
	// canvas���� �׷��� �� �׸��� ���⼭ �׸���
	public abstract void render();
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			render();
		}
	}
}
