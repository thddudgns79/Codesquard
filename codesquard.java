import java.util.*;
public class codesquard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	}
	
	public static String push(String input, boolean direction) { // �Էµ� ������ �̴� ���� ���� 
		Queue<Character> q = new LinkedList<Character>();
		for(int i = 0; i < input.length(); i++)
			q.add(input.charAt(i)); 
		
		q.add(q.remove()); // �̴� ������ ���� = ť���� 1���� ����
		if(!direction) // �̴� ������ �ݴ� = ť���� 2�� ���� 
			q.add(q.remove());
		
		String result = ""; 
		while(!q.isEmpty())  
			result += q.remove(); // ���ڿ��� ������� ��� ��ȯ
		return result;
	}

}