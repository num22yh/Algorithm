import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] arr = input.substring(1,input.length()-1).split(",");
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            ArrayList<Integer> resultArr = new ArrayList<>();

            boolean isReverse = false;
            boolean hasError = false;

            for(String s : arr){
                if(!s.equals("")){
                    deque.offer(Integer.parseInt(s));
                }
            }

            for(String commend : p){
                if(commend.equals("R")){
                    isReverse = R(isReverse);
                }else if (commend.equals("D")){
                    if (deque.isEmpty()){
                        hasError = true;
                        break;
                    }else{
                        D(deque,isReverse);
                    }
                }
            }

            if (hasError){
                sb.append("error\n");
            }else{
                sb.append("[");
                if(isReverse){
                    while(!deque.isEmpty()){
                        sb.append(deque.pollLast());
                        if(!deque.isEmpty()){
                            sb.append(",");
                        }
                    }
                }else{
                    while(!deque.isEmpty()){
                        sb.append(deque.pollFirst());
                        if(!deque.isEmpty()){
                            sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
            }

        }

        System.out.println(sb);

    }

    private static boolean R(boolean isReverse){
        if(!isReverse){
            return true;
        }else{
            return false;
        }
    }

    private static int D(ArrayDeque<Integer> deque, boolean isReverse){
        if(!isReverse){
            return deque.pollFirst();
        }else{
            return deque.pollLast();
        }
    }
}