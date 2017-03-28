/*
 * 선택한 파일의 복사 과정 진행률 표시 구현
 * */
package streamthread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class FileProgressBar extends JFrame implements ActionListener{
	JProgressBar bar;
	JButton bt_open, bt_save, bt_copy;
	JTextField txt_open, txt_save;
	JLabel percent;
	
	FileInputStream fis;
	FileOutputStream fos;
	JFileChooser chooser;
	
	String oriPath, savePath;
	long fileSize=0;
	int pc=0;
	
	public FileProgressBar() {
		// 파일 복사 진행률 표시할 bar 생성 및 크기 조정
		bar=new JProgressBar();
		bar.setPreferredSize(new Dimension(350, 40));
		
		percent=new JLabel(pc+"%");
		
		bt_open=new JButton("열기");
		bt_save=new JButton("저장");
		bt_copy=new JButton("복사");
		
		txt_open=new JTextField("",30);
		txt_save=new JTextField("",30);
		
		add(bar);
		add(bt_open);
		add(txt_open);
		add(bt_save);
		add(txt_save);
		add(bt_copy);
		
		chooser=new JFileChooser("C:/java_workspace2/project0323");
		
		// 각 버튼과 리스너 연결
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);
		
		setLayout(new FlowLayout());
		setSize(450, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// 버튼 이벤트 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton btn=(JButton)obj;
		
		if(btn==bt_open){
			open();
		}
		else if(btn==bt_save){
			//System.out.println(state);
			int state=chooser.showSaveDialog(this);
			
			// 상수는 영어 단어를 이용해 직관성 부여 가능
			if(state == JFileChooser.APPROVE_OPTION){
				save();
				//copy();
			}
		}
		else if(btn==bt_copy){
			copy();
			percent.setText(pc+"%");
		}
	}
	
	public void getPercent(int data, long fileSize){
		pc=(100*data/fileSize);
	}
	
	// 복사할 파일 선택
	public void open(){
		// 탐색기 열기
		int state=chooser.showOpenDialog(FileProgressBar.this);
		
		if(state==JFileChooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			oriPath=file.getAbsolutePath();
			//System.out.println(oriPath);
			txt_open.setText(oriPath);
			fileSize=file.length();
		}
	}
	
	// 복사할 경로 지정
	public void save(){
		// 탐색기 열기
		//int state=chooser.showSaveDialog(FileProgressBar.this);
		
		File file=chooser.getSelectedFile();
		savePath=file.getAbsolutePath();
		System.out.println(savePath);
		txt_save.setText(savePath);

	}
	
	// 복사
	public void copy(){
		// 복사 
		// 먼저 파일을 읽어오고(입력 스트림)
		try {
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(savePath);
			
			int data=-1;			// 처음에는 읽어올 상태X
			
			while(true){
				data=fis.read();	// 파일을 1byte씩 읽어서 data에 저장
				if(data==-1){		// 만약 읽어올 파일에 데이터가 없다면
					break;
				}
				// 파일을 복사(출력 스트림)
				// 읽어올 파일에 데이터가 있는 경우에만 복사
				fos.write(data);
				System.out.println(data);
				
				// progress bar에 복사 진행률 반영
				ProgressThread thread=new ProgressThread(bar, fileSize, data);
				
			}
			JOptionPane.showMessageDialog(this, "복사 완료");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "IO 처리 중 에러가 발생했습니다.");
			e.printStackTrace();
		} finally{
			// 모든 작업이 종료된 경우에는 스트림 제거
			try {
				// fos나 fis가 null인 상태에서 close()하면 nullPointer 에러 발생
				// 따라서, 반드시 fos와 fis가 작동하고 있는 상태(메모리에 올라가 있는 상태)에서 제거해야 함
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new FileProgressBar();

	}

}
