import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String result = String.valueOf(A*B*C);
        int[] count = new int[10];

        for(int i = 0; i<result.length(); i++){
            int curNum = Character.getNumericValue(result.charAt(i));
            count[curNum]++;
        }

        for(int i=0; i<count.length; i++){
            System.out.println(count[i]);
        };

    }
}