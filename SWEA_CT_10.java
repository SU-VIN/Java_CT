import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//D2 백만장자프로젝트
public class SWEA_CT_10 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Long> dq= new ArrayDeque<>();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N  = Integer.parseInt(br.readLine());//날
            int[] arr = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {    
                //데이터 삽입
                arr[j]=Integer.parseInt(st.nextToken());
            }

            //시작
            long cnt=0;
            long spend=0;
            long get=0;//얻은돈
            for (int j = N; j >= 1; j--) {
                int day = j-1;

                while(arr[j]>=arr[day]&&day>=1){
                    spend+=arr[day];
                    cnt++;
                    day--;
                }
                get+=(arr[j]*cnt)-spend;
                cnt=0;
                spend=0;
                j=day+1;

            }

            dq.addLast(get);
            
        }
        for (int i = 0; i < T; i++) {
            System.out.println("#"+(i+1)+" "+dq.pollFirst());
        }
    }
    
}
