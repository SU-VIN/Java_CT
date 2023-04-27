import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//골드3 다리만들기 bfs
public class BJ_CT_40 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static class Node{
        int r,c,len;

        public Node(int r, int c,int len){
            this.r=r;
            this.c=c;
            this.len=len;
        }
    }

    static int cnt = 1;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        //데이터 삽입
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
            
        }




        //섬구분하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1&&!visited[i][j]){
                    ArrayDeque<Node> dq = new ArrayDeque<>();
                    dq.addLast(new Node(i, j,0));
                    map[i][j]= cnt;
                    visited[i][j]= true;

                    while(!dq.isEmpty()){
                        Node now = dq.pollFirst();

                        for (int k = 0; k < 4; k++) {
                            int dx = now.r+dr[k];
                            int dy = now.c+dc[k];

                            if(dx<0||dy<0||dx>=N||dy>=N) continue; //갈수없는곳
                            if(map[dx][dy]==0) continue; //바다는 무시

                            if(!visited[dx][dy]){
                                visited[dx][dy]=  true;
                                map[dx][dy]=cnt;
                                dq.addLast(new Node(dx, dy,0));
                            }
                            
                        }
                    }
                    cnt++;
                }
            }
            
        }



        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(map[i][j]+" ");
                
        //     }
        //     System.out.println("\n");
        // }

        int MIN = Integer.MAX_VALUE;
        visited = new boolean[N][N];
        for (int i = 1; i <= cnt; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k  < N; k++) {
                    if(map[j][k]==i&&!visited[j][k]){
                        visited[j][k] =true;
                        MIN = Math.min(MIN,bfs(j,k,i) );
                        visited = new boolean[N][N];
                    }
                    
                }
                
            }
            
        }

        System.out.println(MIN);


    }
    
    private static int bfs(int x, int y,int num){
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(x, y,0));

        while(!dq.isEmpty()){
            Node now = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int dx = now.r+dr[i];
                int dy = now.c+dc[i];

                if(dx<0||dy<0||dx>=N||dy>=N) continue;
                if(map[dx][dy]==num) continue;
                if(visited[dx][dy]) continue;

                if(map[dx][dy]==0&map[dx][dy]!=num){
                    visited[dx][dy]=true;
                    dq.addLast(new Node(dx,dy,now.len+1));

                }


                if(map[dx][dy]!=0&&map[dx][dy]!=num){ //다른섬에 도달했을때
                    return now.len;
                }
                
            }

        }


        return Integer.MAX_VALUE;

    }
}
