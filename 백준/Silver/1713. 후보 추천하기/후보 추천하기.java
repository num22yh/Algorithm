import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 사진틀 개수
        int K = Integer.parseInt(br.readLine()); // 총 추천횟수

        String[] nums = br.readLine().split(" ");

        //사진틀 리스트 선언
        List<int[]> frame = new ArrayList<>();
        //{ 학생번호, 추천 수, 등장 순서}
        int order = 0;

        for (String s : nums) {
            int curNum = Integer.parseInt(s);
            if (frame.size() < N) {

                if (frame.size() == 0) {
                    frame.add(new int[]{curNum, 1, order});
                } else {
                    boolean hasMatch = false;

                    for (int i = 0; i < frame.size(); i++) {
                        if (frame.get(i)[0] == curNum) {
                            hasMatch = true;
                            frame.get(i)[1] += 1;
                            break;
                        }
                    }

                    if (!hasMatch) {
                        frame.add(new int[]{curNum, 1, order});
                    }
                }

            } else {
                boolean hasMatch = false;
                for (int i = 0; i < frame.size(); i++) {

                    if (frame.get(i)[0] == curNum) {
                        hasMatch = true;
                        frame.get(i)[1] += 1;
                        break;
                    }

                }

                if(!hasMatch){
                    frame.sort(Comparator.comparingInt((int[] arr) -> arr[1]).thenComparingInt(arr -> arr[2]));
                    frame.remove(0);
                    frame.add(new int[]{curNum, 1,order});

                }

            }

            order++;
        }

        frame.sort(Comparator.comparingInt(arr -> arr[0]));

        for (int i = 0; i < frame.size(); i++) {
            sb.append(frame.get(i)[0]).append(" ");
        }

        System.out.println(sb);


    }
}