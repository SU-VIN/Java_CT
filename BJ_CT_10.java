import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//세그먼트 트리 이분탐색- 실버2- 숫자카드
public class BJ_CT_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int[] narr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();

        for(int i=0;i<n;i++){
            narr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(narr); //정렬

        int m =Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){
            int left = 0;
            int right=n-1;
            int num =Integer.parseInt(st.nextToken());

            while (left<=right){
                int midindex = (left+right)/2;
                int middle = narr[midindex];

                if (num==middle){
                    str.append(1+" ");
                    break;
                }

                if(num<middle) right=midindex-1;
                else if(num>middle) left=midindex+1;

                if(left>right){
                    str.append(0+" ");
                    break;
                }
            }


        }


        System.out.println(str);
    }
}
