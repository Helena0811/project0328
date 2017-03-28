package progressbar;

import javax.swing.JProgressBar;

public class IncreaseThread2 extends Thread{
	int interval;
	int count=0;
	ProgressBarTest2 progressBarTest2;
	JProgressBar bar;
	
	public IncreaseThread2(ProgressBarTest2 progressBarTest2, JProgressBar bar, int interval) {
		this.progressBarTest2=progressBarTest2;
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
