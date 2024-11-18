import java.io.*;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = (br.readLine()).split(" ");
        ArrayList<Integer> numArr = new ArrayList<>();
        for (String s : arr){
            numArr.add(Integer.parseInt(s));
        }

        int v = Integer.parseInt(br.readLine());
        int count = 0;

        for (Integer i : numArr){
            if (i.equals(v)){
                count++;
            }
        }
        
        System.out.println(count);
    }
}