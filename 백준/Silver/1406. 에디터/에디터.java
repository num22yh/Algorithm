import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 입력받은 문자열을 LinkedList에 저장
        LinkedList<Character> list = new LinkedList<>();
        String str = br.readLine();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        
        // ListIterator 생성
        ListIterator<Character> iterator = list.listIterator(list.size());
        
        // 명령어 개수 입력
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);
            
            if (cmd == 'L') {
                if (iterator.hasPrevious()) iterator.previous();
            } else if (cmd == 'D') {
                if (iterator.hasNext()) iterator.next();
            } else if (cmd == 'B') {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            } else if (cmd == 'P') {
                char x = command.charAt(2);
                iterator.add(x);
            }
        }
        
        // 출력
        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
