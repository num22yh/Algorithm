import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String N = br.readLine();
    int count[] = new int[10];

    for (int i=0; i<N.length();i++){
        int curNum = N.charAt(i)-'0';
        count[curNum]++;
    }

    int updateSixNine = (count[6]+count[9]+1)/2;
    count[6]=updateSixNine;
    count[9]=updateSixNine;

    System.out.print(Arrays.stream(count).max().getAsInt());

  }
}
