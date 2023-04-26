import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//실버1 미로탐색 bfs
public class BJ_CT_36 {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static class Node{
        int r,c;

        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    static ArrayDeque<Node> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map= new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        //데이터 삽입
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]= Integer.parseInt(str.substring(j, j+1));
            }
            
        }


        visited[0][0]=true;
        dist[0][0]=1; 
        dq.addLast(new Node(0,0));

        while(!dq.isEmpty()){
            Node now = dq.pollFirst();

            //상하좌우탐색
            for (int i = 0; i < 4; i++) {
                int dx = now.r+dr[i];
                int dy = now.c+dc[i];

                if(dx<0||dy<0||dx>=N||dy>=M) continue;
                if(map[dx][dy]==0) continue;

                if(!visited[dx][dy]){
                    visited[dx][dy]= true;
                    dq.addLast(new Node(dx,dy));
                    dist[dx][dy]=dist[now.r][now.c]+1;
                }
                
            }
        }

        System.out.println(dist[N-1][M-1]);



    }
    
}
