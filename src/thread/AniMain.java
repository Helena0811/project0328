package thread;

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
	AniMain aniMain;
	//MoveThread moveThread;
	
	public AniMain() {
		aniMain=this;
		bt=new JButton("물체 이동");
		// 버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//move();
				// 동생 Thread를 생성하여 수행
				// MoveThread 클래스를 생성할 때 인수로 AniMain을 넘겨서
				// MoveThread가 AniMain의 move()메소드를 사용할 수 있도록 구현
				// MoveThread moveThread=new MoveThread(this);
				// 여기서 this를 넣으면 구현 불가능 -> 현재 this가 가리키는 것은 ActionListener()
				// MoveThread moveThread=new MoveThread(AniMain.this); 가능
				// 클래스명.this -> 해당 클래스를 가리킬 수 있음!
				MoveThread moveThread=new MoveThread(aniMain);
				moveThread.start();
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
