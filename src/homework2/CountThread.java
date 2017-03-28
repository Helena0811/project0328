// 2���� label count �ӵ��� �ϳ��� thread�� ����
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
		// Ư�� ���� ���� 1�� ������Ű��, ������ �ӵ����
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
