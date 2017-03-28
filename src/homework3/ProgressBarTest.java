/* 
 * progress bar 구현 + 하나의 thread로(IncreaseThread.java)
*/

package homework3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame{
	JProgressBar[] bar=new JProgressBar[3];
	MyBar[] mb=new MyBar[3];
	int[] interval={100,500,1000};
	JButton bt;
	
	public ProgressBarTest() {
		for(int i=0; i<bar.length; i++){
			bar[i]=new JProgressBar();
			bar[i].setPreferredSize(new Dimension(450, 40));
			mb[i]=new MyBar(bar[i],interval[i]);
			add(bar[i]);
		}
		bt=new JButton("작동");
		setLayout(new FlowLayout());
		
		//setValue(int n), Sets the progress bar's current value to n.
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(bt);
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ProgressBarTest();

	}

}
