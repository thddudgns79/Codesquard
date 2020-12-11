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
		board[2][2] = 'B'; // 초기 상태 
	}

	public static String push(String input, boolean direction) { // 입력된 방향대로 미는 동작 수행
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < input.length(); i++)
			q.add(input.charAt(i));

		q.add(q.remove()); // 미는 방향이 왼쪽 = 큐에서 1번만 빼기
		if (!direction) // 미는 방향이 반대 = 큐에서 2번 빼기
			q.add(q.remove());

		String result = "";
		while (!q.isEmpty())
			result += q.remove(); // 문자열에 결과값을 담아 반환
		return result;
	}

}