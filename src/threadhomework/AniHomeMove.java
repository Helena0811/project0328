package threadhomework;

public class AniHomeMove extends Thread{
	AniHomework aniHomework;
	AniHomeDraw aniHomeDraw;
	int speed;
	
	public AniHomeMove(AniHomework aniHomework, AniHomeDraw aniHomeDraw, int speed) {
		this.aniHomework=aniHomework;
		this.aniHomeDraw=aniHomeDraw;
		this.speed=speed;
	}

	public void run(int speed) {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aniHomework.move(aniHomeDraw, speed);
		}
	}
}
