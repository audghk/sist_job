package day0205;

import java.io.File;

import javax.swing.JOptionPane;

/**
 * 파일 삭제
 */
public class UseFile3 {

	public static void main(String[] args) {

//		//1. 삭제할 파일명을 가진 File객체를 생성
//		File file=new File("c:/dev/temp/java_read2.txt");
//		//2. 삭제
//		System.out.println(file.delete());
		
		//1. 이전 이름을 가진 File객체 생성
		File file=new File("c:/dev/temp/java_read2.txt");
		//2. 변경할 파일명을 저장한 객체 생성
		File file2=new File("c:/dev/temp/lmh.txt");
		//3. 변경
//		file.renameTo(file2);	
		System.out.println(file.renameTo(file2));
		
		//삭제할 파일의 경로와 파일명을 받는다
		//해당 파일이 존재한다면 ConfirmDialog를 사용하여 "정말 삭제?" 물어본 후 "예"가 눌리면 삭제한다.		
//		if(file.exists()) {
//			int flag=JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?");
//			switch(flag) {
//			case JOptionPane.OK_OPTION:
//				file.delete();
//				JOptionPane.showMessageDialog(null, "파일을 삭제했습니다.");
//				break;
//			case JOptionPane.NO_OPTION:
//				JOptionPane.showMessageDialog(null, "네");
//			}
//		}

		String path=JOptionPane.showInputDialog("삭제할 파일명을 입력", "c:/dev/temp/lmh.txt");
		File removeFile=new File(path);
		
		if(!removeFile.exists()) {
			JOptionPane.showMessageDialog(null, removeFile+"은 존재하지 않습니다. 파일 경로나 파일명을 확인해주세요.");
			return;
		}
		switch(JOptionPane.showConfirmDialog(null, removeFile.getName()+"파일을 삭제하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			removeFile.delete();
			JOptionPane.showMessageDialog(null, removeFile+"파일이 삭제되었습니다.");
		}
		
		
	}

}
