import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//로봇청소기 골드5 구현 시물레이션
public class BJ_CT_48 {
    static int N,M,dir;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr= {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int result=0;
    static public class Node{
        int r,c,dir;

        public Node(int r, int c,int dir){
            this.r=r;
            this.c=c;
            this.dir=dir;
        }
    }
 public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M=Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new boolean[N][M];

    st = new StringTokenizer(br.readLine());
    Node now = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            map[i][j]=Integer.parseInt(st.nextToken());
            if(map[i][j]==1){
                visited[i][j]=true;
            }
        }
    }

    //데이터 삽입 끝 ---------------------------------

    //dir 0=북 1=동 2=남 3=서
    //   북
    // 서  동
    //   남

    //0=청소안한곳 1=벽 
    bfs(now.r,now.c,now.dir);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            System.out.print(visited[i][j]+" ");
            
        }
        System.out.println("\n");
        
    }
    System.out.println(result);
 }  
 
 public static void bfs(int x,int y, int direction){
    ArrayDeque<Node> dq = new ArrayDeque<>();
    dq.addLast(new Node(x,y,direction));

    while(!dq.isEmpty()){
        Node nowRobot = dq.pollFirst();
        int cnt=0;
        //1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다
        if(!visited[nowRobot.r][nowRobot.c]){
            visited[nowRobot.r][nowRobot.c]=true;
            result++;
        }

        for (int i = 0; i < 4; i++) {
            int dx = nowRobot.r+dr[i];
            int dy = nowRobot.c+dc[i];

            if(dx<0||dy<0||dx>=N||dy>=M) continue;

            //cnt가 0이라면 주변에 청소되지 않은 빈칸이 없다는것 즉 다 청소했다는것
            //cnt가 1이상이라면 주변에 청소되지 않은 빈칸이 하나라도 있다는것
            if(!visited[dx][dy]){
                cnt++;
            }
            
        }

        //2.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        if(cnt==0){
            if(nowRobot.dir==0){
                //후진한곳이 벽이 아닌경우에만
                if(map[nowRobot.r+1][nowRobot.c]==0){
                    dq.addLast(new Node((nowRobot.r)+1,nowRobot.c,nowRobot.dir));
                }
            }else if(nowRobot.dir==1){
                if(map[nowRobot.r][nowRobot.c-1]==0){
                    dq.addLast(new Node(nowRobot.r,nowRobot.c-1,nowRobot.dir));
                }

            }else if(nowRobot.dir==2){
                if(map[nowRobot.r-1][nowRobot.c]==0){
                    dq.addLast(new Node((nowRobot.r)-1,nowRobot.c,nowRobot.dir));
                }

            }else if(nowRobot.dir==3){
                if(map[nowRobot.r][nowRobot.c+1]==0){
                    dq.addLast(new Node(nowRobot.r,nowRobot.c+1,nowRobot.dir));
                }

            }

        }else{
            //3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,

            for (int i = 0; i < 4; i++) {
                nowRobot.dir = nowRobot.dir-1;
                if(nowRobot.dir==-1)nowRobot.dir=3;

                if(nowRobot.dir==0){
                    if(!visited[nowRobot.r-1][nowRobot.c]&&map[nowRobot.r-1][nowRobot.c]==0){
                        dq.addLast(new Node(nowRobot.r-1,nowRobot.c,nowRobot.dir));
                    }else{
                        continue;
                    }
                }else if(nowRobot.dir==1){
                    if(!visited[nowRobot.r][nowRobot.c+1]&&map[nowRobot.r][nowRobot.c+1]==0){
                        dq.addLast(new Node(nowRobot.r,nowRobot.c+1,nowRobot.dir));
                        
                    }else{
                        continue;
                    }
    
                }else if(nowRobot.dir==2){
                    if(!visited[nowRobot.r+1][nowRobot.c]&&map[nowRobot.r+1][nowRobot.c]==0){
                        dq.addLast(new Node(nowRobot.r+1,nowRobot.c,nowRobot.dir));
                        
                    }else{
                        continue;
                    }
    
                }else if(nowRobot.dir==3){
                    if(!visited[nowRobot.r][nowRobot.c-1]&&map[nowRobot.r][nowRobot.c-1]==0){
                        dq.addLast(new Node(nowRobot.r,nowRobot.c-1,nowRobot.dir));
                        
                    }else{
                        continue;
                    }
    
                }
                break;

            }




        }
    }
 }
}
