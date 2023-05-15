import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//D3 부분 수열의 합
public class SWEA_CT_13 {
    static int[] map;
    static boolean[] visited;
    static int N,K;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map= new int[N];
            visited = new boolean[N];
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i]=Integer.parseInt(st.nextToken());
            }
            result=0;
            dfs(0,0);
            dq.addLast(result);
            
        }

        //출력
        for (int i = 1; i <=T; i++) {
            System.out.println("#"+i+" "+dq.pollFirst());
        }
    }

    public static void dfs(int start,int cnt){

        if(cnt==K){
            result++;
            return;
        }

        for (int i = start; i < map.length; i++) {
            for (int j = i; j < map.length; j++) {
                if(!visited[j]){
                    visited[j]=true;
                    cnt+=map[j];
                    dfs(i,cnt);
                    visited[j]=false;
                }

            }
            
        }

    }
}
