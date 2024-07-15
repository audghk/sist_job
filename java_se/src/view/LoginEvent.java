package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import logAnalyze.LogFileParsing;

public class LoginEvent extends WindowAdapter implements ActionListener {
    private LoginDesign ld;
    private LogFileParsing logFileParsing;
    private Map<String, String> logIdPw;

    public LoginEvent(LoginDesign ld, LogFileParsing logFileParsing) {
        this.ld = ld;
        this.logFileParsing = logFileParsing;
    }// LoginEvent

    @Override
    public void windowClosing(WindowEvent we) {
        ld.dispose();
    }// windowClosing

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ld.getJbtnLogin()) {
            // 로그인
            logIdPw = new HashMap<String, String>();

            logIdPw.put("admin", "1234");
            logIdPw.put("root", "1111");
            logIdPw.put("administrator", "1234");

            String id = ld.getJtfID().getText();
            String pw = String.valueOf(ld.getJpfPW().getPassword());

            if (id.length() != 0 && pw.length() != 0) {
                String correctPw = logIdPw.get(id);

                if (correctPw != null && pw.equals(correctPw)) {
                    new SelectDesign(logFileParsing, ld);
                    ld.dispose();
                } else {
                    JOptionPane.showMessageDialog(ld, "로그인 실패");
                    ld.getJtfID().setText("");
                    ld.getJpfPW().setText("");
                    ld.getJtfID().requestFocus();
                } // else
            } else {
                JOptionPane.showMessageDialog(ld, "아이디와 비밀번호를 확인해주세요.");
                if (id.isEmpty()) {
                    ld.getJtfID().requestFocus();
                } // end if
                if (!id.isEmpty() && pw.isEmpty()) {
                    ld.getJpfPW().requestFocus();
                } // end if
            }
        } // end if
    }// actionPerformed

    public Map<String, String> getLogIdPw() {
        return logIdPw;
    }

    public void setLogIdPw(Map<String, String> logIdPw) {
        this.logIdPw = logIdPw;
    }
}
