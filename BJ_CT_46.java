import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//실버3 1로 만들기 dp

public class BJ_CT_46 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        //조건을 이용해 0과 1이 1이 될 방법은 0개임.
        //초기값 설정
        dp[0]=dp[1]=0;

        //dp[2] 즉 2가 1일될 최솟값은 1번임 즉 dp[2]=1 
        //그러므로 dp[i] = dp[i-1]+1 이라는 식이나옴
        //dp[2]=dp[1]+1  1= 0 +1 
        for (int i = 2; i <= N; i++) {
            dp[i]=dp[i-1]+1;
            if(i%2==0){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0){
               dp[i]=Math.min(dp[i],dp[i/3]+1);
            }
            
        }

        System.out.println(dp[N]);
    }
}
