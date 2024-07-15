package day0116;

public class UseStudentInfo2 {

	public static void main(String[] args) {

		StudentInfo2[] si2Arr = null;

		si2Arr = new StudentInfo2[7];
		si2Arr[0] = new StudentInfo2("고한별", "서울시 강남구 역삼동", 25);
		si2Arr[1] = new StudentInfo2("김동수", "경기도 수원시 영통구 영통동", 20);
		si2Arr[2] = new StudentInfo2("김동섭", "서울시 강남구 서초동", 28);
		si2Arr[3] = new StudentInfo2("정명호", "마계서울시 부평구 부평동", 26);
		si2Arr[4] = new StudentInfo2("양수민", "경기도 부천시 부천동", 25);
		si2Arr[5] = new StudentInfo2("진수현", "서울시 동대문구 동대문동", 27);
		si2Arr[6] = new StudentInfo2("수연", "서울시 구로구 구로동", 26);

		// 이름 주소 나이 출력
		StudentInfo2 sVO = null;
		System.out.print("이름\t주소\t나이\t\n");
		for (int i = 0; i < si2Arr.length; i++) {
			sVO = si2Arr[i];
			System.out.printf("%s\t%s\t%d\t\n", sVO.getName(), sVO.getAddr(), sVO.getAge());
		}

		// 이름에 "수"가 들어가는 사람의 수
		int cnt = 0;
		for (int i = 0; i < si2Arr.length; i++) {
			sVO = si2Arr[i];
			if (sVO.getName().contains("수")) {
				cnt++;
			}
		}
		System.out.println("이름에 \"수\"가 들어가는 사람 : " + cnt + "명");

		// 서울시에 살고 있는 사람
		cnt = 0;
		for (int i = 0; i < si2Arr.length; i++) {
			sVO = si2Arr[i];
			if (sVO.getAddr().startsWith("서울")) {
				cnt++;
			}
		}
		System.out.println("서울 사는 사람 : " + cnt + "명");

		// 나이의 합산
		int sum = 0;
		for (int i = 0; i < si2Arr.length; i++) {
			sVO = si2Arr[i];
			sum += sVO.getAge();
		}
		System.out.println("나이의 합산 : " + sum);	
	}//main

}//class
