package homework3;

import javax.swing.JProgressBar;

public class MyBar extends Thread{
	JProgressBar bar;
	int count;
	int interval;
	
	public MyBar(JProgressBar bar, int interval) {
		this.bar=bar;
		this.interval=interval;
		start();
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);
		}
	}
}
