/*
 * ���� �ٸ� �׷���, �ӵ�, ��Ÿ ���� ���� ��ü 3�� �̵��ϱ�
 * - ������ 3���� ����
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
		bt=new JButton("���� �����̱�");
		can=new Canvas(){
			@Override
			// paint()�� CircleThread�� ���ຸ�� ������ ����Ǿ CircleThread�� �Ѿ Graphics g���� null
			public void paint(Graphics g) {
				// ct=new CircleThread(can, 0, 0, 50, 50);
				// paint�޼ҵ�� ������ â�� �����⸸ �ص� ȣ��Ǳ� ������ new�� ������ ������
				// ���� CircleThread�� �ܺο� �����ؾ� ��!
				gp=g;
			}
		};
		
		// Graphics g�� ���� �͸� Ŭ������ ����, ���� Graphics g�� ������ ����
		// CircleThread Ŭ���� ���� -> JVM�� �ñ��
		ct=new CircleThread(gp, 0, 0, 50, 50);
		ct.start();
		*/
		
		bt=new JButton("���� �����̱�");
		can=new Canvas(){
			@Override
			// paint()�� CircleThread�� ���ຸ�� ������ ����Ǿ CircleThread�� �Ѿ Graphics g���� null
			public void paint(Graphics g) {
				// ct=new CircleThread(can, 0, 0, 50, 50);
				// paint�޼ҵ�� ������ â�� �����⸸ �ص� ȣ��Ǳ� ������ new�� ������ ������
				// ���� CircleThread�� �ܺο� �����ؾ� ��!
				// gp=g;
			}
		};
		
		can.setBackground(Color.green);
		add(bt,BorderLayout.NORTH);		
		add(can);
		
		// ��ư�� ������ CircleThread�� ����ǵ��� 
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g=can.getGraphics();
				/*
				ct=new CircleThread(g, 0, 0, 50, 50);
				ct.start();
				*/
				//CircleThread ct=new CircleThread(0, 0, 50, 50, 1000, g);
				//ShapeThread st=ct;	// ����(downcasting)
				//ct.start();	// CircleThread < ShapeThread < Thread : start()
				// ShpaeThreadŬ������ �̹� start() �����س���
				
				
				for(int i=0; i<5; i++){
					CircleThread ct=new CircleThread(0, i*(50+10), 50, 50, 500, g);
				}
				
				RectThread rt=new RectThread(0, 200, 100, 100, 100, g);
				// ���� ������ ���� ���簢���� ���� �ٸ��� �׸��� ���� : �׸��� Ÿ�̹��� ���� �ٸ��� ����!
				// thread �ϳ��� �ΰ� interval�� ���ϵǾ�� ��!
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
