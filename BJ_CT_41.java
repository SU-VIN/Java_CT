import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
//  골드3 치즈 bfs

public class BJ_CT_41 {
    static int N,M;
    static int[][] map;
    static boolean[][]visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static class Node{
        int r,c;

        public Node(int r, int c){
            this.r =r;
            this.c= c;
        }
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map= new int[N][M];
        visited = new boolean[N][M];

        ArrayList<Node> list = new ArrayList<>();

        //데이터 삽입
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {   
                map[i][j]=Integer.parseInt(st.nextToken());
            }
            
        }


        //무한루프
        //1. 외부공기 -1로 바꿔줌
        //2. 녹는 치즈 탐색 상하좌우 -1이 2개이상이면 녹음 0은 내부공간이므로 무시
        //3. 녹는치즈들 -1로 바꿈
        //4. 내부에 치즈가 없다면 break;


        int result = 0;

        while(true){
            //1. 외부공기 -1로 바꿔주기
            visited = new boolean[N][M]; //루프 돌때마다 방문배열 초기화
            checkOut(0, 0);

            //2. 녹는 치즈 탐색
            list.clear();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j]==1){
                        if(findCheese(i,j)){ //녹은치즈가 있다면
                            list.add(new Node(i,j));
                        }
                    }
                    
                }
                
            }

            //4. 치즈개수 세기
            if(list.size()==0) break;


            result++;

        }

        System.out.println(result);



    }    

    private static void checkOut(int x, int y){
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(x, y));
        visited[x][y]= true;
        map[x][y]=-1;

        while(!dq.isEmpty()){
            Node now = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int dx = now.r+dr[i];
                int dy = now.c+dc[i];

                if(dx<0||dy<0||dx>=N||dy>=M) continue;
                if(visited[dx][dy])continue;
                if(map[dx][dy]==1)continue;

                //외부공기라면
                visited[dx][dy]= true;
                dq.addLast(new Node(dx, dy));
                map[dx][dy]=-1;

                
            }
        }

    }

    private static boolean findCheese(int x, int y){
        int melt = 0;

        for (int i = 0; i < 4; i++) {
            int dx = x+dr[i];
            int dy = y+dc[i];

            if(dx<0||dy<0||dx>=N||dy>=M)continue;

            if(map[dx][dy]==-1){
                melt++;
            }
        }
        if(melt>=2){//녹는치즈라면
            map[x][y]=0;
            return true;
        }else{
            return false;
        }
        
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         System.out.print(map[i][j]+" ");
                
        //     }
        //     System.out.println("\n");
            
        // }
        // System.out.println("////////////////////////////////");

    }
}
