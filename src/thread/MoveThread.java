/*
 * �����̴� ������ ������ Thread
 * */
package thread;

public class MoveThread extends Thread{
	// AniMain Ŭ������ move() �޼ҵ带 �޾ƿ;� �ϱ� ������ has a ����� �ޱ�
	// AniMain Ŭ������ �����ڷ� �޾ƿ���(�޼ҵ� ���� �ʿ� ����)
	AniMain aniMain;
	
	public MoveThread(AniMain aniMain) {
		this.aniMain=aniMain;
	}
	
	// �����ڴ� ���� ������ �ڵ带 run�� ����!!!
	// -> JVM�� ���� �ۼ��� run()�� �˾Ƽ� ȣ������	
	public void run() {
		// AniMain Ŭ������ move() �޼ҵ�� ������ �ʰ� ��� ȣ��Ǿ�� ��
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
