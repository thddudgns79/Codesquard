import java.util.*;
public class codesquard {
	static Scanner sc = new Scanner(System.in);
	static String str; // ���ڿ� 
	static int cnt; // ����
	static char dir; // ���� : ���� or ������ 
	static LinkedList<Character> deque = new LinkedList<Character>();
	
	public static void main(String[] args) {
		input();

	}

	public static void input() { // �Է� ó�� 
		System.out.print("> ");
		str = sc.next();
		cnt = sc.nextInt();
		dir = sc.next().charAt(0);
		for(int i = 0; i < str.length(); i++)
			deque.add(str.charAt(i));
	}
	
	public static void pushLeft() { // �������� 1�� �б�
		deque.addLast(deque.removeFirst());
	}

	public static void pushRight() { //���������� 1�� �б�
		deque.addFirst(deque.removeLast());
	}
	

}
