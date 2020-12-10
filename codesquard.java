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

		String input = ""; // ���۹� ���� ���ڿ�
		System.out.println("(�ʱ� ���� ���)");
		print(); // �ʱ���� ���
		int operationCount = 0; // ���� Ƚ��
		while (true) {
			System.out.print("CUBE> ");
			input = sc.next(); // ���۹� �Է�
			if (input.equals("Q")) {
				System.out.println("���۰���: " + operationCount);
				System.out.println("�̿����ּż�  �����մϴ�! �ѶѶ�");
				break;
			}
			operationCount += inputProcessing(input); // �̹� ���ۿ� ���� ���� Ƚ�� �߰�
		}

	}

	public static void rotateMyself(int idx) { // �ش� �� ���� ������
		char[] temp = new char[3];
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
	}

	public static void F() {
		char[] temp = new char[3];
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
	}

	public static void B() {
		char[] temp = new char[3];
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
	}

	public static void L() {
		char[] temp = new char[3];
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
	}

	public static void R() {
		char[] temp = new char[3];
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
	}

	public static void U() {
		char[] temp = new char[3];
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
	}

	public static void D() {
		char[] temp = new char[3];
		for (int i = 0; i < 3; i++)
			temp[i] = cube[2][2][i];
		for (int i = 0; i < 3; i++) // 1 -> 2
			cube[2][2][i] = cube[1][2][i];
		for (int i = 0; i < 3; i++) // 4 -> 1
			cube[1][2][i] = cube[4][2][i];
		for (int i = 0; i < 3; i++) // 3 -> 4
			cube[4][2][i] = cube[3][2][i];
		for (int i = 0; i < 3; i++) // 2 -> 3
			cube[3][2][i] = temp[i];
	}

	public static void print() { // ������ ��õ� ��� ��� �����
		for (int i = 0; i < 3; i++) {
			System.out.print("              ");
			for (int j = 0; j < 3; j++) {
				System.out.print(cube[0][i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < 3; i++) {
			for (int idx = 1; idx <= 4; idx++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(cube[idx][i][j] + " ");
				}
				System.out.print("   ");
			}
			System.out.println();
		}

		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print("              ");
			for (int j = 0; j < 3; j++) {
				System.out.print(cube[5][i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int inputProcessing(String input) {
		int count = 0;
		int n = input.length();
		int idx = 0; // ���۹� ���ڿ� �ε��� --> �Է¹��ڿ��� �ε����� �ϳ��ϳ� Ž���ذ��� ť�� ����
		while (idx < n) {
			if (idx == n - 1) { // ������ �ε����� ���(' Ȥ�� 2�� ��� ���� �ε����� �������� ���ϰ� �̹� �������)
				if (input.charAt(idx) == 'F') {
					rotateMyself(2);
					F();
					System.out.println("F");
					print();
					count++;
				}
				if (input.charAt(idx) == 'B') {
					rotateMyself(4);
					B();
					System.out.println("B");
					print();
					count++;
				}
				if (input.charAt(idx) == 'L') {
					rotateMyself(1);
					L();
					System.out.println("L");
					print();
					count++;
				}
				if (input.charAt(idx) == 'R') {
					rotateMyself(3);
					R();
					System.out.println("R");
					print();
					count++;
				}
				if (input.charAt(idx) == 'U') {
					rotateMyself(0);
					U();
					System.out.println("U");
					print();
					count++;
				}
				if (input.charAt(idx) == 'D') {
					rotateMyself(5);
					D();
					System.out.println("D");
					print();
					count++;
				}
				idx++;
				continue;
			}

			else if (input.charAt(idx + 1) == '2') { // ���� �ε��� �ٷ� ���� 2�� ��� --> ť�� �ð�������� 2�� ������
				if (input.charAt(idx) == 'F') {
					rotateMyself(2);
					rotateMyself(2);
					F();
					F();
					System.out.println("F2");
					print();
					count += 2;
				}
				if (input.charAt(idx) == 'B') {
					rotateMyself(4);
					rotateMyself(4);
					B();
					B();
					System.out.println("B2");
					print();
					count += 2;
				}
				if (input.charAt(idx) == 'L') {
					rotateMyself(1);
					rotateMyself(1);
					L();
					L();
					System.out.println("L2");
					print();
					count += 2;
				}
				if (input.charAt(idx) == 'R') {
					rotateMyself(3);
					rotateMyself(3);
					R();
					R();
					System.out.println("R2");
					print();
					count += 2;
				}
				if (input.charAt(idx) == 'U') {
					rotateMyself(0);
					rotateMyself(0);
					U();
					U();
					System.out.println("U2");
					print();
					count += 2;
				}
				if (input.charAt(idx) == 'D') {
					rotateMyself(5);
					rotateMyself(5);
					D();
					D();
					System.out.println("D2");
					print();
					count += 2;
				}
				idx += 2;
				continue;
			}

			else if (input.charAt(idx + 1) == '\'') { // ���� �ε��� �ٷ� ���� '�� ��� --> ť�� �ð�������� 3�� ������ == �ݽð���� 1�� ������
				if (input.charAt(idx) == 'F') {
					rotateMyself(2);
					rotateMyself(2);
					rotateMyself(2);
					F();
					F();
					F();
					System.out.println("F'");
					print();
					count++;
				}
				if (input.charAt(idx) == 'B') {
					rotateMyself(4);
					rotateMyself(4);
					rotateMyself(4);
					B();
					B();
					B();
					System.out.println("B'");
					print();
					count++;
				}
				if (input.charAt(idx) == 'L') {
					rotateMyself(1);
					rotateMyself(1);
					rotateMyself(1);
					L();
					L();
					L();
					System.out.println("L'");
					print();
					count++;
				}
				if (input.charAt(idx) == 'R') {
					rotateMyself(3);
					rotateMyself(3);
					rotateMyself(3);
					R();
					R();
					R();
					System.out.println("R'");
					print();
					count++;
				}
				if (input.charAt(idx) == 'U') {
					rotateMyself(0);
					rotateMyself(0);
					rotateMyself(0);
					U();
					U();
					U();
					System.out.println("U'");
					print();
					count++;
				}
				if (input.charAt(idx) == 'D') {
					rotateMyself(5);
					rotateMyself(5);
					rotateMyself(5);
					D();
					D();
					D();
					System.out.println("D'");
					print();
					count++;
				}
				idx += 2;
				continue;
			}

			else { // ���� �ε��� �ٷ� ���� �׳� ���ĺ��� ���
				if (input.charAt(idx) == 'F') {
					rotateMyself(2);
					F();
					System.out.println("F");
					print();
					count++;
				}
				if (input.charAt(idx) == 'B') {
					rotateMyself(4);
					B();
					System.out.println("B");
					print();
					count++;
				}
				if (input.charAt(idx) == 'L') {
					rotateMyself(1);
					L();
					System.out.println("L");
					print();
					count++;
				}
				if (input.charAt(idx) == 'R') {
					rotateMyself(3);
					R();
					System.out.println("R");
					print();
					count++;
				}
				if (input.charAt(idx) == 'U') {
					rotateMyself(0);
					U();
					System.out.println("U");
					print();
					count++;
				}
				if (input.charAt(idx) == 'D') {
					rotateMyself(5);
					D();
					System.out.println("D");
					print();
					count++;
				}
				idx++;
				continue;
			}
		}
		return count;
	}

}
