import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" "); // N개의 원소

        List<Integer> diff = new ArrayList<>(); // N-1개의 원소
        for(int i=0; i<N-1; i++){
            Integer height = Integer.parseInt(secondLine[i+1])-Integer.parseInt(secondLine[i]);
            diff.add(height);
        }

        diff.sort(Collections.reverseOrder());

        long result = 0;
        for(int i=K-1; i<N-1; i++){
            result += diff.get(i);
        }

        System.out.println(result);

    }
}