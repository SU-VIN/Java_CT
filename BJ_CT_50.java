import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//골드4 주사위굴리기 구현 시물레이션
public class BJ_CT_50 {

    static int N,M;
    static int[][] map;

    static int[] dr = {0,0,0,-1,1};
    static int[] dc = {0,1,-1,0,0};

    public static class Dice{
        int top,bottom,up,down,left,right;

        public Dice(int top, int bottom, int up, int down, int left, int right){
            this.top=top;
            this.bottom=bottom;
            this.up=up;
            this.down=down;
            this.left=left;
            this.right=right;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
    

        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
            
        }

        //데이터 입력 완----------------------------------------

        //주사위 초기화
        Dice now = new Dice(0,0,0,0,0,0);
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());

            int dx = x+dr[dir];
            int dy = y+dc[dir];

            if(dx<0||dy<0||dx>=N||dy>=M) continue;

            if(dir==1){//동
                int tmp = now.left;
                now.left=now.bottom;
                now.bottom=now.right;
                now.right=now.top;
                now.top=tmp;
            }else if(dir==2){//서
                int tmp=now.left;
                now.left=now.top;
                now.top=now.right;
                now.right=now.bottom;
                now.bottom=tmp;
                
            }else if(dir==3){//북
                int tmp=now.up;
                now.up=now.top;
                now.top=now.down;
                now.down=now.bottom;
                now.bottom=tmp;

            }else if(dir ==4){//남
                int tmp=now.up;
                now.up=now.bottom;
                now.bottom=now.down;
                now.down=now.top;
                now.top=tmp;
            }

            if(map[dx][dy]==0){
                map[dx][dy]=now.bottom;
            }else{
                now.bottom=map[dx][dy];
                map[dx][dy]=0;
            }

            sb.append(now.top).append("\n");
            x=dx;
            y=dy;
        }

        System.out.println(sb.toString());
        
       
    }

  
}
