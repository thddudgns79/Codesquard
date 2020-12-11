import java.util.*;

public class codesquard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[3][3];
		boardSetting(board);
		
				
			
			
		
	}

	public static void push(char[][] board, boolean direction, char location) { // �Էµ� ������ �̴� ���� ����
		Queue<Character> q = new LinkedList<Character>();
		if (location == 'U') {
			for(int i = 0; i < 3; i++) // �ش� ���� ������� ť�� ���
				q.add(board[0][i]);
			
			q.add(q.remove());  // �ڷ� �� �� �б�
			if(!direction)   // �������� ��� �ڷ� �� �� �б�
				q.add(q.remove());
			
			for (int i = 0; i < 3; i++) // ť�� ���� ������� ���忡 �� �����ϱ�
				board[0][i] = q.remove();
		}
		if (location == 'R') {      
			for(int i = 0; i < 3; i++)
				q.add(board[i][2]);
			
			q.add(q.remove());
			if(!direction)
				q.add(q.remove());
			
			for (int i = 0; i < 3; i++)
				board[i][2] = q.remove();
		}
		if (location == 'L') {
			for(int i = 2; i >= 0; i--)
				q.add(board[i][0]);
			
			q.add(q.remove());
			if(!direction)
				q.add(q.remove());
			
			for (int i = 2; i >= 0; i--)
				board[i][0] = q.remove();
		}
		if (location == 'B') {
			for(int i = 2; i >= 0; i--)
				q.add(board[2][i]);
			
			q.add(q.remove());
			if(!direction)
				q.add(q.remove());
			
			for(int i = 2; i >= 0; i--)
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

	
}