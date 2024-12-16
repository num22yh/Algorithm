import java.util.ArrayDeque;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int curIndx = 0;
        int count =0;
        for(char c : input){

           if(c==')'){
              if(!stack.isEmpty() && curIndx-stack.peek() == 1){
                  //레이저
                  stack.pop();
                  count += stack.size();
              }else{
                  // 쇠막대기 끝
                  count++;
                  stack.pop();
              }
           }else{ // '('
               stack.push(curIndx);
           }

           curIndx++;

        }

        System.out.println(count);
    }
}