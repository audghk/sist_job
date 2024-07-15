package day0103;

/**
 * 제시된 요금표를 사용하여 아래 출력 코드를 작성.
 * 
 *  -대중교통 수단과 이동거리를 입력 받아 처리하는 프로그램을 제작.
 *  
 *  -입력한 대중 교통 수단이 "마을버스", "버스", "지하철"인 경우에만 아래의 출력형식으로 출력하고,
 *   그렇지 않다면 "대중교통 수단이 아닙니다."를 출력.
 *  
 *  출력형식)
 *  입력하신 교통수단은 [args]이고, 이동거리는 [args]Km입니다. (10km까지는 기본요금으로 처리되지만 초과하면 5km마다 100원 추가)
 *  교통수단의 기본요금 : [마을버스:1200,버스:1500,지하철:1400]원, 편도요금 : [ㅇㅇ]원, 왕복요금 : [ㅇㅇ]원,
 *  한달 20일 기준 총 교통 요금은 [ㅇㅇ]원 입니다.
 *  
 *  코딩이 완료되면 flowchart를 그려보세요.
 */
public class Exam0103 {
	
	public static final int TOWN_BUS=1200;
	public static final int BUS=1500;
	public static final int SUBWAY=1400;

	public static void main(String[] args) {

		int distance = 0, fee = 0;
		
		if("마을버스".equals(args[0]) || "버스".equals(args[0]) || "지하철".equals(args[0])) {//교통수단이 아닐때도 작동하는것을 방지
			if(Integer.parseInt(args[1]) > 10) {
				distance = (Integer.parseInt(args[1]) - 10) / 5;
				fee = distance * 100;
			}
		}//
		
		
		if("마을버스".equals(args[0])) {
			int town_bus_fee=Exam0103.TOWN_BUS + fee;
			System.out.println("입력하신 교통수단은 " + args[0] + "이고, 이동거리는 " + args[1] + "km입니다.");
			System.out.println("교통 수단의 기본 요금 : " + Exam0103.TOWN_BUS + "원");
			System.out.println("편도 요금 : " + town_bus_fee + "원" + ", 왕복 요금 : " + (town_bus_fee * 2) + "원");
			System.out.println("한달 20일 기준 총 요금은 " + (town_bus_fee * 40) + "원 입니다.");
		}else if("버스".equals(args[0])) {
			int bus_fee=Exam0103.BUS + fee;
			System.out.println("입력하신 교통수단은 " + args[0] + "이고, 이동거리는 " + args[1] + "km입니다.");
			System.out.println("교통 수단의 기본 요금 : " + Exam0103.BUS + "원");
			System.out.println("편도 요금 : " + bus_fee + "원" + ", 왕복 요금 : " + (bus_fee * 2) + "원");
			System.out.println("한달 20일 기준 총 요금은 " + (bus_fee * 40) + "원 입니다.");
		}else if("지하철".equals(args[0])) {
			int subway_fee=Exam0103.SUBWAY + fee;
			System.out.println("입력하신 교통수단은 " + args[0] + "이고, 이동거리는 " + args[1] + "km입니다.");
			System.out.println("교통 수단의 기본 요금 : " + Exam0103.SUBWAY + "원");
			System.out.println("편도 요금 : " + subway_fee + "원" + ", 왕복 요금 : " + (subway_fee * 2) + "원");
			System.out.println("한달 20일 기준 총 요금은 " + (subway_fee * 40) + "원 입니다.");
		}else {
			System.out.println("교통수단이 아닙니다.");
		}
	}

}
