import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_CT_22 {
    //backtracktig N과M 실버3
    private  static boolean[] used;
    private static int N,M;

    private static StringBuilder sb ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        used = new boolean[N+1];

        backTracking(0,"");
        System.out.println(sb);
    }

    private  static void backTracking(int cnt, String s){
        if(cnt==M){
            sb.append(s.trim()+"\n");
        }

        for (int i = 1; i <=N ; i++) {
            if(!used[i]){
                used[i]=true;
                backTracking(cnt+1,s+" "+i);
                used[i]=false;
            }
        }
    }
}
