//투포인터 알고리즘- 두 배열 합치기
import java.util.Arrays;
import java.util.Scanner;

public class CT16 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] arr1 = new int[T];
        for(int i=0;i<T;i++)
        {
            arr1[i]=sc.nextInt();
        }

        int Y;
        Y=sc.nextInt();
        int[] arr2 =new int[Y];
        for(int i=0;i<Y;i++)
        {
            arr2[i]=sc.nextInt();

        }

        int[] result = new int[T+Y];
        for(int i=0;i<T;i++){
            result[i]=arr1[i];

        }
        for (int i=T;i<T+Y;i++){
            result[i]=arr2[i-T];

        }
        Arrays.sort(result);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }
}
