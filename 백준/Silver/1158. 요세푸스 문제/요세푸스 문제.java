import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> people = new LinkedList<>();
        for (int i=1; i<n+1; i++){
            people.add(i);
        }

        ListIterator<Integer> iterator = people.listIterator(0);
        int x = 0;

        sb.append("<");
        while (!people.isEmpty()){
            for (int i=0; i<k; i++){
                if(!iterator.hasNext()){
                    iterator = people.listIterator(0);
                }
                x = iterator.next();
            }

            sb.append(x);
            iterator.remove();

            if(!people.isEmpty()){
                sb.append(", ");
            }
        }

        sb.append(">");

        System.out.println(sb);
    }
}