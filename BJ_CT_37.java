import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_CT_37 {
    //실버1 단지번호붙이기 bfs로 풀기
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayDeque<Node> dq =new ArrayDeque<>();

    static int MAX = Integer.MIN_VALUE;
    static int result=0;
    static public class  Node{
        int r,c;
        
        public Node(int r, int c ){
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        //데이터 삽입
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(str.substring(j,j+1));
            }
            
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1&&!visited[i][j]){
                    int cnt=1;
                    dq.addLast(new Node(i,j));
                    visited[i][j]=true;
                    while(!dq.isEmpty()){
                        Node now = dq.pollFirst();

                        for (int k = 0; k < 4; k++) {
                            int dx = now.r+dr[k];
                            int dy = now.c+dc[k];
                
                
                            if(dx<0||dy<0||dx>=N||dy>=N) continue;
                            if(map[dx][dy]==0)continue;
                            if(!visited[dx][dy]){
                                visited[dx][dy] =true;
                                dq.addLast(new Node(dx,dy));
                                cnt++;
                            }
                            
                        }
                    }
                    list.add(cnt);


                }
            }
            
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            
        }


    }

}
