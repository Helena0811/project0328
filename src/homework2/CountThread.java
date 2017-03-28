// 2개의 label count 속도를 하나의 thread로 제어
package homework2;

import javax.swing.JLabel;

public class CountThread extends Thread{
	JLabel label;
	int interval;
	int count;
	
	public CountThread(JLabel label, int interval) {
		this.label=label;
		this.interval=interval;
		this.start();
	}
	
	@Override
	public void run() {
		// 특정 라벨의 값을 1씩 증가시키되, 지정한 속도대로
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
