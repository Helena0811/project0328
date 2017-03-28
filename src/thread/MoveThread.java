/*
 * 움직이는 로직을 가지는 Thread
 * */
package thread;

public class MoveThread extends Thread{
	// AniMain 클래스의 move() 메소드를 받아와야 하기 때문에 has a 관계로 받기
	// AniMain 클래스의 생성자로 받아오기(메소드 굳이 필요 없음)
	AniMain aniMain;
	
	public MoveThread(AniMain aniMain) {
		this.aniMain=aniMain;
	}
	
	// 개발자는 독립 실행할 코드를 run에 기재!!!
	// -> JVM이 현재 작성한 run()을 알아서 호출해줌	
	public void run() {
		// AniMain 클래스의 move() 메소드는 끝나지 않고 계속 호출되어야 함
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aniMain.move();
		}
	}
}
