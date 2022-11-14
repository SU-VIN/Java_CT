//평균값 구하기
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_CT_3 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int answer= 0;
        float result=0;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] arr = new int[10];
            for(int i=0;i<10;i++){
                arr[i]=sc.nextInt();
            }

            for(int i=0;i<arr.length;i++){
                result+=arr[i];
            }

            System.out.println("#"+test_case+" "+Math.round(result/10));

            result=0;
        }
    }
}
