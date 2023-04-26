import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//골드4 연구소 bfs
public class BJ_CT_38 {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static class Node{
        int r,c;

        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static ArrayDeque<Node> poison = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited= new boolean[N][M];
    
        

        //데이터 삽입
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                //독의 좌표 기억해두기
                if(map[i][j]==2){
                    poison.addLast(new Node(i,j));
                }
            }
            
        }

        //1. 벽세우고
        //2. 바이러스 위치에서 주변이 0 즉 벽(1)이 없으면 다 2로 바꿈
        //3. 안전구역 크기 확인하기


        //1. 벽세우기 3벽이 겹치면 안됨

        ArrayDeque<Node> block = new ArrayDeque<>();
        int safe = 0;
        for (int i = 0; i < (N*M)-2; i++) {
            if(map[i/M][i%M]!=0) continue; //==1 이라하면 안되는 이유 2가 있기때문
            block.addLast(new Node(i/M, i%M));

            for (int j = i+1; j < (N*M)-1; j++) {
                if(map[j/M][j%M]!=0) continue; //이미 벽인곳은 무시함
                block.addLast(new Node(j/M, j%M));

                for (int k = j+1; k <(N*M);k++) {
                    if(map[k/M][k%M]!=0) continue; //이미 벽인곳은 무시함
                    block.addLast(new Node(k/M, k%M));
                    safe = Math.max(safe,bfs(block));
                    block.pollLast(); //사용한 벽을 빼줘야 새로운 벽을 다시 넣을 수 있음
                }
                block.pollLast();
            }
            block.pollLast();
        }

        System.out.println(safe);

    }

    public static int bfs(ArrayDeque<Node> block){
        int[][] copyMap = new int[N][M]; //벽을 세울 맵, 원본 맵을 카피해줌

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j]= map[i][j];
            }
        }

        //3개의 벽을 추가로 세워줌
        for(Node wall : block){
            copyMap[wall.r][wall.c] = 1;
        }

        // 큐에서 값이 빠져야하기때문에 원본 포이즌도 카피해두자.
        ArrayDeque<Node> copyPoison = new ArrayDeque<>();

        for(Node virus : poison){
            copyPoison.addLast(new Node(virus.r,virus.c));
        }

        while(!copyPoison.isEmpty()){
            Node now = copyPoison.pollFirst();

            //상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int dx = now.r+dr[i];
                int dy = now.c+dc[i];

                if(dx<0||dy<0||dx>=N||dy>=M) continue;
                if(copyMap[dx][dy]==1) continue; // 바이러스 주변이 벽이면 필요없음

                //바이러스 주변이 0이여야지 바이러스가 퍼질 수 있음
                if(copyMap[dx][dy]==0){
                    copyMap[dx][dy]=2; //바이러스 퍼져요
                    copyPoison.addLast(new Node(dx,dy));//퍼진 바이러스도 복사해둔 바이러스큐에 넣어줘야함
                }
                
            }
        }

        int cnt =0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyMap[i][j]==0){
                    cnt++;
                }
                
            }
            
        }

        return cnt;
    }
}
