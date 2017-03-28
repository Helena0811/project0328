package count;

public class CountThread2 extends Thread{
	CountTest countTest;
	int interval;
	int count=0;
	
	public CountThread2(CountTest countTest, int interval) {
		this.countTest=countTest;
		this.interval=interval;
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
			countTest.lb_right.setText(Integer.toString(count));
		}
	}
}
