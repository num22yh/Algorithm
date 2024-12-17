import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        // [ 괄호종류 , 인덱스, 점수 ]
        int curIndx = 0;
        int totalScore = 0;

        for(char c : input){

            if(c=='('){
                stack.push(new int[]{0,curIndx,0});
            }else if(c=='['){
                stack.push(new int[]{1,curIndx,0});
            }else if(c==')'){
                if(!stack.isEmpty()&& stack.peek()[0]==0){
                    int curScore = curIndx - stack.peek()[1] == 1 ? 2 : 2*(stack.peek()[2]);
                    stack.pop();
                    if(!stack.isEmpty()){
                        stack.peek()[2] += curScore;
                    }else{
                        //stack.isEmpty() == true
                        totalScore += curScore;
                    }
                }else{
                    totalScore = 0;
                    break;
                }
            }else if(c==']'){
                if(!stack.isEmpty()&& stack.peek()[0]==1){
                    int curScore = curIndx - stack.peek()[1] == 1 ? 3 : 3*(stack.peek()[2]);
                    stack.pop();
                    if(!stack.isEmpty()){
                        stack.peek()[2] += curScore;
                    }else{
                        //stack.isEmpty() == true
                        totalScore += curScore;
                    }
                }else{
                    totalScore = 0;
                    break;
                }
            }

            curIndx++;
        }

        System.out.println(totalScore);
    }
}