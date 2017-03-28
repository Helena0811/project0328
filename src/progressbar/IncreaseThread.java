package progressbar;

import javax.swing.JProgressBar;

public class IncreaseThread extends Thread{
	int interval;
	int count=0;
	ProgressBarTest progressBarTest;
	JProgressBar bar;
	
	public IncreaseThread(ProgressBarTest progressBarTest, JProgressBar bar, int interval) {
		this.progressBarTest=progressBarTest;
		this.interval=interval;
		this.bar=bar;
		this.start();
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
