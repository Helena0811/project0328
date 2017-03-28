/*
 * ������ ������ ���� ���� ����� ǥ�� ����
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
		// ���� ���� ����� ǥ���� bar ���� �� ũ�� ����
		bar=new JProgressBar();
		bar.setPreferredSize(new Dimension(350, 40));
		
		percent=new JLabel(pc+"%");
		
		bt_open=new JButton("����");
		bt_save=new JButton("����");
		bt_copy=new JButton("����");
		
		txt_open=new JTextField("",30);
		txt_save=new JTextField("",30);
		
		add(bar);
		add(bt_open);
		add(txt_open);
		add(bt_save);
		add(txt_save);
		add(bt_copy);
		
		chooser=new JFileChooser("C:/java_workspace2/project0323");
		
		// �� ��ư�� ������ ����
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);
		
		setLayout(new FlowLayout());
		setSize(450, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// ��ư �̺�Ʈ ����
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
			
			// ����� ���� �ܾ �̿��� ������ �ο� ����
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
	
	// ������ ���� ����
	public void open(){
		// Ž���� ����
		int state=chooser.showOpenDialog(FileProgressBar.this);
		
		if(state==JFileChooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			oriPath=file.getAbsolutePath();
			//System.out.println(oriPath);
			txt_open.setText(oriPath);
			fileSize=file.length();
		}
	}
	
	// ������ ��� ����
	public void save(){
		// Ž���� ����
		//int state=chooser.showSaveDialog(FileProgressBar.this);
		
		File file=chooser.getSelectedFile();
		savePath=file.getAbsolutePath();
		System.out.println(savePath);
		txt_save.setText(savePath);

	}
	
	// ����
	public void copy(){
		// ���� 
		// ���� ������ �о����(�Է� ��Ʈ��)
		try {
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(savePath);
			
			int data=-1;			// ó������ �о�� ����X
			
			while(true){
				data=fis.read();	// ������ 1byte�� �о data�� ����
				if(data==-1){		// ���� �о�� ���Ͽ� �����Ͱ� ���ٸ�
					break;
				}
				// ������ ����(��� ��Ʈ��)
				// �о�� ���Ͽ� �����Ͱ� �ִ� ��쿡�� ����
				fos.write(data);
				System.out.println(data);
				
				// progress bar�� ���� ����� �ݿ�
				ProgressThread thread=new ProgressThread(bar, fileSize, data);
				
			}
			JOptionPane.showMessageDialog(this, "���� �Ϸ�");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "IO ó�� �� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		} finally{
			// ��� �۾��� ����� ��쿡�� ��Ʈ�� ����
			try {
				// fos�� fis�� null�� ���¿��� close()�ϸ� nullPointer ���� �߻�
				// ����, �ݵ�� fos�� fis�� �۵��ϰ� �ִ� ����(�޸𸮿� �ö� �ִ� ����)���� �����ؾ� ��
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
