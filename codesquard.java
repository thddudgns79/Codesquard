import java.util.*;
public class codesquard {
	static Scanner sc = new Scanner(System.in);
	static String str; // 문자열 
	static int cnt; // 숫자
	static char dir; // 방향 : 왼쪽 or 오른쪽 
	
	public static void main(String[] args) {
		input();

	}

	public static void input() {
		System.out.print("> ");
		String str = sc.next();
		int cnt = sc.nextInt();
		char dir = sc.next().charAt(0);
	}
	
}
