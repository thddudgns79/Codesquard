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

}
