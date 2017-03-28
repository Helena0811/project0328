package streamthread;

import javax.swing.JProgressBar;

public class ProgressThread extends Thread{
	FileProgressBar fileProgressBar;
	JProgressBar bar;
	long fileSize;
	int data;
	long progress;
	
	public ProgressThread(JProgressBar bar, long fileSize, int data) {
		this.fileProgressBar=fileProgressBar;
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
			// ���� ��ü ũ�� : 100% = ���� ���� ũ�� : ?%
			progress=(100*data/fileSize);
			bar.setValue((int)progress);
		}
	}
}
