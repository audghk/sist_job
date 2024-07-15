package day0111;

public class SocialSecurityNum {

public String number;

	public SocialSecurityNum(String number) {
		this.number=number;
	}
	
	//2. 14자리 체크
	public boolean numLength(String num) {
		
//		boolean flag = false;
//		if(num.length()==14) {
//			flag=true;
//		}
//		return flag;
		return num.length()==14;
	}
	
	//3. 주민번호의 7번째 인덱스에 - 가 있는지 체크
	public boolean numLineCheck(String num) {
		
//		boolean flag = false;
//		if(num.indexOf("-")==6) {
//			flag=true;
//		}
//		return flag;
		return num.indexOf("-") == 6;
	}
	
	// 2번이랑 3번에서 둘 다 flag를 쓰는데 왜 local 변수일까요?
	// backNum랑 year도 같은 값의 반복인가요? 이건 메서드 분리해도 좋을 것 같아요
	// 띠를 구하는 건 day0103 import하는 걸로...
	
	//4. 생년월일을 연산하여 문자열로 반환@

	public String birth(String num) {

		String num1=num.substring(0, 2);
		String num2=num.substring(2, 4);
		String num3=num.substring(4, num.indexOf("-"));
		
		char backNum=num.charAt(num.indexOf("-")+1);
		String year = null;
//		String[] prevYear= {"18","19","19","20","20","19","19","20","20","18"};
		
		switch(backNum) {
		case '0':
			year="18";
			break;
		case '1':
			year="19";
			break;
		case '2':
			year="19";
			break;
		case '3':
			year="20";
			break;
		case '4':
			year="20";
			break;
		case '5':
			year="19";
			break;
		case '6':
			year="19";
			break;
		case '7':
			year="20";
			break;
		case '8':
			year="20";
			break;
		case '9':
			year="18";
			break;
		}
//		year = prevYear[backNum];
		
		return year+num1+"년 "+num2+"월 "+num3+"일";

	}
	
	//5. 나이를 구해서 정수로 반환@

	public int age(String num) {

		String num1=num.substring(0, 2);
		int num12=Integer.parseInt(num1);
		char backNum=num.charAt(num.indexOf("-")+1);
		int thisYear=2024;
		String year = null;
		
		switch(backNum) {
		case '0':
			year="1800";
			break;
		case '1':
			year="1900";
			break;
		case '2':
			year="1900";
			break;
		case '3':
			year="2000";
			break;
		case '4':
			year="2000";
			break;
		case '5':
			year="1900";
			break;
		case '6':
			year="1900";
			break;
		case '7':
			year="2000";
			break;
		case '8':
			year="2000";
			break;
		case '9':
			year="1800";
			break;
		}
		int year1=Integer.parseInt(year);
		int result=thisYear-(num12+year1);
		
		return result;

	}
	
	//6. 성별을 구해 문자열로 반환

	public String gender(String num) {

		char num1=num.charAt(num.indexOf("-")+1);
		String num12;
		
		if(num1 % 2 == 0){
			num12= "여성";
		}else{
			num12="남성";
		}

		return num12;

	}
	
	//7. 띠를 구해서 문자열로 반환

	public String zodiacSign(String num) {

		String num1=num.substring(0, 2);
//		System.out.println(num1);
		int num12=Integer.parseInt(num1);
//		System.out.println(num12);
		
		char backNum=num.charAt(num.indexOf("-")+1);
		String year = null;
		
		switch(backNum) {
		case '0':
			year="1800";
			break;
		case '1':
			year="1900";
			break;
		case '2':
			year="1900";
			break;
		case '3':
			year="2000";
			break;
		case '4':
			year="2000";
			break;
		case '5':
			year="1900";
			break;
		case '6':
			year="1900";
			break;
		case '7':
			year="2000";
			break;
		case '8':
			year="2000";
			break;
		case '9':
			year="1800";
			break;
		}
		
		int year1=Integer.parseInt(year);
		int result=(num12+year1) % 12;
		
		switch(result){
		case 0:
			num1="원숭이";
			break;
		case 1:
			num1="닭";
			break;
		case 2:
			num1="개";
			break;
		case 3:
			num1="돼지";
			break;
		case 4:
			num1="쥐";
			break;
		case 5:
			num1="소";
			break;
		case 6:
			num1="호랑이";
			break;
		case 7:
			num1="토끼";
			break;
		case 8:
			num1="용";
			break;
		case 9:
			num1="뱀";
			break;
		case 10:
			num1="말";
			break;
		case 11:
			num1="양";
			break;
			
		}
		
		return num1;

	}
	
	public static void main(String[] args) {
		
		String	number="980603-2234567";
//		new SocialSecurityNum();
		SocialSecurityNum ssn=new SocialSecurityNum(number);
		//2
		System.out.println(ssn.numLength(number));
		//3
		System.out.println(ssn.numLineCheck(number));
		//4
		System.out.println(ssn.birth(number));
		//5
		System.out.println(ssn.age(number));
		//6
		System.out.println(ssn.gender(number));
		//7
		System.out.println(ssn.zodiacSign(number));
		
	}

}
