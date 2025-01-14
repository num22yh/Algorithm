import java.io.*;

public class Main{
    static int c, r, k;
    static boolean[][] visited;
    static int moveCount;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        c = Integer.parseInt(firstLine[0]);
        r = Integer.parseInt(firstLine[1]);
        k = Integer.parseInt(br.readLine());
        visited = new boolean[c+1][r+1];

        if(c*r<k){
            System.out.println(0);
        }else{
            moveUp(1,0);
        }
    }

    static void moveUp(int cur_x, int cur_y){
        visited[cur_x][cur_y] = true;
        if(moveCount == k){
            System.out.println(cur_x+" "+cur_y);
            return;
        }
        int next_x = cur_x;
        int next_y = cur_y+1;
        if(next_y<=r&&!visited[next_x][next_y]){
            moveCount++;
            visited[next_x][next_y] = true;
            moveUp(next_x,next_y);
        }else{
            moveRight(cur_x,cur_y);
        }

    }

    static void moveRight(int cur_x, int cur_y){
        visited[cur_x][cur_y] = true;
        if(moveCount == k){
            System.out.println(cur_x+" "+cur_y);
            return;
        }
        int next_x = cur_x+1;
        int next_y = cur_y;
        if(next_x<=c&&!visited[next_x][next_y]){
            moveCount++;
            visited[next_x][next_y] = true;
            moveRight(next_x,next_y);
        }else{
            moveDown(cur_x,cur_y);
        }
    }

    static void moveDown(int cur_x, int cur_y){
        visited[cur_x][cur_y] = true;
        if(moveCount == k){
            System.out.println(cur_x+" "+cur_y);
            return;
        }
        int next_x = cur_x;
        int next_y = cur_y - 1;
        if(next_y>=1&&!visited[next_x][next_y]){
            moveCount++;
            visited[next_x][next_y] = true;
            moveRight(next_x,next_y);
        }else{
            moveLeft(cur_x,cur_y);
        }

    }

    static void moveLeft(int cur_x, int cur_y){
        visited[cur_x][cur_y] = true;
        if(moveCount == k){
            System.out.println(cur_x+" "+cur_y);
            return;
        }
        int next_x = cur_x -1;
        int next_y = cur_y;
        if(next_x>=1&&!visited[next_x][next_y]){
            moveCount++;
            visited[next_x][next_y] = true;
            moveRight(next_x,next_y);
        }else{
            moveUp(cur_x,cur_y);
        }

    }


}