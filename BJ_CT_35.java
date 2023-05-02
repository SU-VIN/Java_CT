import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//골드3 양 구출 작전 풀었으나 시간초과 ㅜ
public class BJ_CT_35 {
    static int N;
    static String[][] map;
    static boolean[] visited;
    static long result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N  = Integer.parseInt(br.readLine());
        map = new String[N-1][3];
        visited = new boolean[N-1];

        //데이터 삽입
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j]=st.nextToken();
            }
            
        }
        result=0;
        long cnt = 0;
        for (int i = N-2; i >= 0; i--) {
            if(map[i][0].equals("S")&&!visited[i]){
                visited[i]=true;
                dfs(Long.parseLong(map[i][1]),Integer.parseInt(map[i][2]),i);
                cnt+=result;
                result=0;

            }
        }

        System.out.println(cnt);

    }

    static void dfs(long sheep,int bridge,int index){

        if(bridge==1){

            result+=sheep;
            return;
        }

        if(map[bridge-2][0].equals("W")){ //이어진 섬에 늑대가있을때
            if((sheep)>Long.parseLong(map[bridge-2][1])){//현재섬의 양이 더 많을때
                dfs((sheep-Long.parseLong(map[bridge-2][1])),Integer.parseInt(map[bridge-2][2]),bridge-2);
                map[bridge-2][1]="0";//늑대 수 초기화

                

            }else{//양의수가 늑대보다 적을때
                dfs(0,Integer.parseInt(map[bridge-2][2]),bridge-2);
                long wolf = Long.parseLong(map[bridge-2][1])- Long.parseLong(map[index][1]);
                map[bridge-2][1] = Long.toString(wolf);

            }
        }else if(!visited[bridge-2]){//양이있을때
            visited[bridge-2]=true;//방문체크
            dfs(sheep+Long.parseLong(map[bridge-2][1]),Integer.parseInt(map[bridge-2][2]),bridge-2);
        }else if(visited[bridge-2]){ //전에 이미 방문을 했을때

            dfs(sheep,Integer.parseInt(map[bridge-2][2]),bridge-2);
        }
    }
}
