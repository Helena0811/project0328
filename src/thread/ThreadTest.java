/*
 * os가 여러 프로세스들을 동시에 수행하면서 관리할 수 있듯(multi-tasking), 
 * 하나의 java 프로그램 내에서 세부적 실행 단위를 만들어 동시에 수행시킬 수 있음 -> 세부적 실행 단위 : 쓰레드
 * Java는 개발자가 정의하지 않아도 이미 기본적으로 제공되는 실행용 쓰레드가 있으며,
 * 이러한 쓰레드를 가리켜 메인 쓰레드라 한다.
 * Java는 쓰레드 기반!
 * */
package thread;

public class ThreadTest {
	// 메인 쓰레드 대신, 개발자가 원하는 사용자 정의 쓰레드를 생성해서 원하는 동시 작업을 수행
	// Thread thread;
	// 재정의한 사용자 정의 쓰레드를 사용
	MyThread thread;
	
	public ThreadTest() {
		// 메인 쓰레드와는 독립적으로 실행될 수 있는 세부 실행 단위 생성
		/*
		 * 쓰레드가 어떤 일을 할 지는 개발자가 결정해야 함 -> 쓰레드 재정의 필요!
		 * 상속받자!!!
		 * */
		// 분신 생성
		thread=new MyThread();
		// thread가 가진 메소드 run을 실행
		// 메인 쓰레드가 수행함 -> 시스템에게 맡기지 않고 일반 메소드화 되어 별도의 실행부를 메인 쓰레드가 실행함
		// thread.run();	
		// 위와 같이 하면 X, run() 직접 호출 못함
		
		thread.start();		// thread 시작, 별도의 실행부는 시스템이 실행함(메인 쓰레드와 사용자 정의 쓰레드인 thread 가 동시에 실행됨)
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("☆");	// 메인의 소속이 아니고, 일반 모니터에 출력하므로 메인과 관련X
		}
	}
	
	public static void main(String[] args) {
		new ThreadTest();
		/*
		 * 출력 결과
		 * 	☆
			★
		 * */
	}

}
