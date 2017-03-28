package count;

import javax.swing.JLabel;

public class CountThread extends Thread{
	CountTest countTest;
	JLabel label;
	int interval;
	int count=0;
	
	public CountThread(CountTest countTest, JLabel label, int interval) {
		this.countTest=countTest;
		this.interval=interval;
		this.label=label;
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			label.setText(Integer.toString(count));
		}
	}
}
