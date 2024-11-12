import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());

    for (int i=0; i<n; i++){
      String[] input = br.readLine().split(" ");
      String first = input[0];
      String second = input[1];

      char[] firstArray = first.toCharArray();
      char[] secondArray = second.toCharArray();

      Arrays.sort(firstArray);
      Arrays.sort(secondArray);

      boolean result = true;
      for (int index=0; index<firstArray.length; index++){
        if (firstArray[index] != secondArray[index]){
          result = false;
          break;
        }
      }

      bw.write(result ? "Possible\n" : "Impossible\n");
    }

    bw.flush();
  }
}
