import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] students = new int[7][2];

    for (int i =0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int grade = Integer.parseInt(st.nextToken());
      students[grade][gender]++;
    }

    int countRoom = 0;
    for (int i=0; i<7; i++){
      int girlsRoom;
      int boysRoom;
      if (students[i][0] == 0){
        girlsRoom = 0;
      } else if ((students[i][0]%k == 0)){
        girlsRoom = students[i][0]/ k;
      } else{
        girlsRoom = (students[i][0]/ k) + 1;
      }
      if (students[i][1] == 0){
        boysRoom = 0;
      } else if ((students[i][1]%k == 0)){
        boysRoom = students[i][1]/ k;
      } else{
        boysRoom = (students[i][1]/ k) + 1;
      }
      countRoom += (girlsRoom + boysRoom);
    }

    System.out.println(countRoom);
  }
}