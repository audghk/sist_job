package day0205;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 숙제 1. InputDialog를 사용하여 경로를 입력받는다. 2. 입력된 문자열에 해당하는 경로가 존재하면 아래와 같이 디렉토리 내 모든
 * 디렉토리와 파일명을 JTA에 출력하는 프로그램을 작성 3. 디렉토리는 크기를 출력하지 않고 파일에 대해서만 byte크기를 출력해주세요.
 */
public class HW0205 {

	public static void main(String[] args) {

		JTextArea jta = new JTextArea(10, 50);
		JScrollPane jsp = new JScrollPane(jta);
		String filePath = "";
		jta.append("이름 수정한날짜 유형 크기\n");

		filePath = JOptionPane.showInputDialog("파일 경로를 입력해주세요.");

		File file = new File(filePath);

		long lastModified = file.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (file.exists()) {
			jta.append(file.getName().substring(0, file.getName().lastIndexOf(".")) + " ");
			jta.append(sdf.format(new Date(lastModified)) + " ");
			jta.append((file.isFile() ? "파일" : "폴더") + " " + file.length() + "byte\n");
			jta.setEditable(false);
			JOptionPane.showMessageDialog(null, jsp);
		} else {
			filePath = "0";
			JOptionPane.showMessageDialog(null, "존재하지 않는 파일입니다.");
		}

	}

}
