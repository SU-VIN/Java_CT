import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//실버3 - 예산- 이분탐색
public class BJ_CT_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr= new int[n];
        int sum=0;

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i]; //총합
        }
        Arrays.sort(arr);
        long m= Integer.parseInt(br.readLine());

        if(sum<m) System.out.println(arr[n-1]); // 예산요청의 총합이 예산보다 적다면 예산총합에서 젤 큰수 출력
        else{ //예산요청의 총합이 예산보다 크다면
            long start =0;
            long end=n-1;
            long avg = m/n;
            long mid=(start+end)/2;
            long s = 0;
            while (arr[mid]>avg){
                mid--;
            }

            for(int i=0;i<=mid;i++){
                s += arr[i];
            }
            long x = m-s;
            System.out.println(x/(n-(mid+1)));
        }


    }
}
