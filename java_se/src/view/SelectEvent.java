package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import logAnalyze.LogDataAnalyze;
import logAnalyze.LogFileParsing;

public class SelectEvent extends WindowAdapter implements ActionListener {
    private SelectDesign sd;
    private LogFileParsing logFileParsing;
    private LoginDesign ld;

    public SelectEvent(SelectDesign sd, LogFileParsing logFileParsing, LoginDesign ld) {
        this.sd = sd;
        this.logFileParsing = logFileParsing;
        this.ld = ld;
    }// ViewEvent

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sd.getJbtnView()) {
            new ViewDesign(sd, logFileParsing);
        } // end if
        if (ae.getSource() == sd.getJbtnReport()) { // 출력 내용 파일로 저장
            if (ld.getJtfID().getText().trim().equals("root")) {
                JOptionPane.showMessageDialog(sd, "문서를 생성할 수 있는 권한이 없음", "주의", JOptionPane.WARNING_MESSAGE);
            } else {
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMddHHmmss");
                Date time = new Date();

                String today = simpleDate.format(time);
                try {// 현재 시간 구하기
                    Date selectDate = simpleDate.parse(today);
                    GregorianCalendar cal = new GregorianCalendar(Locale.KOREA);
                    cal.setTime(selectDate);
                    today = simpleDate.format(cal.getTime());
                    // System.out.println(today);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // 파일 경로명
                String path = "c:/dev/report";
                File f = new File(path);
                if (!f.exists()) { // 폴더가 없으면
                    f.mkdir(); // 생성
                }

                try {
                    FileOutputStream output = new FileOutputStream("c:/dev/report/report_" + today + ".dat", false);
                    OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
                    BufferedWriter out = new BufferedWriter(writer);

                    out.write(resultMessage(logFileParsing.getLogDataAnalyze()));
                    out.write("========================================================================\n");
                    out.write("1000 - 1500 라인의 데이터 \n");
                    logFileParsing.customizedParsing(1000, 1500);
                    out.write(resultMessage(logFileParsing.getCustomAnalyze()));

                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } // end if
    }// actionPerformed

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

    @Override
    public void windowClosing(WindowEvent we) {
        sd.dispose();
    }
}
