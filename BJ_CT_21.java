import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//내리막길 골드3
public class BJ_CT_21 {
    private  static  final int[] rx ={0,0,-1,1};
    private  static  final int[] ry ={1,-1,0,0};


    private static class Node{
        int r,c;

        public Node(int r,int c ){
            this.r=r;
            this.c=c;
        }
    }
    private static int[][] map;
    private  static int[][] cnt;
    private static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cnt = new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                cnt[i][j]=-1;
            }
        }

        cnt[N -1][M-1]=1;

        dfs(new Node(0,0));
        System.out.println(cnt[0][0]);

    }

    private static int dfs(Node now){
        //방문체크
        //cnt[now.r][now.c]가 0 이면 방문을 아직 않은 것이 맞나? 확신할 수 없음.
        //0이라는 값을 여기를 통해서 갈 수 있는 방법이 없다는걸 뜻할 수 있다
        if(cnt[now.r][now.c]>=-1){
            return cnt[now.r][now.c];
        }

        cnt[now.r][now.c]=0;

        for (int i = 0; i < 4; i++) {
            int nr = now.r+ry[i];
            int nc = now.c+rx[i];

            //맵밖으로 나가는 경우 예외처리
            if(nr <0||nc<0||nr>=N||nc>=M)
                continue;

            //현재보다 작은
            if(map[now.r][now.c]>map[nr][nc])
                cnt[now.r][now.c]+=dfs(new Node(nr,nc));
        }

        return cnt[now.r][now.c];
    }

}
