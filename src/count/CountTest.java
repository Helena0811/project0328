/*
 * label1	label2	count�� ���
 * label1�� label2�� count�� ���� �ӵ��� �ٸ����� ����
 * thread 2���� ����
 * */
package count;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountTest extends JFrame{
	JLabel lb_left, lb_right;
	
	public CountTest() {
		lb_left=new JLabel("0");
		lb_left.setSize(200, 200);
		lb_right=new JLabel("0");
		lb_right.setSize(200, 200);
		
		CountThread cnt=new CountThread(this, lb_left, 5000);
		CountThread cnt2=new CountThread(this, lb_right, 1000);

		cnt.start();
		cnt2.start();
		
		setLayout(new FlowLayout());
		add(lb_left);
		add(lb_right);
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
/*	
	// count ���� �޼ҵ�
	public void increase(){
		
	}
*/	
	public static void main(String[] args) {
		new CountTest();
	}
}
