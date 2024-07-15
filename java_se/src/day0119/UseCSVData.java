package day0119;

import java.util.StringTokenizer;

public class UseCSVData {

	public CSVData csvData() {
		CSVData csvD=null;
		String csbData="고한별,김도원,김동섭.김무영~김현종 박시현,손지민,김병년.김일신";
		StringTokenizer stk=new StringTokenizer(csbData,",. ~김");
		
		int tokenCnt=stk.countTokens();
		String[] temp=new String[tokenCnt];
		
		int i=0;
		while(stk.hasMoreTokens()) {
			temp[i]=stk.nextToken();
			i++;
		}
		
		csvD=new CSVData(temp);
		
		return csvD;
	}
	
	public void useCsvData() {
		CSVData csvD=csvData();
		
		String[] temp=csvD.getData();
		for(String value : temp) {
			System.out.println(value);
		}
	}
	
	
	public static void main(String[] args) {

		UseCSVData ucd=new UseCSVData();
		ucd.useCsvData();
		
	}

}
