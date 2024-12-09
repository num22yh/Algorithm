import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> cards = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<N+1 ; i++){
            cards.offer(i);
        }

        while(cards.size()!=1){
            cards.poll();
            cards.offer(cards.poll());
        }

        System.out.println(cards.peek());
    }
}