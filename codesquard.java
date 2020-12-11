import java.util.*;

public class codesquard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[3][3];
		boardSetting(board); // ť���� �ʱ� ���� ����
		print(board); // �ʱ� ���� ���
		input(board); // Ŀ�ǵ� �Է� �� ó��
	}

	public static void push(char[][] board, boolean direction, char location) { // �Էµ� ������ �̴� ���� ����
		Queue<Character> q = new LinkedList<Character>();
		if (location == 'U') {
			for (int i = 0; i < 3; i++) // �ش� ���� ������� ť�� ���
				q.add(board[0][i]);

			q.add(q.remove()); // �ڷ� �� �� �б�
			if (!direction) // �������� ��� �ڷ� �� �� �б�
				q.add(q.remove());

			for (int i = 0; i < 3; i++) // ť�� ���� ������� ���忡 �� �����ϱ�
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

	public static void boardSetting(char[][] board) { // �ʱ� ť�� ���� �Է�
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

	public static void print(char[][] board) { // ���� ť�� ���
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	public static void input(char[][] board) { // Ŀ�ǵ� �Է� �� ó��
		while (true) {
			System.out.print("CUBE> ");
			String commands = sc.next();
			if (commands.equals("Q")) {
				System.out.println("Bye~");
				break;
			}
			int idx = 0;
			int n = commands.length();
			while (idx < n) { // Ŀ�ǵ� ���ڿ��� �ε����� �ϳ��ϳ��� Ž�� 
				if (idx + 1 < n && commands.charAt(idx + 1) == '\'') { // ������
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

				else { // ������
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

	public static void U(char[][] board) { // U ���ۿ� ���� push ���� 
		push(board, true, 'U');
		System.out.println("U");
		print(board);
	}

	public static void R(char[][] board) { // R ���ۿ� ���� push ���� 
		push(board, true, 'R');
		System.out.println("R");
		print(board);
	}

	public static void L(char[][] board) { // L ���ۿ� ���� push ���� 
		push(board, true, 'L');
		System.out.println("L");
		print(board);
	}

	public static void B(char[][] board) { // B ���ۿ� ���� push ���� 
		push(board, true, 'B');
		System.out.println("B");
		print(board);
	}

	public static void Ub(char[][] board) { // U' ���ۿ� ���� push ���� 
		push(board, false, 'U');
		System.out.println("U'");
		print(board);
	}

	public static void Rb(char[][] board) { // R' ���ۿ� ���� push ���� 
		push(board, false, 'R');
		System.out.println("R'");
		print(board);
	}

	public static void Lb(char[][] board) { // L' ���ۿ� ���� push ���� 
		push(board, false, 'L');
		System.out.println("L'");
		print(board);
	}

	public static void Bb(char[][] board) { // B' ���ۿ� ���� push ���� 
		push(board, false, 'B');
		System.out.println("B'");
		print(board);
	}

}