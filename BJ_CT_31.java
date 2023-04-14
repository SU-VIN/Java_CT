import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//실버1 dfs 단지번호붙이기

public class BJ_CT_31 {
    static int N,count;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> list;// 단지내의 집의수 저장할 리스트

    static int[] dr = {-1,1,0,0}; //상하좌우
    static int[] dc = {0,0,-1,1}; //상화좌우

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited= new boolean[N][N];

        //데이터 삽입
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(str.substring(j,j+1));
            }
        }

        //계산 

        list=new ArrayList<>();
        count=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1&&!visited[i][j]){ //집이있고 방문한적이 없을때
                    count=1; //집의수 1증가 (각단지의 첫번째 집임)
                    dfs(i,j);
                    list.add(count);
                }
                
            }
            
        }


        Collections.sort(list);

        System.out.println(list.size());
        for(int n : list){
            System.out.println(n);
        }


        //출력-> 단지수 , 단지내의 집의수를 오름차순으로 정렬
    }

    private static void dfs(int x, int y){
        //방문체크
        visited[x][y]= true;

        //상하좌우 체크
        for (int k = 0; k < 4; k++) {
            int dx = x + dr[k];
            int dy = y + dc[k];

            //map안에 존재할때
            if(dx>=0&&dy>=0&&dx<N&&dy<N){
                if(map[dx][dy]==1&&!visited[dx][dy]){
                    count++;
                    dfs(dx,dy);
                }
            }

            
        }
    }
}
