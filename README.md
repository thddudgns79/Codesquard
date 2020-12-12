# STEP - 3 코드 설명
**1. 변수 선언**
```
public class codesquard {
	static char[][][] cube;
	static String color = "BWOGYR"; // 초기 상태
	static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
        cube = new char[6][3][3]; 
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    cube[i][j][k] = color.charAt(i); // 문제에 명시된 초기 상태를 큐브에 입력
    }
}

``` 

* 3 X 3으로 이뤄진 큐브의 6면을 구현하기 위해 6 X 3 X 3의 3차원 배열을 생성 
* 인덱스 설정은 다음과 같다 
=> U(윗면) = 0 / L(좌측면) = 1 / F(앞면) = 2 / R(우측면) = 3 / B(뒷면) = 4 / B(아랫면) = 5  
* 전역변수의 color 문자열 변수에 면 별 초기상태를 담는다
* 3차원 큐브 배열에 큐브 초기 상태를 입력한다

**2. rotateMyself 함수 구현**
```
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
```

* 매개변수의 idx는 6면 중 입력면을 의미한다
* 입력으로 들어온 면을 시계방향으로 1회 돌리는 함수이다 
* 코드 동작 
=> temp 배열에 면의 가장 윗줄값을 담는다
=> 1열을 값을 1행에 대입한다 
=> 3행의 값을 1열에 대입한다
=> 3열의 값을 3행에 대입한다 
=> temp 배열의 값을 3열에 대입한다

**3. F, B, L, R, U ,D 함수 구현**
```
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
```

* rotateMyself 함수가 입력으로 들어온 면을 돌렸다면 이 6개의 함수는 입력으로 들어온 면의 동서남북으로 붙어있는 12개의 값을 시계방향으로 1회전시킨다.
* 6개의 함수 모두 동작 방식은 동일하고 rotateMyself의 동작방식과도 본질적으로 같다 
* ex) F(앞면)은 L(좌측면)의 3열 + U(윗면)의 3행 + R(우측면)의 1열 + D(아랫면)의 1행과 붙어있다. 이 붙어있는 12개의 값을 시계 방향으로 1회전시킨다.

**4. inputProcessing 함수 구현**

```
public static void inputProcessing() {
    int count = 0; // 조작 횟수
    while (true) {
        System.out.print("CUBE> ");
        String commands = sc.next(); // 조작법 입력
        if (commands.equals("Q")) {
            System.out.println("조작갯수: " + count);
            System.out.println("이용해주셔서  감사합니다! 뚜뚜뚜");
            break;
        }

        int n = commands.length();
        int idx = 0; // 조작법 문자열 인덱스 --> 입력문자열의 인덱스를 하나하나 탐색해가며 큐브 조작
        while (idx < n) {
            if (idx + 1 < n && commands.charAt(idx + 1) == '2') { // F,B,L,R,U,D + 2
                if (commands.charAt(idx) == 'F') {
                    rotateMyself(2);
                    rotateMyself(2);
                    F();
                    F();
                    System.out.println("F2");
                    print();
                    count += 2;
                }
                if (commands.charAt(idx) == 'B') {
                    rotateMyself(4);
                    rotateMyself(4);
                    B();
                    B();
                    System.out.println("B2");
                    print();
                    count += 2;
                }
                if (commands.charAt(idx) == 'L') {
                    rotateMyself(1);
                    rotateMyself(1);
                    L();
                    L();
                    System.out.println("L2");
                    print();
                    count += 2;
                }
                if (commands.charAt(idx) == 'R') {
                    rotateMyself(3);
                    rotateMyself(3);
                    R();
                    R();
                    System.out.println("R2");
                    print();
                    count += 2;
                }
                if (commands.charAt(idx) == 'U') {
                    rotateMyself(0);
                    rotateMyself(0);
                    U();
                    U();
                    System.out.println("U2");
                    print();
                    count += 2;
                }
                if (commands.charAt(idx) == 'D') {
                    rotateMyself(5);
                    rotateMyself(5);
                    D();
                    D();
                    System.out.println("D2");
                    print();
                    count += 2;
                }
                idx += 2;
            }

            else if (idx + 1 < n && commands.charAt(idx + 1) == '\'') { // F,B,L,R,U,D + '
                if (commands.charAt(idx) == 'F') {
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
                if (commands.charAt(idx) == 'B') {
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
                if (commands.charAt(idx) == 'L') {
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
                if (commands.charAt(idx) == 'R') {
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
                if (commands.charAt(idx) == 'U') {
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
                if (commands.charAt(idx) == 'D') {
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
            }

            else { // F,B,L,R,U,D 
                if (commands.charAt(idx) == 'F') {
                    rotateMyself(2);
                    F();
                    System.out.println("F");
                    print();
                    count++;
                }
                if (commands.charAt(idx) == 'B') {
                    rotateMyself(4);
                    B();
                    System.out.println("B");
                    print();
                    count++;
                }
                if (commands.charAt(idx) == 'L') {
                    rotateMyself(1);
                    L();
                    System.out.println("L");
                    print();
                    count++;
                }
                if (commands.charAt(idx) == 'R') {
                    rotateMyself(3);
                    R();
                    System.out.println("R");
                    print();
                    count++;
                }
                if (commands.charAt(idx) == 'U') {
                    rotateMyself(0);
                    U();
                    System.out.println("U");
                    print();
                    count++;
                }
                if (commands.charAt(idx) == 'D') {
                    rotateMyself(5);
                    D();
                    System.out.println("D");
                    print();
                    count++;
                }
                idx++;
            }
        }
    }
}
```

* inputProcessing 함수는 입력처리를 담당한다.
* 조작횟수를 출력해야 하기 때문에 조작횟수를 담을 count 변수를 선언한다
* 입력 시 프롬프트로 "CUBE> "를 출력한다
* 입력 문자열이 "Q"일 경우 여태까지의 조작횟수를 출력하고 종료 메시지와 함께 while문을 빠져나온다
* step - 2의 입력 처리 함수와 동일하게 문자열의 인덱스를 순차적으로 탐색한다
* 현재 보고 있는 인덱스의 바로 앞 인덱스가 '2'인 경우 현재 알파벳에 알맞은 함수와 rotateMyself 함수를 각각 2회 호출한다(시계방향 2회전이므로) Idx를 2증가시키고 다시 루프를 돈다
* 현재 보고 있는 인덱스의 바로 앞 인덱스가 작은따옴표(')인 경우 현재 알파벳에 알맞은 함수와 rotateMyself 함수를 각각 3회 호출한다(반시계 방향 1회전은 시계 방향 3회전과 같다) Idx를 2증가시키고 다시 루프를 돈다
* 그 외의 경우는 현재 알파벳에 알맞은 함수와 rotateMyself 함수를 각각 1회 호출한다(시계 방향 1회전이므로)
Idx를 1증가시키고 다시 루프를 돈다

**5. main 함수**

```
public static void main(String[] args) {
    cube = new char[6][3][3]; 
    for (int i = 0; i < 6; i++)
        for (int j = 0; j < 3; j++)
            for (int k = 0; k < 3; k++)
                cube[i][j][k] = color.charAt(i); // 문제에 명시된 초기 상태를 큐브에 입력

    System.out.println("(초기 상태 출력)");
    print(); // 초기상태 출력
    inputProcessing();

}
```

* 문제에 제시된대로 초기 큐브 상태를 한 번 보여주고 입력 처리를 진행하기 위해 inputProcessing함수를 호출한다
