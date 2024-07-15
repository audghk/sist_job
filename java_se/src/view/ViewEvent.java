package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import logAnalyze.LogDataAnalyze;
import logAnalyze.LogFileParsing;

public class ViewEvent extends WindowAdapter implements ActionListener {
	private ViewDesign vd;
    private LogFileParsing logFileParsing;
	
    public ViewEvent(ViewDesign vd, LogFileParsing logFileParsing) {
		this.vd = vd;
        this.logFileParsing = logFileParsing;
	}//ViewEvent

	@Override
	public void windowClosing(WindowEvent we) {
		vd.dispose();
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vd.getJbtnResult()) {
            String startLine = vd.getJtfStart().getText();
            String endLine = vd.getJtfLast().getText();
            if (startLine.length() == 0 && endLine.length() == 0) {
                vd.getJtaResult().setText(resultMessage(logFileParsing.getLogDataAnalyze()));
            } else {
                try {
                    logFileParsing.customizedParsing(Integer.parseInt(startLine), Integer.parseInt(endLine));
                    vd.getJtaResult().setText(resultMessage(logFileParsing.getCustomAnalyze()));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(vd, "시작라인 혹은 끝 라인의 입력이 유효하지 않습니다.");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(vd, e.getMessage());
                }
            }

            vd.getJtfStart().setText("");
            vd.getJtfLast().setText("");
        } // end if
    }

    public String resultMessage(LogDataAnalyze logDataAnalyze) {
        String maxCountKey = logDataAnalyze.getMaxCountKey();
        StringBuilder outputFileStr = new StringBuilder();
        outputFileStr.append("1. 최다 사용 키 : " + maxCountKey + " " + logDataAnalyze.getKeyCount(maxCountKey) + "회\n\n");
        outputFileStr.append("2. 브라우저별 접속 횟수, 비율\n");
        outputFileStr.append(logDataAnalyze.getBrowserData() + "\n");
        outputFileStr.append("3. 서비스를 성공적으로 수행한(200) 횟수, 실패(404) 횟수\n");
        outputFileStr.append("200 - " + logDataAnalyze.getRespCodeCount("200") + "회\n");
        outputFileStr.append("404 - " + logDataAnalyze.getRespCodeCount("404") + "회\n");
        outputFileStr.append("4. 요청이 가장 많은 시간\n");
        outputFileStr.append(logDataAnalyze.getMaxCountTime() + "시\n");
        outputFileStr.append("5. 비정상적인 요청(403)이 발생한 횟수, 비율구하기\n");
        outputFileStr.append("403 - " + logDataAnalyze.getRespCodeCount("403") + "회\n");
        outputFileStr.append("6. books에 대한 요청 URL중 에러(500)가 발생한 횟수, 비율 구하기\n");
        outputFileStr.append(logDataAnalyze.getURLRespData("books", 500) + "회\n");

        return outputFileStr.toString();
    }
}

