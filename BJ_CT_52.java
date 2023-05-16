import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//골드4 테트로미노
public class BJ_CT_52 {
    static int N,M;

    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc ={0,0,-1,1};


    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j]=true;
                dfs(i,j,map[i][j],0);
                visited[i][j]=false;

            }
            
        }

        System.out.println(MAX);

    }

    public static void dfs(int x,int y,int result,int cnt){
        if(cnt==4){
            result-=map[x][y];
            MAX = Math.max(MAX,result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // ㅗ 처리를 따로?
            if(cnt == 2){
                int dx = x+dr[i];
                int dy = y+dc[i];
                if(dx<0||dy<0||dx>=N||dy>=M) continue;
                if(visited[dx][dy]){//방문한곳 즉 이전 블록
                    for (int j = 0; j < 4; j++) {
                        int rx = dx+dr[i];
                        int ry = dy+dc[i];
                        if(rx<0||ry<0||rx>=N||ry>=M) continue;
                        if(visited[rx][ry])continue;

                        dfs(rx,ry,result+=map[rx][ry],cnt+1);
                        result-=map[rx][ry];
                    }
                }

            }
                int dx = x+dr[i];
                int dy = y+dc[i];
    
                if(dx<0||dy<0||dx>=N||dy>=M) continue;
                if(visited[dx][dy]) continue;
    
                visited[dx][dy]=true;
                dfs(dx,dy,result+=map[dx][dy],cnt+1);
                result-=map[dx][dy];
                visited[dx][dy]=false;
            

            
        }
    }
}

