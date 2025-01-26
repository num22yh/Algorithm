import java.io.*;

public class Main{

    static char[][] map ;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        // 사탕 입력받기 (N*N)
        for(int i=0; i<N; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                map[i][j] = line[j];
            }
        }

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        int max = 0;

        // 사탕의 색이 서로 다른 인접한(상,하,좌,우) 두 칸 고르기 O(N^2)
        for(int fx=0; fx<N; fx++){
            for(int fy = 0; fy <N; fy++){
                int[] first = new int[]{fx,fy}; // 첫번째 사탕
                for(int i=0; i<4; i++){
                    int sx = fx + dx[i];
                    int sy = fy + dy[i];

                    if(sx>=0 && sy>=0 && sx<N && sy<N && map[fx][fy] != map[sx][sy]){
                        int[] second = new int[]{sx,sy}; // 두번째 사탕

                        // 고른 칸의 사탕 교환하기
                        changeCandies(first,second);

                        //먹을 수 있는 사탕의 최대 개수 구하기
                        int curMax = countCandies();
                        max = Math.max(max, curMax);

                        // 교환했던 사탕 원상복구
                        changeCandies(first,second);
                    }
                }
            }
        }
        System.out.println(max);
    }

    static void changeCandies(int[] first, int[] second){
        char firstCandyColor = map[first[0]][first[1]];
        char secondCandyColor = map[second[0]][second[1]];
        map[first[0]][first[1]] = secondCandyColor;
        map[second[0]][second[1]] = firstCandyColor;
    }

    static int countCandies(){
        int max = 1;

        // 가로로 한줄씩 탐색
        for(int row=0; row<N; row++){
            int count = 1;
            for(int col=1; col<N; col ++){
                if( map[row][col-1]==map[row][col]){
                    // 색이 같으면 count 1증가
                    count++;
                }else{
                    // 색이 다르면 count 1로 다시 초기화
                    count = 1;
                }
                max = Math.max(max,count);
            }
        }

        //세로로 한줄씩 탐색
        for(int col=0; col<N; col++){
            int count = 1;
            for(int row=1; row<N; row++){
                if( map[row-1][col]==  map[row][col]){
                    count++;
                }else{
                    count = 1;
                }
                max = Math.max(max,count);
            }
        }

        return max;
    }
}