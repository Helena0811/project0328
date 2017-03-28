package threadhomework;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniHomework extends JFrame implements ActionListener{
	JButton bt;
	AniHomeDraw circle;
	AniHomeDraw rectangle;
	
	int x=0, y=0;
	//int veloX=50;
	
	public AniHomework() {
		bt=new JButton("물체 이동");
		// 버튼과 리스터 연결
		bt.addActionListener(this);
		add(bt, BorderLayout.NORTH);
		
		circle=new AniHomeDraw("circle",x,y,50,50);
		add(circle);
		
		/*
		rectangle=new AniHomeDraw("rectangle",0,100,50,50);
		add(rectangle);
		*/
		
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭");
		AniHomeMove thread=new AniHomeMove(AniHomework.this, circle, 50);
		thread.start();
	}
	
	public void move(Canvas can, int veloX){
		System.out.println("이동");
		x+=veloX;
		can.repaint();
	}

	public static void main(String[] args) {
		new AniHomework();

	}
}
