import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int A = Integer.parseInt(firstLine[1]);
        int B = Integer.parseInt(firstLine[2]);
        int resultMax = 0;

        String[] secondLine = br.readLine().split(" ");
        String[] thirdLine = br.readLine().split(" ");

        List<Integer> twoByOne = new ArrayList<>();
        List<Integer> twoByTwo = new ArrayList<>();

        for(int i =0; i<A; i++){
            int tile = Integer.parseInt(secondLine[i]);
            twoByOne.add(tile);
        }

        for(int i =0; i<B; i++){
            int tile = Integer.parseInt(thirdLine[i]);
            twoByTwo.add(tile);
        }

        twoByOne.sort(Collections.reverseOrder()); // 내림차순 정렬
        twoByTwo.sort(Collections.reverseOrder());


        for(int b = 0; b<=B; b++){
            if(2*b>N){
                break;
            }

            int a = N - 2*b;

            if(a>A){
                continue;
            }

            int max = 0;

            // 예쁨 최대값 계산
            for(int i=0; i<a; i++){
                max+=twoByOne.get(i);
            }

            for(int i=0; i<b; i++){
                max+=twoByTwo.get(i);
            }

            resultMax = Math.max(resultMax,max);

        }

        System.out.println(resultMax);
    }
}