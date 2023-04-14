import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//골드5 dfs 적록색약
public class BJ_CT_33 {
    static int N;
    static String[][] map;
    static boolean[][] visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map=new String[N][N];
        visited= new boolean[N][N];

        //데이터 삽입
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j]=str.substring(j,j+1);
            }
        }


        //계산
        String[] rgb = {"R","G","B"};
        int normal = 0;
        int blind = 0;
        //정상일경우
        for(String color : rgb){
        
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j].equals(color)&&!visited[i][j]){
                        normal++;
                        dfs(i,j,color);
                        
                    }
                }
            }  
            
        }

        //색약일경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].equals("G")){
                    map[i][j]="R";
                }
            }
            
        }
        visited= new boolean[N][N]; //방문배열 초기화

        for(String color : rgb){
        
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j].equals(color)&&!visited[i][j]){
                        blind++;
                        dfs(i,j,color);
                        
                    }
                }
            }  
            
        }

        System.out.println(normal+" "+blind);
    }
    static void dfs(int x, int y,String rgb){
        //방문처리 
        visited[x][y] = true;
        //상하좌우체크
        for (int i = 0; i < 4; i++) {
            int dx = x+dr[i];
            int dy = y+dc[i];

            //예외처리
            if(dx<0||dy<0||dx>=N||dy>=N) continue;
            if(map[dx][dy].equals(rgb)&&!visited[dx][dy]){
                dfs(dx,dy,rgb);
            }
        }

    }
}
