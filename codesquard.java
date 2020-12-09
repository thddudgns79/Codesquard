import java.util.*;

public class codesquard {
	static char[][][] cube;
	static String color = "BWOGYR"; // �ʱ� ����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cube = new char[6][3][3]; // ť���� 6�鿡 ���� ���� 3 x 3 �迭 ����(U = 0 / L = 1 / F = 2 / R = 3 / B = 4 / D = 5)
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
					cube[i][j][k] = color.charAt(i); // ������ ��õ� �ʱ� ���¸� ť�꿡 �Է�

	}

	public static void rotateMyself(boolean direction, int idx) { // �ش� �� ���� ������
		char[] temp = new char[3];
		if (direction) { // �ð� ����{
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
		} else { // �ݽð� ����(== �ð�������� 3�� ������)
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

	public static void F(boolean direction) {
		char[] temp = new char[3];
		if (direction) { // �ð� ����
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][2][i];
			for (int i = 0; i < 3; i++) // 1 -> 0
				cube[0][2][i] = cube[1][2 - i][2];
			for (int i = 0; i < 3; i++) // 5 -> 1
				cube[1][i][2] = cube[5][0][i];
			for (int i = 0; i < 3; i++) // 3 -> 5
				cube[5][0][i] = cube[3][2 - i][0];
			for (int i = 0; i < 3; i++) // 0 -> 3
				cube[3][i][0] = temp[i];
		} else { // �ݽð� ����(== �ð�������� 3�� ������)
			int count = 3;
			while (count != 0) {
				for (int i = 0; i < 3; i++)
					temp[i] = cube[0][2][i];
				for (int i = 0; i < 3; i++) // 1 -> 0
					cube[0][2][i] = cube[1][2 - i][2];
				for (int i = 0; i < 3; i++) // 5 -> 1
					cube[1][i][2] = cube[5][0][i];
				for (int i = 0; i < 3; i++) // 3 -> 5
					cube[5][0][i] = cube[3][2 - i][0];
				for (int i = 0; i < 3; i++) // 0 -> 3
					cube[3][i][0] = temp[i];
				count--;
			}
		}
	}

	public static void B(boolean direction) {
		char[] temp = new char[3];
		if (direction) { // �ð� ����
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][0][2 - i];
			for (int i = 0; i < 3; i++) // 3 -> 0
				cube[0][0][i] = cube[3][i][2];
			for (int i = 0; i < 3; i++) // 5 -> 3
				cube[3][i][2] = cube[5][2][2 - i];
			for (int i = 0; i < 3; i++) // 1 -> 5
				cube[5][2][i] = cube[1][i][0];
			for (int i = 0; i < 3; i++) // 0 -> 1
				cube[1][i][0] = temp[i];
		} else { // �ݽð� ����(== �ð�������� 3�� ������)
			int count = 3;
			while (count != 0) {
				for (int i = 0; i < 3; i++)
					temp[i] = cube[0][0][2 - i];
				for (int i = 0; i < 3; i++) // 3 -> 0
					cube[0][0][i] = cube[3][i][2];
				for (int i = 0; i < 3; i++) // 5 -> 3
					cube[3][i][2] = cube[5][2][2 - i];
				for (int i = 0; i < 3; i++) // 1 -> 5
					cube[5][2][i] = cube[1][i][0];
				for (int i = 0; i < 3; i++) // 0 -> 1
					cube[1][i][0] = temp[i];
				count--;
			}
		}
	}

	public static void L(boolean direction) {
		char[] temp = new char[3];
		if (direction) { // �ð� ����
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][i][0];
			for (int i = 0; i < 3; i++) // 4 -> 0
				cube[0][i][0] = cube[4][2 - i][2];
			for (int i = 0; i < 3; i++) // 5 -> 4
				cube[4][i][2] = cube[5][2 - i][0];
			for (int i = 0; i < 3; i++) // 2 -> 5
				cube[5][i][0] = cube[2][i][0];
			for (int i = 0; i < 3; i++) // 0 -> 2
				cube[2][i][0] = temp[i];
		} else { // �ݽð� ����(== �ð�������� 3�� ������)
			int count = 3;
			while (count != 0) {
				for (int i = 0; i < 3; i++)
					temp[i] = cube[0][i][0];
				for (int i = 0; i < 3; i++) // 4 -> 0
					cube[0][i][0] = cube[4][2 - i][2];
				for (int i = 0; i < 3; i++) // 5 -> 4
					cube[4][i][2] = cube[5][2 - i][0];
				for (int i = 0; i < 3; i++) // 2 -> 5
					cube[5][i][0] = cube[2][i][0];
				for (int i = 0; i < 3; i++) // 0 -> 2
					cube[2][i][0] = temp[i];
				count--;
			}
		}
	}

	public static void R(boolean direction) {
		char[] temp = new char[3];
		if (direction) { // �ð� ����
			for (int i = 0; i < 3; i++)
				temp[i] = cube[0][2 - i][2];
			for (int i = 0; i < 3; i++) // 2 -> 0
				cube[0][i][2] = cube[2][i][2];
			for (int i = 0; i < 3; i++) // 5 -> 2
				cube[2][i][2] = cube[5][i][2];
			for (int i = 0; i < 3; i++) // 4 -> 5
				cube[5][i][2] = cube[4][2 - i][0];
			for (int i = 0; i < 3; i++) // 0 -> 4
				cube[4][i][0] = temp[i];
		} else { // �ݽð� ����(== �ð�������� 3�� ������)
			int count = 3;
			while (count != 0) {
				for (int i = 0; i < 3; i++)
					temp[i] = cube[0][2 - i][2];
				for (int i = 0; i < 3; i++) // 2 -> 0
					cube[0][i][2] = cube[2][i][2];
				for (int i = 0; i < 3; i++) // 5 -> 2
					cube[2][i][2] = cube[5][i][2];
				for (int i = 0; i < 3; i++) // 4 -> 5
					cube[5][i][2] = cube[4][2 - i][0];
				for (int i = 0; i < 3; i++) // 0 -> 4
					cube[4][i][0] = temp[i];
				count--;
			}
		}
	}

	public static void U(boolean direction) {
		char[] temp = new char[3];
		if (direction) { // �ð� ����
			for (int i = 0; i < 3; i++)
				temp[i] = cube[4][0][i];
			for (int i = 0; i < 3; i++) // 1 -> 4
				cube[4][0][i] = cube[1][0][i];
			for (int i = 0; i < 3; i++) // 2 -> 1
				cube[1][0][i] = cube[2][0][i];
			for (int i = 0; i < 3; i++) // 3 -> 2
				cube[2][0][i] = cube[3][0][i];
			for (int i = 0; i < 3; i++) // 4 -> 3
				cube[3][0][i] = temp[i];
		} else { // �ݽð� ����(== �ð�������� 3�� ������)
			int count = 3;
			while (count != 0) {
				for (int i = 0; i < 3; i++)
					temp[i] = cube[4][0][i];
				for (int i = 0; i < 3; i++) // 1 -> 4
					cube[4][0][i] = cube[1][0][i];
				for (int i = 0; i < 3; i++) // 2 -> 1
					cube[1][0][i] = cube[2][0][i];
				for (int i = 0; i < 3; i++) // 3 -> 2
					cube[2][0][i] = cube[3][0][i];
				for (int i = 0; i < 3; i++) // 4 -> 3
					cube[3][0][i] = temp[i];
				count--;
			}
		}
	}

}
