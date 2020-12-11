import java.util.*;

public class codesquard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[3][3];
		board[0][0] = 'R';
		board[0][1] = 'R';
		board[0][2] = 'W';
		board[1][0] = 'G';
		board[1][1] = 'C';
		board[1][2] = 'W';
		board[2][0] = 'G';
		board[2][1] = 'B';
		board[2][2] = 'B'; // �ʱ� ���� 
	}

	public static String push(String input, boolean direction) { // �Էµ� ������ �̴� ���� ����
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < input.length(); i++)
			q.add(input.charAt(i));

		q.add(q.remove()); // �̴� ������ ���� = ť���� 1���� ����
		if (!direction) // �̴� ������ �ݴ� = ť���� 2�� ����
			q.add(q.remove());

		String result = "";
		while (!q.isEmpty())
			result += q.remove(); // ���ڿ��� ������� ��� ��ȯ
		return result;
	}

}