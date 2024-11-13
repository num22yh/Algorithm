import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstWord = br.readLine();
        String secondWord = br.readLine();

        int[] firstCount = new int[26];
        int[] secondCount = new int[26];

        for ( char alpabet : firstWord.toCharArray() ) {
            firstCount[alpabet - 'a']++;
        }

        for (char alpabet : secondWord.toCharArray() ) {
            secondCount[alpabet - 'a']++;
        }

        int result =0;

        for (int i=0; i<firstCount.length; i++){
            if (firstCount[i]!=secondCount[i]){
                result += Math.abs(firstCount[i]-secondCount[i]);
            }
        }

        System.out.println(result);
    }
}
