/*
 * 서로 다른 그래픽, 속도, 기타 값을 갖는 물체 3개 이동하기
 * - 스레드 3개로 구현
 * */
package homework;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiAni extends JFrame{
	JButton bt;
	Canvas can;
	CircleThread ct;
	//Graphics gp;
	
	public MultiAni() {
		/*
		bt=new JButton("각자 움직이기");
		can=new Canvas(){
			@Override
			// paint()는 CircleThread의 수행보다 느리게 수행되어서 CircleThread의 넘어간 Graphics g값이 null
			public void paint(Graphics g) {
				// ct=new CircleThread(can, 0, 0, 50, 50);
				// paint메소드는 윈도우 창을 만지기만 해도 호출되기 때문에 new가 여러개 생성됨
				// 따라서 CircleThread는 외부에 생성해야 함!
				gp=g;
			}
		};
		
		// Graphics g는 내부 익명 클래스에 존재, 따라서 Graphics g를 밖으로 빼기
		// CircleThread 클래스 생성 -> JVM에 맡기기
		ct=new CircleThread(gp, 0, 0, 50, 50);
		ct.start();
		*/
		
		bt=new JButton("각자 움직이기");
		can=new Canvas(){
			@Override
			// paint()는 CircleThread의 수행보다 느리게 수행되어서 CircleThread의 넘어간 Graphics g값이 null
			public void paint(Graphics g) {
				// ct=new CircleThread(can, 0, 0, 50, 50);
				// paint메소드는 윈도우 창을 만지기만 해도 호출되기 때문에 new가 여러개 생성됨
				// 따라서 CircleThread는 외부에 생성해야 함!
				// gp=g;
			}
		};
		
		can.setBackground(Color.green);
		add(bt,BorderLayout.NORTH);		
		add(can);
		
		// 버튼을 누르면 CircleThread가 수행되도록 
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g=can.getGraphics();
				/*
				ct=new CircleThread(g, 0, 0, 50, 50);
				ct.start();
				*/
				//CircleThread ct=new CircleThread(0, 0, 50, 50, 1000, g);
				//ShapeThread st=ct;	// 가능(downcasting)
				//ct.start();	// CircleThread < ShapeThread < Thread : start()
				// ShpaeThread클래스에 이미 start() 구현해놓음
				
				
				for(int i=0; i<5; i++){
					CircleThread ct=new CircleThread(0, i*(50+10), 50, 50, 500, g);
				}
				
				RectThread rt=new RectThread(0, 200, 100, 100, 100, g);
				// 현재 생성된 원과 직사각형이 서로 다르게 그리는 이유 : 그리는 타이밍이 서로 다르기 때문!
				// thread 하나로 두고 interval은 통일되어야 함!
			}
		});
		
		setVisible(true);
		setSize(700, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MultiAni();
	}
}
