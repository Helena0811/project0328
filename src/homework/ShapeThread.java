/*
 * 도형의 공통 특성만 가지고 있는 최상위 도형 클래스
 * -> 어떤 도형도 표현 가능한 객체
 * */
package homework;

import java.awt.Color;
import java.awt.Graphics;

// 최상위의 도형 클래스 = 추상 클래스
public abstract class ShapeThread extends Thread{
	int x=0, y=0, width=0, height=0;
	Graphics g;
	int interval=0;	// 시간
	
	// 생성자(인수를 받아와서 저장)
	public ShapeThread(int x, int y, int width, int height, int interval, Graphics g) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		this.g=g;
		start();	// 스스로 쓰레드 실행
	}
	
	// 자식 클래스(다양한 도형)가 override하도록 완성하지 말아야 함 -> 추상 메소드
	// canvas에서 그려야 할 그림을 여기서 그리기
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
