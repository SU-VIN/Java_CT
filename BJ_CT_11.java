import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//이분탐색- 실버4-수찾기
public class BJ_CT_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        int[] narr= new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            narr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(narr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] result = new int[m];
        for(int i=0;i<m;i++){
            int left = 0;
            int right = n-1;
            int num = Integer.parseInt(st.nextToken());

            while (left<=right){
                int midIndex =(left+right)/2;
                int middle = narr[midIndex];

                if(num==middle){
                    result[i]=1;
                    break;
                }

                if(num<middle) right= midIndex-1;
                else if(num>middle) left = midIndex+1;

                if(left>right){
                    result[i]=0;
                    break;
                }
            }
        }
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
