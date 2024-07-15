package day0124;

import java.util.List;
import java.util.Stack;

/**
 * LIFO
 */
public class UseStack {
	
	public UseStack() {
		//1. 생성) is a 관계의 객체화는 하지 않는다.
//		List<String> list=new Stack<String>();
		Stack<String> stk=new Stack<String>();
		
		//2. 값 할당) - item
//		stk.add("입니다.");//부모의 method를 사용하지 않는다.
		stk.push("입니다");
		stk.push("오늘은");
		stk.push("수요일");
		
		//3. 값 얻기) - pop() - 얻어낸 item은 사라짐(stack에서 빠짐)
		System.out.println(!stk.empty());//없지 않니?
//		while(!stk.empty()) {//스택에 아이템이 존재하지 않으면 반복하지 않는다.
//			System.out.println(stk.pop());
//		}
//		for(String value : stk) {
//			System.out.println(value);
//		}
		for(int i=0; i<stk.size(); i++) {//부모의 method를 사용하지 않는다.
			System.out.println(stk.get(i));
		}
		System.out.println(stk.empty());//없니?
		
		
	}

	public static void main(String[] args) {

		new UseStack();
		
	}

}
