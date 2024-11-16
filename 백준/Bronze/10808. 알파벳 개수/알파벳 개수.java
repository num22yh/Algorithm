import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String S = br.readLine();
        char[] word = S.toCharArray();

        int[] count = new int[26];

        for (char alphabet : word){
            int i = alphabet - 'a';
            count[i]++;
        }
        
        for (int i : count){
            sb.append(i);
            sb.append(" ");
        }
        
        System.out.println(sb);

    }
}