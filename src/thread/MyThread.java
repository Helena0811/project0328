/*
 * 동시 수행하고 싶은 코드는 개발자가 결정해야 하기 때문에 쓰레드 재정의 필요
 * */
package thread;

public class MyThread extends Thread{
	/*
	 * 개발자는 독립적으로 수행하고 싶은 코드를 쓰레드의 run 메소드 안에 작성하면 됨
	*/
	public void run() {
		
		while(true){
			System.out.println("★");
			try {
				// 다른 쓰레드와 엉킬 수 있으므로 try-catch문 사용
				Thread.sleep(1000);	// 1초 동안 non runnable 상태에 있다가 runnable로 복귀
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//System.out.println("★");
		
	}
}
