/* 
 * progress bar 구현 + 하나의 thread로(IncreaseThread.java)
*/
package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame{
	JProgressBar bar1, bar2, bar3;
	JButton bt;
	
	public ProgressBarTest() {
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
				IncreaseThread thread1=new IncreaseThread(ProgressBarTest.this, bar1, 50);
				IncreaseThread thread2=new IncreaseThread(ProgressBarTest.this, bar2, 100);
				IncreaseThread thread3=new IncreaseThread(ProgressBarTest.this, bar3, 250);
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
		new ProgressBarTest();

	}

}
