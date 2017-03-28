/*
 * 내부 익명 클래스로 구현(MoveThread 필요없음)
 * */
package thread2;

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

public class AniMain extends JFrame{
	JButton bt;
	Canvas can;
	int x=0,y=0;
	Thread thread;	// 내부 익명 스타일로 구현
	
	public AniMain() {
		// 내부 익명 클래스
		thread=new Thread(){
			@Override
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
		};
		
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
	
	public static void main(String[] args) {
		new AniMain();
}

}
