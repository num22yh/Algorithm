import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] roomNumber = br.readLine().toCharArray();
        int[] numbers = new int[10];

        for (char c : roomNumber){
            int number = c-'0';
            numbers[number]++;
        }

        int temp = ( numbers[6] + numbers[9] + 1 ) / 2;
        numbers[6]= temp;
        numbers[9]= temp;

        int max =0;
        for(int i : numbers){
            max = max < i ? i : max;
        }

        System.out.println(max);

    }
}