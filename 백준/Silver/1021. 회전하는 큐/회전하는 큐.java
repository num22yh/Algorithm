import java.io.*;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int count = 0;

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i<N+1 ; i++){
            deque.offer(i);
        }

        String[] secondLine = br.readLine().split(" ");

        for(int i=0; i<M; i++){
            int target = Integer.parseInt(secondLine[i]);

            while(deque.peekFirst()!=target){
                if (deque.indexOf(target)+1 <= (deque.size()+1)/2){
                    deque.offerLast(deque.pollFirst());
                    count++;
                }else {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }

            deque.pollFirst();

        }

        System.out.println(count);

    }


}