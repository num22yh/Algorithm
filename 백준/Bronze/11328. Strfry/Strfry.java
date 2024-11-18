import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // n : 테스트케이스 수 (1000)
        // 문자열1 문자열2 (길이 최대 1000)

        int n = Integer.parseInt(br.readLine());


        for (int i=0; i<n; i++){

            int[] firstCount = new int[26];
            int[] secondCount = new int[26];
            String[] input = br.readLine().split(" ");
            char[] first = input[0].toCharArray();
            char[] second = input[1].toCharArray();

            for (char c : first){
                int x = c - 'a';
                firstCount[x]++;
            }

            for (char c : second){
                int x = c - 'a';
                secondCount[x]++;
            }


            String result = (Arrays.equals(firstCount,secondCount))? "Possible" : "Impossible";
            sb.append(result+"\n");
        }

        System.out.println(sb);

    }
}