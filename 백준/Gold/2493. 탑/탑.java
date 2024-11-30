import java.io.*;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int curIndx = 0;

        for(String s : input) {
            int curHeight = Integer.parseInt(s);
            curIndx++;
            
            // 새로운 탑을 넣기 전에 스택의 마지막 원소가 현재 탑보다 낮다면 제거 ( 어차피 현재 탑에 의해 가려지기 때문 )
            while(!stack.isEmpty() && stack.peek()[1]< curHeight){
                stack.pop();
            }
            
            // 신호를 받을 탑을 확인
            if(stack.isEmpty()){
                sb.append(0).append(" "); // 신호 받을 탑 없음
            }else{
                sb.append(stack.peek()[0]).append(" "); // 스택의 마지막 원소의 높이가 신호를 받을 탑
            }
            
            //현재 탑을 스택에 추가
            stack.push(new int[]{curIndx,curHeight});
        }    
        
        System.out.println(sb);

    }
}