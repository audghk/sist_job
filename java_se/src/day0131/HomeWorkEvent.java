package day0131;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HomeWorkEvent extends WindowAdapter implements MouseListener, ActionListener {

  private HomeWorkDesign hwd;



  public HomeWorkEvent(HomeWorkDesign hwd) {
    this.hwd = hwd;
  }


  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == hwd.getAddButon()) {
      // System.out.println("추가버튼 눌림");
      addMember();
    }
    if (ae.getSource() == hwd.getChangeButon()) {
      // System.out.println("변경버튼 눌림");
      modifyMember();
    }
    if (ae.getSource() == hwd.getDeleteButon()) {
      // System.out.println("삭제버튼 눌림");
      removeMember();
    }
    if (ae.getSource() == hwd.getEndButon()) {
      // System.out.println("종료버튼 눌림");
      closeWin();
    }

  }

  @Override
  public void windowClosing(WindowEvent we) {
    hwd.dispose();
  }

  // private void addData() {
  // StringBuilder sb1 = new StringBuilder();
  // JTextField jtfName = hwd.getJtfName();
  // DefaultComboBoxModel<String> age = hwd.getAge();
  // JTextField jtfCallNum = hwd.getJftCallNum();
  // JRadioButton jtfMan = hwd.getMan();
  // JRadioButton jtfWman = hwd.getWman();
  //
  // String name = jtfName.getText();
  // String callNum = jtfCallNum.getText();
  //
  // if(!name.isEmpty() && !callNum.isEmpty()) {
  //
  // sb1.append(name).append(",").append(age.getSelectedItem());
  //
  // if(jtfMan.isSelected()) {
  // sb1.append(",").append(jtfMan.getText());
  //
  // }else {
  // sb1.append(",").append(jtfWman.getText());
  // }
  //
  // sb1.append(",").append(callNum);
  //
  // hwd.getDlmData().addElement(sb1.toString());
  // jtfName.setText("");
  // jtfCallNum.setText("");
  // jtfName.requestFocus();
  //
  // }
  //
  //
  //
  // }
  //
  // @SuppressWarnings("unlikely-arg-type")
  // private void changeData() {
  //
  // StringBuilder sb1 = new StringBuilder();
  // JTextField jtfName = hwd.getJtfName();
  // DefaultComboBoxModel<String> age = hwd.getAge();
  // JTextField jtfCallNum = hwd.getJftCallNum();
  // JRadioButton jtfMan = hwd.getMan();
  // JRadioButton jtfWman = hwd.getWman();
  //
  //
  // DefaultListModel<String> dlmData = hwd.getDlmData();
  // List<String> list = new ArrayList<String>();
  //
  // for (int i =0; i<dlmData.size(); i++) {
  // String stName =
  // dlmData.elementAt(i).substring(0,dlmData.elementAt(i).indexOf(","));
  //
  // if(jtfName.getText().equals(stName)) {
  // dlmData.remove(i);
  //
  // sb1.append(jtfName.getText()).append(",").append(age.getSelectedItem());
  //
  // if(jtfMan.isSelected()) {
  // sb1.append(",").append(jtfMan.getText());
  //
  // }else {
  // sb1.append(",").append(jtfWman.getText());
  // }
  //
  // sb1.append(",").append(jtfCallNum.getText());
  //
  // hwd.getDlmData().addElement(sb1.toString());
  // jtfName.setText("");
  // jtfCallNum.setText("");
  // jtfName.requestFocus();
  //
  // }
  // }
  //
  // }
  //
  // private void deleteData() {
  // DefaultListModel<String> dlmData = hwd.getDlmData();
  // dlmData.removeAllElements();
  //
  // }
  //
  // private void endOver() {
  //
  // }


  @Override
  public void mouseClicked(MouseEvent e) {
    // 리스트에 있던거를 다시 반대로 옮기기
    // JTextField jtfName=hwd.getJtfName();
    // DefaultListModel<String> dlmData=hwd.getDlmData();
    //
    // String name=jtfName.getText().trim();
    //
    // Object[] obj = new Object[dlmData.size()];// 배열 생성
    // obj = dlmData.toArray();// 모든 값을 배열로 복사
    // String item="";
    // //리스트의 모든 값을 삭제하고
    // dlmData.removeAllElements();
    // for (int i = 0; i < obj.length; i++) {
    // item=(String)obj[i];
    // if(!item.startsWith(name)) {//이름으로 시작하지 않는 값만 설정한다.
    // dlmData.addElement(item);
    // }
    // }



  }


  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

  }


  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }


  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }


  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }


  @Override
  public void windowActivated(WindowEvent e) {
    hwd.getJtfName().requestFocus();// 프로그램 시작시 커서위치를 이름으로 설정
  }


  private void addMember() {// 추가

    JTextField jtfName = hwd.getJtfName();
    JTextField jtfCallNum = hwd.getJftCallNum();
    JRadioButton jrbMan = hwd.getMan();
    JRadioButton jrbWman = hwd.getWman();
    JComboBox<String> jcbAge = hwd.getJcbAge();
    DefaultComboBoxModel<String> age = hwd.getAge();
    DefaultListModel<String> dlmData = hwd.getDlmData();

    // 유효성 검증
    String name = jtfName.getText().trim();
    if (name.isEmpty()) {
      JOptionPane.showMessageDialog(hwd, "이름은 필수 입력입니다.");
      jtfName.requestFocus();
      return;
    }

    // MVC Pattern 도입된 컴포넌트
    String selectedAge = age.getElementAt(jcbAge.getSelectedIndex());

    String gender = "";
    if (jrbMan.isSelected()) {
      gender = jrbMan.getText();
    }
    if (jrbWman.isSelected()) {
      gender = jrbWman.getText();
    }

    String tel = jtfCallNum.getText().trim();

    // 유효성 검증 성공 후 데이터를 채우는 일
    StringBuilder sbSetData = new StringBuilder();
    sbSetData.append(name).append(",");
    sbSetData.append(selectedAge).append(",");
    sbSetData.append(gender).append(",");
    sbSetData.append(tel);

    // JList에 설정
    dlmData.addElement(sbSetData.toString());

    // 컴포넌트를 초기화
    jtfName.setText("");
    jtfCallNum.setText("");
    jrbWman.setSelected(true);
    jcbAge.setSelectedIndex(0);

    jtfName.requestFocus();
  }// addMember

  private void modifyMember() {// 변경
    // 이름 나이 전화번호를 입력받아 이름과 같은 사람의 나이와 전화번호를 변경
    JTextField jtfName = hwd.getJtfName();
    JTextField jtfCallNum = hwd.getJftCallNum();
    JComboBox<String> jcbAge = hwd.getJcbAge();
    DefaultComboBoxModel<String> age = hwd.getAge();
    DefaultListModel<String> dlmData = hwd.getDlmData();

    // 유효성 검증
    String name = jtfName.getText().trim();
    if (name.isEmpty()) {
      JOptionPane.showMessageDialog(hwd, "이름은 필수 입력입니다.");
      jtfName.requestFocus();
      return;
    }

    // MVC Pattern 도입된 컴포넌트
    String selectedAge = age.getElementAt(jcbAge.getSelectedIndex());
    String tel = jtfCallNum.getText().trim();

    String item = "";
    StringBuilder sbSetData = new StringBuilder();
    String gender = "";

    for (int i = 0; i < dlmData.size(); i++) {
      // 리스트에서 값을 얻어
      item = dlmData.getElementAt(i);
      // 이름이 같은지(시작하니)
      if (item.startsWith(name)) {
        // 시작한다면 ? 입력된 값과 기존의 값을 사용하여 변경한다.
        gender = item.split(",")[2];// 기존의 값
        sbSetData.append(name).append(",").append(selectedAge).append(",").append(gender).append(",").append(tel);

        // 현재 번째에 아이템을 삭제
        dlmData.removeElementAt(i);
        // 현재번째에 변경된 값을 설정한다.
        dlmData.add(i, sbSetData.toString());
      }
    }


  }// modifyMember

  private void removeMember() {// 삭제
    // 입력된 이름에 해당하는 아이템을 JList에서 삭제
    JTextField jtfName = hwd.getJtfName();
    DefaultListModel<String> dlmData = hwd.getDlmData();

    // 유효성 검증
    String name = jtfName.getText().trim();
    if (name.isEmpty()) {
      JOptionPane.showMessageDialog(hwd, "이름은 필수 입력입니다.");
      jtfName.requestFocus();
      return;
    }

    Object[] obj = new Object[dlmData.size()];// 배열 생성
    obj = dlmData.toArray();// 모든 값을 배열로 복사
    String item = "";
    // 리스트의 모든 값을 삭제하고
    dlmData.removeAllElements();
    for (int i = 0; i < obj.length; i++) {
      item = (String) obj[i];
      if (!item.startsWith(name)) {// 이름으로 시작하지 않는 값만 설정한다.
        dlmData.addElement(item);
      }
    }
    // 삭제

  }// removeMember

  private void closeWin() {// 종료
    hwd.dispose();
  }// closeWin



}
