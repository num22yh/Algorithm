import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;//출력할 불만도 합

        //입력 받기
        int N = Integer.parseInt(br.readLine());//사람 수 N명(1 ≤ N ≤ 500,000) , 1등~N등
        List<Integer> predScore = new ArrayList<>();

        for (int i = 0; i < N; i++) { //N명의 예상 등수, 1등 ~ N등
            int pred = Integer.parseInt(br.readLine());
            predScore.add(pred);
        }

        predScore.sort((a, b) -> b - a); // 내림차순 정렬, index = 0이 제일 큰 수

        int realScore = N;// 실제 등수 = N부터 차례대로 내려가기
        for (int i = 0; i < N; i++) {
            result +=Math.abs(realScore - predScore.get(i));
            realScore--;
        }

        System.out.println(result);

    }
}