import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//골드4 알바벳 Dfs + 백트래킹
public class BJ_CT_34 {
    static int R,C;
    static String[][] map;
    static boolean[][] visited;

    static int[] dr= {-1,1,0,0};
    static int[] dc= {0,0,-1,1};

    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        visited = new boolean[R][C];

        //데이터 삽입
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j]=str.substring(j, j+1);
            }
        }

        //계산
        visited[0][0]= true;
        dfs(0,0,map[0][0],1);

        System.out.println(MAX);
    }


    static void dfs(int x, int y,String s,int cnt){

        if(MAX<cnt) MAX=cnt;

        //상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int dx = x + dr[i];
            int dy = y + dc[i];

            //예외처리
            if(dx<0||dy<0||dx>=R||dy>=C||visited[dx][dy]) continue;

            if(!s.contains(map[dx][dy])){
                visited[dx][dy]=true;
                System.out.println(s+" "+x+" "+y);
                dfs(dx,dy,s+map[dx][dy],cnt+1);
                visited[dx][dy]=false;
            }
        }
    }
}
