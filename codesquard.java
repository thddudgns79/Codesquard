import java.util.*;

public class codesquard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[3][3];
		boardSetting(board); // 큐브의 초기 상태 세팅
		print(board); // 초기 상태 출력
		input(board); // 커맨드 입력 및 처리
	}

	public static void push(char[][] board, boolean direction, char location) { // 입력된 방향대로 미는 동작 수행
		Queue<Character> q = new LinkedList<Character>();
		if (location == 'U') {
			for (int i = 0; i < 3; i++) // 해당 문자 순서대로 큐에 담기
				q.add(board[0][i]);

			q.add(q.remove()); // 뒤로 한 번 밀기
			if (!direction) // 역방향일 경우 뒤로 두 번 밀기
				q.add(q.remove());

			for (int i = 0; i < 3; i++) // 큐에 담은 순서대로 보드에 값 갱신하기
				board[0][i] = q.remove();
		}
		if (location == 'R') {
			for (int i = 0; i < 3; i++)
				q.add(board[i][2]);

			q.add(q.remove());
			if (!direction)
				q.add(q.remove());

			for (int i = 0; i < 3; i++)
				board[i][2] = q.remove();
		}
		if (location == 'L') {
			for (int i = 2; i >= 0; i--)
				q.add(board[i][0]);

			q.add(q.remove());
			if (!direction)
				q.add(q.remove());

			for (int i = 2; i >= 0; i--)
				board[i][0] = q.remove();
		}
		if (location == 'B') {
			for (int i = 2; i >= 0; i--)
				q.add(board[2][i]);

			q.add(q.remove());
			if (!direction)
				q.add(q.remove());

			for (int i = 2; i >= 0; i--)
				board[2][i] = q.remove();
		}

	}

	public static void boardSetting(char[][] board) { // 초기 큐브 상태 입력
		board[0][0] = 'R';
		board[0][1] = 'R';
		board[0][2] = 'W';
		board[1][0] = 'G';
		board[1][1] = 'C';
		board[1][2] = 'W';
		board[2][0] = 'G';
		board[2][1] = 'B';
		board[2][2] = 'B';
	}

	public static void print(char[][] board) { // 현재 큐브 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	public static void input(char[][] board) { // 커맨드 입력 및 처리
		while (true) {
			System.out.print("CUBE> ");
			String commands = sc.next();
			if (commands.equals("Q")) {
				System.out.println("Bye~");
				break;
			}
			int idx = 0;
			int n = commands.length();
			while (idx < n) { // 커맨드 문자열의 인덱스를 하나하나씩 탐색 
				if (idx + 1 < n && commands.charAt(idx + 1) == '\'') { // 역방향
					if (commands.charAt(idx) == 'U')
						Ub(board);

					if (commands.charAt(idx) == 'R')
						Rb(board);

					if (commands.charAt(idx) == 'L')
						Lb(board);

					if (commands.charAt(idx) == 'B')
						Bb(board);

					idx += 2;
				}

				else { // 정방향
					if (commands.charAt(idx) == 'U')
						U(board);

					if (commands.charAt(idx) == 'R')
						R(board);

					if (commands.charAt(idx) == 'L')
						L(board);

					if (commands.charAt(idx) == 'B')
						B(board);

					idx++;
				}
			}
		}
	}

	public static void U(char[][] board) { // U 조작에 대한 push 수행 
		push(board, true, 'U');
		System.out.println("U");
		print(board);
	}

	public static void R(char[][] board) { // R 조작에 대한 push 수행 
		push(board, true, 'R');
		System.out.println("R");
		print(board);
	}

	public static void L(char[][] board) { // L 조작에 대한 push 수행 
		push(board, true, 'L');
		System.out.println("L");
		print(board);
	}

	public static void B(char[][] board) { // B 조작에 대한 push 수행 
		push(board, true, 'B');
		System.out.println("B");
		print(board);
	}

	public static void Ub(char[][] board) { // U' 조작에 대한 push 수행 
		push(board, false, 'U');
		System.out.println("U'");
		print(board);
	}

	public static void Rb(char[][] board) { // R' 조작에 대한 push 수행 
		push(board, false, 'R');
		System.out.println("R'");
		print(board);
	}

	public static void Lb(char[][] board) { // L' 조작에 대한 push 수행 
		push(board, false, 'L');
		System.out.println("L'");
		print(board);
	}

	public static void Bb(char[][] board) { // B' 조작에 대한 push 수행 
		push(board, false, 'B');
		System.out.println("B'");
		print(board);
	}

}