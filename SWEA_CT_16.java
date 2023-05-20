import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
//D3 재미있는 오셀로 게임
public class SWEA_CT_16 {
    static int N,M;
    static int[][]map;

    static int[] dr = {-1,1,0,0,-1,-1,1,1};//상하좌우 대각선
    static int[] dc= {0,0,-1,1,-1,1,1,-1};

    static public class Result{
        int B,W,C;
        public Result(int B, int W,int C){
            this.B=B;
            this.W=W;
            this.C=C;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Result> dq = new ArrayDeque<Result>();
        for (int i = 0; i <T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());//칸 크기
            M = Integer.parseInt(st.nextToken());//두는 횟수

            map = new int[N+1][N+1];
            //초기 바둑돌 설치
            map[N/2][N/2]=2;
            map[N/2][N/2+1]=1;
            map[N/2+1][N/2]=1;
            map[N/2+1][N/2+1]=2;

            //바둑돌 두기
            //1 = 흑 2 = 백
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int go = Integer.parseInt(st.nextToken()); //내가 둔 돌의 색
                map[x][y]=go;


                bfs(x,y,go);


            }

            //돌 세기
            int b = 0;
            int w = 0;
            for (int j = 1; j <=N ; j++) {
                for (int k = 1; k <=N ; k++) {
                    if(map[j][k]==1){
                        b++;
                    }else if(map[j][k]==2){
                        w++;
                    }
                }

            }

            dq.addLast(new Result(b,w,0));



        }


        //출력
        for (int i = 1; i <=T; i++) {
            System.out.println("#"+i+" "+dq.peekFirst().B+" "+dq.pollFirst().W);

        }
    }

    static public void bfs(int x,int y,int color) {

        for (int i = 0; i < 8; i++) {
            int dx = x+dr[i];
            int dy = y+dc[i];

            if(dx<1||dy<1||dx>=N+1||dy>=N+1) continue;


            boolean check = false;
            while (isOut(dx,dy)&&map[dx][dy]!=0){
                if(map[dx][dy]==color){
                    check= true;
                    break;
                }
                dx+=dr[i];
                dy+=dc[i];
            }

            while (check){
                if(dx==x&&dy==y) break;
                map[dx][dy]=color;
                dx-=dr[i];
                dy-=dc[i];
            }

        }

    }
    static public boolean isOut(int x,int y){
        if(x<1||y<1||x>=N+1||y>=N+1)return false;
        return true;

    }
}



