package streamthread;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressThread extends Thread{
	FileProgressBar fileProgressBar;
	JProgressBar bar;
	JLabel label;
	int fileSize;
	int data;
	int progress=0;
	
	public ProgressThread(JProgressBar bar, JLabel label, int fileSize, int data) {
		this.fileProgressBar=fileProgressBar;
		this.label=label;
		this.bar=bar;
		this.fileSize=fileSize;
		this.data=data;
		start();
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// progress+=100-(fileSize-data)%100;
			// 파일 전체 크기 : 100% = 현재 읽은 크기 : ?%
			progress+=(100*data)/fileSize*100;
			bar.setValue(progress/100);
			label.setText(progress+"%");
		}
	}
}
