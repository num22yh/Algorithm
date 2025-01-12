import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main{
    static int k;
    static String[] operators;
    static boolean[] visited = new boolean[10];
    static ArrayList<String> results = new ArrayList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        operators= br.readLine().split(" ");

        backtrack("",0);
        Collections.sort(results); //

        System.out.println(results.get(results.size()-1)); // 최대값
        System.out.println(results.get(0)); // 최소값
    }

    //backtracking 함수 구현
    static void backtrack(String num, int depth){
        if(depth == k+1){
            results.add(num);
            return;
        }

        for(int curNum = 0; curNum < 10; curNum++){
            if(!visited[curNum]){
                if (depth == 0) {
                    visited[curNum] = true; // 현재 숫자를 선택하고 방문한 걸로 표시
                    backtrack(num+curNum, depth+1); // 현재 숫자를 선택했을 때 -> 다음 숫자 선택 과정 진행
                    visited[curNum] = false; // 탐색이 끝났으므로 다음 탐색 때는 다시 이 숫자를 사용할 수 있도록 복구

                }else{
                    int preNum = num.charAt(depth-1)-'0';
                    String curOperator = operators[depth-1];
                    if(isValid(preNum,curNum,curOperator)){
                        visited[curNum] = true; // 현재 숫자를 선택하고 방문한 걸로 표시
                        backtrack(num+curNum, depth+1); // 현재 숫자를 선택했을 때 -> 다음 숫자 선택 과정 진행
                        visited[curNum] = false; // 탐색이 끝났으므로 다음 탐색 때는 다시 이 숫자를 사용할 수 있도록 복구
                    }
                }
            }
        }
    }
    //부등호 검증 함수 구현
    static boolean isValid(int preNum, int curNum, String curOperator){
        if(curOperator.equals("<")){
            return preNum < curNum ;
        }else{
            return preNum > curNum ;
        }
    }
}