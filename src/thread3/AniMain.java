/*
 * 개발자가 쓰레드를 상속받아 개발할 수 있지만, 이미 다른 클래스의 자식일 경우 상속은 불가능!
 * 이때 사용할 수 있는 객체 : Runnable 인터페이스
 * */
package thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
/*
 * Thread를 이용해서 버튼을 누르면 원이 이동하는 클래스 구현
 * */
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas can;
	int x=0,y=0;
	Thread thread;
	
	public AniMain() {
		// Runnable 인터페이스를 사용하므로 내부 익명 클래스 필요X
		// Thread(Runnable target)
		// Runnable인 객체를 인수로 넘기기 
		// -> run() 호출은 Runnable을 재정의한 객체의 run() 호출
		// this를 Runnable target으로 넣었으므로 AniMain 객체의 run() 호출
		// 이미 상속받았을 경우(이미 자식 클래스) Runnable 인터페이스로 구현 가능
		thread=new Thread(this);
		
		bt=new JButton("물체 이동");
		// 버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//move();
				// 동생 Thread를 생성하여 수행
				thread.start();
			}
		});
		
		add(bt, BorderLayout.NORTH);
		
		// 원을 그리는 것은 재사용성이 떨어지므로 내부 입력 클래스로 구현
		can=new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		can.setBackground(Color.CYAN);
		
		add(can);
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move(){
		x+=5;
		can.repaint();	// refresh
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			move();
		}
	}
	
	public static void main(String[] args) {
		new AniMain();
}

}
