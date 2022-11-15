//거꾸로 출력해 보아요.
import java.util.Scanner;

public class SWEA_CT_6 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] arr = new int[T+1];
        String result ="";
        for(int i=0;i<=T;i++)
        {
            result+= arr.length-i-1+" ";

        }
        System.out.println(result);
    }
}
