/*
 * ���� �͸� Ŭ������ ����(MoveThread �ʿ����)
 * */
package thread2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
/*
 * Thread�� �̿��ؼ� ��ư�� ������ ���� �̵��ϴ� Ŭ���� ����
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
	Thread thread;	// ���� �͸� ��Ÿ�Ϸ� ����
	
	public AniMain() {
		// ���� �͸� Ŭ����
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
		
		bt=new JButton("��ü �̵�");
		// ��ư�� ������ ����
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//move();
				// ���� Thread�� �����Ͽ� ����
				thread.start();
			}
		});
		
		add(bt, BorderLayout.NORTH);
		
		// ���� �׸��� ���� ���뼺�� �������Ƿ� ���� �Է� Ŭ������ ����
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
