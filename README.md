# STEP - 2 코드 설명 
**1. 큐브 배열 선언**
```
public static void main(String[] args) {
	char[][] board = new char[3][3];
}
```
* 큐브 입력을 위한 3 X 3 CHAR배열 선언

**2. boardSetting 함수 구현**
```
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
```

* 매개변수로 선언한 board 배열을 넘기고, 문제에 나온 초기 배열의 상태를 큐브에 그대로 옮기기

**3. push 함수 구현**
```
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
```

* 모든 8방향 조작의 동작 방식은 같다
* EX) U 입력시 큐브의 가장 윗줄인 1행1열 1행 2열 1행3열의 값을 순서대로 큐에 담아준다 
--> 매개변수 direction의 값이 true 면 큐를 왼쪽으로 한 번만 밀고 false면 두번 민다.(두번 밀면 오른쪽으로 한번 민 것과 동일하다) 
--> 다시 큐브 1행1열,2열,3열에 큐에 담겨있는 알파벳을 순서대로 삽입한다.
* 나머지 7방향의 동작방식도 이와 같다. 다만 문제에 명시된 대로 L 과 B 방향은 방향이 반대이므로 배열값을 큐에 담는 동작과 큐 값을 배열에 담는 동작을 U 와 R 방향과 반대로 한다.

**4. 8개의 가능한 조작(U,U',R,R',L,L',B,B')을 다루는 함수 구현**
```
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
```
* U,R,L,B 정방향으로 들어온 조작에 대해서는 U,R,L,B 함수를 호출하되 direction 매개변수값을 true로 호출하여 방향에 맞는 조작이 이뤄지도록 한다
* U',R',L',B' 역방향으로 들어온 조작에 대해서는 direction 매개변수값을 false로 호출한다. 

**5. input 함수 구현** 
```
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
```

* 입력을 처리하는 input 함수이다.
* 무한루프를 돌며 입력된 문자열이 "Q"일 시 "BYE"를 출력하고 종료한다. 
* 먼저 "CUBE> ". 프롬프트를 보여주고 commands 변수에 조작 문자열을 입력받는다
* 그 후 문자열 인덱스를 while문을 통해 순차적으로 탐색한다
* 현재 살펴보고 있는 인덱스 바로 앞 인덱스의 문자가 작은따옴표(')일 경우 역방향 입력이므로 현재 인덱스 알파벳에 맞는 Ub,Rb,Lb,Bb 함수를 호출하고 idx 값을 2 증가시키고 다시 반복문을 돈다
* 그 외의 경우에는 모두 정방향 입력이기 때문에 U,R,L,B 중 현재 인덱스 알파벳에 맞는 함수를 호출하고 idx 값을 1 증가시키고 다시 반복문을 돈다
* idx값이 문자열의 길이에 다다르면 반복문을 빠져나오고 다시 바깥 루프를 돈다

**6. print 함수 구현**

```
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
```

* 조작이 끝날 때 마다 현재 큐브 상태를 출력한다
* 출력 간 공간 확보를 한다 

**7. main 함수**

```
public static void main(String[] args) {
    char[][] board = new char[3][3];
    boardSetting(board); // 큐브의 초기 상태 세팅
    print(board); // 초기 상태 출력
    input(board); // 커맨드 입력 및 처리
}
```

* 문제에 명시된 프로그램 진행을 따르기 위해 위의 순서로 만들어둔 함수를 호출한다.