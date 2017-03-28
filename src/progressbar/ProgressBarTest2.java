/* 
 * progress bar 구현 	+ 내부 익명 클래스 사용
*/
package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest2 extends JFrame{
	JProgressBar bar1, bar2, bar3;
	JButton bt;
	Thread thread;
	
	public ProgressBarTest2() {
		bar1=new JProgressBar();
		bar2=new JProgressBar();
		bar3=new JProgressBar();
		bt=new JButton("작동");
		setLayout(new FlowLayout());
		
		bar1.setPreferredSize(new Dimension(450, 40));
		bar2.setPreferredSize(new Dimension(450, 40));
		bar3.setPreferredSize(new Dimension(450, 40));
		
		//setValue(int n), Sets the progress bar's current value to n.
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 내부 익명 클래스를 사용한 thread 구현
				thread=new Thread(){
					
					@Override
					public void run() {
						while(true){
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				};
			}
		});
		
		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ProgressBarTest2();

	}

}
