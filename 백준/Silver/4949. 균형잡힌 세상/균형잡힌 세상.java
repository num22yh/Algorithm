import java.util.ArrayDeque;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";


        while (true) {
            input = br.readLine();
            if(input.equals(".")){
                break;
            }
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isBalanced = true;
            char[] inputArr = input.toCharArray();

            for(char c : inputArr){
                if(c=='('|| c=='['){
                    stack.push(c);
                }

                if(c==')'){
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();
                    }else{
                        isBalanced = false;
                        break;
                    }
                }

                if(c==']'){
                    if(!stack.isEmpty() && stack.peek()=='['){
                        stack.pop();
                    }else{
                        isBalanced = false;
                        break;
                    }
                }

            }

            if(!stack.isEmpty()){
                isBalanced = false;
            }

            if(!isBalanced){
                sb.append("no").append("\n");
            }else{
                sb.append("yes").append("\n");
            }
        }

        System.out.println(sb);

    }
}