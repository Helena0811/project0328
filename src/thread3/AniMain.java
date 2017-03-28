/*
 * �����ڰ� �����带 ��ӹ޾� ������ �� ������, �̹� �ٸ� Ŭ������ �ڽ��� ��� ����� �Ұ���!
 * �̶� ����� �� �ִ� ��ü : Runnable �������̽�
 * */
package thread3;

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

public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas can;
	int x=0,y=0;
	Thread thread;
	
	public AniMain() {
		// Runnable �������̽��� ����ϹǷ� ���� �͸� Ŭ���� �ʿ�X
		// Thread(Runnable target)
		// Runnable�� ��ü�� �μ��� �ѱ�� 
		// -> run() ȣ���� Runnable�� �������� ��ü�� run() ȣ��
		// this�� Runnable target���� �־����Ƿ� AniMain ��ü�� run() ȣ��
		// �̹� ��ӹ޾��� ���(�̹� �ڽ� Ŭ����) Runnable �������̽��� ���� ����
		thread=new Thread(this);
		
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
