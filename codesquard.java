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

		String input = ""; // 조작법 담을 문자열
		System.out.println("(초기 상태 출력)");
		print(); // 초기상태 출력
		int operationCount = 0; // 조작 횟수
		while (true) {
			System.out.print("CUBE> ");
			input = sc.next(); // 조작법 입력
			if (input.equals("Q")) {
				System.out.println("조작갯수: " + operationCount);
				System.out.println("이용해주셔서  감사합니다! 뚜뚜뚜");
				break;
			}
			operationCount += inputProcessing(input); // 이번 조작에 대한 조작 횟수 추가
		}

	}

	public static void rotateMyself(int idx) { // 해당 면 먼저 돌리기
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

	public static void print() { // 문제에 명시된 출력 양식 만들기
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
		int idx = 0; // 조작법 문자열 인덱스 --> 입력문자열의 인덱스를 하나하나 탐색해가며 큐브 조작
		while (idx < n) {
			if (idx == n - 1) { // 마지막 인덱스인 경우(' 혹은 2인 경우 현재 인덱스에 접근하지 못하고 이미 종료됐음)
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

			else if (input.charAt(idx + 1) == '2') { // 현재 인덱스 바로 앞이 2인 경우 --> 큐브 시계방향으로 2번 돌리기
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

			else if (input.charAt(idx + 1) == '\'') { // 현재 인덱스 바로 앞이 '인 경우 --> 큐브 시계방향으로 3번 돌리기 == 반시계방향 1번 돌리기
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

			else { // 현재 인덱스 바로 앞이 그냥 알파벳인 경우
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
