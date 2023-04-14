import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//실버1 dfs 안전영역
public class BJ_CT_32 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int maxHeight = Integer.MIN_VALUE;
    static int cnt;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
       

        //데이터 삽입
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());                
                map[i][j]= num;              
                maxHeight = Math.max(maxHeight,num);
            }
            
        }
        

        //계산  
        int startHeight= 0; //비가안올수 있어서 0 부터 시작해야함
        int MAX = Integer.MIN_VALUE;
        while(startHeight<=maxHeight){
            visited = new boolean[N][N];//높이마다 방문배열 초기화
            cnt = 0; //안전영역의 개수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]>startHeight&&!visited[i][j]){//비의높이보다 높고 방문한적 없을때
                        cnt++; //dfs를 호출한만큼 == 안전영역의 개수
                        dfs(i,j,startHeight);
                    }
                    
                }
                
            }
            MAX = Math.max(MAX,cnt);
            startHeight++;
        }

        System.out.println(MAX);
    }

    private static void dfs(int x, int y,int height){
        //방문체크
        visited[x][y]=true;
        //상하좌우체크
        for (int i = 0; i < 4; i++) {
            int dx = x+dr[i];
            int dy = y+dc[i];

            //예외처리
            if(dx<0||dy<0||dx>=N||dy>=N) continue;
            if(map[dx][dy]<=height||visited[dx][dy]) continue;

            dfs(dx,dy,height);
            
            
        }

    }
}
