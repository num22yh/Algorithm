import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input 입력 받기 : 다솜이의 방 번호 N(10^6)
        String N = br.readLine();
        // 다솜이의 방 번호에 들어있는 0~9 의 개수를 저장할 count 배열 생성
        int[] count = new int[10];
        // 다솜이의 방 번호를 순회하며 배열 업데이트
        char[] roomNum = N.toCharArray();
        for (char c : roomNum){
            int x = c - '0';
            count[x]++;
        }
        // 9와 6의 개수는 (둘 합 + 1)/2 로 수정
        int temp = (count[9]+count[6]+1)/2;
        count[9]=temp;
        count[6]=temp;
        // count 배열의 최대값 업데이트
        int max=0;
        for (int i: count){
            if (i>max){
                max = i;
            }
        }

        System.out.println(max);
    }
}