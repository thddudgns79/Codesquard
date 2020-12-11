import java.util.*;
public class codesquard {
	static Scanner sc = new Scanner(System.in);
	static String str; // 문자열 
	static int cnt; // 숫자
	static char dir; // 방향 : 왼쪽 or 오른쪽 
	static LinkedList<Character> deque = new LinkedList<Character>();
	
	public static void main(String[] args) {
		input();

	}

	public static void input() { // 입력 처리 
		System.out.print("> ");
		str = sc.next();
		cnt = sc.nextInt();
		dir = sc.next().charAt(0);
		for(int i = 0; i < str.length(); i++)
			deque.add(str.charAt(i));
	}
	
	public static void pushLeft() { // 왼쪽으로 1번 밀기
		deque.addLast(deque.removeFirst());
	}

	public static void pushRight() { //오른쪽으로 1번 밀기
		deque.addFirst(deque.removeLast());
	}
	

}
