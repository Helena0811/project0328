/*
 * ���� �����ϰ� ���� �ڵ�� �����ڰ� �����ؾ� �ϱ� ������ ������ ������ �ʿ�
 * */
package thread;

public class MyThread extends Thread{
	/*
	 * �����ڴ� ���������� �����ϰ� ���� �ڵ带 �������� run �޼ҵ� �ȿ� �ۼ��ϸ� ��
	*/
	public void run() {
		
		while(true){
			System.out.println("��");
			try {
				// �ٸ� ������� ��ų �� �����Ƿ� try-catch�� ���
				Thread.sleep(1000);	// 1�� ���� non runnable ���¿� �ִٰ� runnable�� ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//System.out.println("��");
		
	}
}
