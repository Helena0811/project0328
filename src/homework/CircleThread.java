/*
 * 원을 표현한 객체 및 움직임
 * -> 사각형, 삼각형 등 다른 도형도 로직은 거의 비슷
 * -> 상속 관계(최상위 클래스-도형)로 구현
 * ex) GameObject 최상위 클래스
 * */
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{
	
	// 생성되면서 값 받아오기
	public CircleThread(int x, int y, int width, int height, int interval, Graphics g) {
		// this.x=x; 이미 부모에서 받아오므로 부모를 불러오면서 인수로 넣기
		super(x,y,width,height,interval,g);
	}
	
	// canvas에서 그려야 할 그림을 여기서 그리기
	// ShapeThread(부모)의 클래스 override
	public void render(){	// 캔버스에 그려질 그 g
		// 쓰레드 입장에서 g는 아직 얻어오지 못함 - java.lang.NullPointerException 에러 발생
		// System.out.println("g는 "+g);
		// 그림을 지울 때 기존의 그림을 지우기
		
		// 지우기
		// 초록색 페인트로 윈도우 적용
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 700, 600);
		
		// 그리기
		g.setColor(Color.BLACK);
		x+=5;
		g.drawOval(x, y, width, height);
		// canvas의 repaint()는 어디에?
	}
}
