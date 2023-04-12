import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_CT_28 {
    //실버2 스타트와 링크 백트래킹 브루트포스 완전탐색

    private static int N;
    private static int[][] map;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited=new boolean[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //1. 팀조합 나누기
        //2. 팀점수 차이 구하기
        //3. 최소차이 구하기
        combine(0,0);
        System.out.println(min);

    }

    private static void combine(int cnt,int index){
        //return 조건
        if(cnt==N/2){
            score();
            return;
        }
        //재귀돌려돌려돌림판
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i]=true;
                combine(cnt+1,i+1);
                visited[i]=false;
            }
        }
    }

    private static void score(){
        int team1 = 0;
        int team2= 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                //visited배열가지고 계산해야함
                if(visited[i]&&visited[j]){
                    team1+=map[i][j];
                    team1+=map[j][i];
                }
                else if(!visited[i]&&!visited[j]){
                    team2+=map[i][j];
                    team2+=map[j][i];
                }
                
            }
            
        }

        int result = Math.abs(team1-team2);

        min=Math.min(min,result);
    }
}
