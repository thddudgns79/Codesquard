import java.util.*;

public class codesquard {
	static char[][][] cube;
	static String color = "BWOGYR"; // 초기 상태

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cube = new char[6][3][3]; // 큐브의 6면에 대해 각각 3 x 3 배열 생성(U = 0 / L = 1 / F = 2 / R = 3 / B = 4 / D = 5)
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
					cube[i][j][k] = color.charAt(i); // 문제에 명시된 초기 상태를 큐브에 입력

	}

	public static void rotateMyself(boolean direction, int idx) { // 해당 면 먼저 돌리기
		char[] temp = new char[3];
		if (direction) { // 시계 방향{
			for (int i = 0; i < 3; i++)
				temp[i] = cube[idx][0][i];
			for (int i = 0; i < 3; i++)
				cube[idx][0][i] = cube[idx][2 - i][0];
			for (int i = 0; i < 3; i++) // 5 -> 1
				cube[idx][i][0] = cube[idx][2][i];
			for (int i = 0; i < 3; i++) // 3 -> 5
				cube[idx][2][i] = cube[idx][2 - i][2];
			for (int i = 0; i < 3; i++) // 0 -> 3
				cube[idx][i][2] = temp[i];
		} else { // 반시계 방향(== 시계방향으로 3번 돌리기)
			int count = 3;
			while (count != 0) {
				for (int i = 0; i < 3; i++)
					temp[i] = cube[idx][0][i];
				for (int i = 0; i < 3; i++)
					cube[idx][0][i] = cube[idx][2 - i][0];
				for (int i = 0; i < 3; i++) // 5 -> 1
					cube[idx][i][0] = cube[idx][2][i];
				for (int i = 0; i < 3; i++) // 3 -> 5
					cube[idx][2][i] = cube[idx][2 - i][2];
				for (int i = 0; i < 3; i++) // 0 -> 3
					cube[idx][i][2] = temp[i];
				count--;
			}
		}
	}

}
