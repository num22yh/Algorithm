import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Integer> clockNumSet = new TreeSet<>();

        //가능한 모든 시계수를 구하기 9^4 = 6561 의 조합에 대해 4개의 시계수들 만들어보기 => 6561*4
        for (int first = 1; first < 10; first++) {
            for (int second = 1; second < 10; second++) {
                for (int third = 1; third < 10; third++) {
                    for (int fourth = 1; fourth < 10; fourth++) {
                        int clockNum = makeClockNumber(first, second, third, fourth);
                        clockNumSet.add(clockNum);
                    }
                }
            }
        }


        //입력받기
        String[] input = br.readLine().split(" ");
        // 네 모서리에 씌여있는 1이상 9이하의 숫자 4개 (시계방향), 같은 숫자 존재 가능
        int[] current = new int[4];
        for (int i=0; i<4; i++) {
            int num = Integer.parseInt(input[i]);
            current[i] = num;
        }

        // 현재 만든 시계수가 몇 번째로 작은 시계수인지(=인덱스+1) 출력 O(6561)
        int curClockNum = makeClockNumber(current[0], current[1], current[2], current[3]);

        List<Integer> clockNumList = new ArrayList<>(clockNumSet); // 인덱스 접근을 위해 리스트로 변경 O(N)

        int result = clockNumList.indexOf(curClockNum) + 1;

        System.out.println(result);


    }

    static int makeClockNumber(int first, int second, int third, int fourth) {
        int min = Integer.MAX_VALUE;
        int startFirst = first * 1000 + second * 100 + third * 10 + fourth;
        min = Math.min(min, startFirst);
        int startSecond = second * 1000 + third * 100 + fourth * 10 + first;
        min = Math.min(min, startSecond);
        int startThird = third * 1000 + fourth * 100 + first * 10 + second;
        min = Math.min(min, startThird);
        int startFourth = fourth * 1000 + first * 100 + second * 10 + third;
        min = Math.min(min, startFourth);

        return min;
    }
}