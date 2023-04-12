import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//브루투포스 브론즈2 블랙잭
public class BJ_CT_27 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //N장의 카드
        int M = Integer.parseInt(st.nextToken()); //3개의 합이 M이하 최대값
        
        st = new StringTokenizer(br.readLine());
        int[] num=new int[N];
        for (int i = 0; i < N; i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i =0; i < N-2; i++) {{
            for (int j = i+1; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    int result = num[i]+num[j]+num[k];

                    if(result<=M){
                        max= Math.max(max,result);
                    }

                    if(max ==M){
                        break;
                    }
                }
                
            }
        }
            
        }

        System.out.println(max);
    }

}
