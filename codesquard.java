import java.util.*;
public class codesquard {
	static Scanner sc = new Scanner(System.in);
	static String str; // ���ڿ� 
	static int cnt; // ����
	static char dir; // ���� : ���� or ������ 
	
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
