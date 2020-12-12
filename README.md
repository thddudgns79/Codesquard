# STEP - 1 코드 설명
1. 문제에 명시된 입력을 받을 변수 선언

```
    static Scanner sc = new Scanner(System.in);
	static String str; 
	static int cnt; 
	static char dir; 
	static LinkedList<Character> deque = new LinkedList<Character>();
```

* 입력에 사용할 스캐너 선언
* 문자열 입력받을 str 변수 선언 
* 미는 횟수 담을 cnt 변수 선언
* 'L' OR 'R' 담을 dir 변수 선언
* 미는 동작을 구현할 자료구조 deque 선언

2. 입력 처리 

```
public static void input() { // 입력 처리 
		System.out.print("> ");
		str = sc.next();
		cnt = sc.nextInt();
		dir = sc.next().charAt(0);
		for(int i = 0; i < str.length(); i++)
			deque.add(str.charAt(i));
	}
```

* > 프롬프트 띄우기 
* 문자열, 횟수, 방향 순으로 입력 
* 덱에 입력받은 문자들을 순서대로 삽입

3. PUSH 구현 

```
public static void pushLeft() { // 왼쪽으로 1번 밀기
		deque.addLast(deque.removeFirst());
	}

public static void pushRight() { //오른쪽으로 1번 밀기
		deque.addFirst(deque.removeLast());
	}
```

* 왼쪽으로 밀 땐 덱의 가장 앞 알파벳을 빼고 그 알파벳을 덱의 가장 뒤에 채워놓는다
* 오른쪽으로 밀 땐 덱의 가장 뒤의 알파벳을 빼고 그 알파벳을 덱의 가장 앞에 채워놓는다

4. 입력에 따른 push 함수 호출

```

public static void solve() {
		if (dir == 'L' || dir == 'l') { // 방향이 왼쪽일 경우 
			if (cnt >= 0) { // 숫자가 +
				for (int i = 0; i < cnt; i++) { 
					pushLeft();
				}
			} else {  // 숫자가 -
				for (int i = 0; i < Math.abs(cnt); i++) {
					pushRight();
				}
			}
		}

		else {     // 방향이 오른쪽일 경우
			if (cnt >= 0) { // 숫자가 +
				for (int i = 0; i < cnt; i++) {
					pushRight();
				}
			} else { // 숫자가 -
				for (int i = 0; i < Math.abs(cnt); i++) {
					pushLeft();
				}
			}
		}
	}
```

* dir 왼쪽이고 cnt +면, 왼쪽으로 입력된 횟수만큼 밀어준다 
* dir 왼쪽이고 cnt -면, 오른쪽으로 입력된 횟수만큼 밀어준다
* dir 오른쪽이고 cnt +면, 오른쪽으로 입력된 횟수만큼 밀어준다 
* dir 오른쪽이고 cnt -면, 왼쪽으로 입력된 횟수만큼 밀어준다 

5. 출력 구현 

``` 
public static void print() {
		while (!deque.isEmpty())
			System.out.print(deque.remove());
	}
```

* 큐가 텅 빌 때까지 큐 안의 알파벳을 순서대로 출력한다 

6. main 함수 

```
public static void main(String[] args) {
		input();
		solve();
		print();
	}
```

* 입력 함수  -> 입력 처리 함수 -> 출력 순으로 호출하며 프로그램 진행 

