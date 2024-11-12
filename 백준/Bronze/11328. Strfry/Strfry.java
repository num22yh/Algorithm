import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());

    for (int i=0; i<n; i++){
      String[] input = br.readLine().split(" ");
      String first = input[0];
      String second = input[1];

      char[] firstArray = first.toCharArray();
      char[] secondArray = second.toCharArray();

      Arrays.sort(firstArray);
      Arrays.sort(secondArray);

      boolean result = Arrays.equals(firstArray, secondArray);

      sb.append(Arrays.equals(firstArray, secondArray) ? "Possible\n" : "Impossible\n");

    }

    System.out.println(sb);
  }
}
