//중간값 찾기
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_CT_2 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[]arr=new int[T];
        for(int test_case = 0; test_case < T; test_case++)
        {
            arr[test_case]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length/2]);
    }
}
