import java.util.Arrays;
import java.util.Scanner;

//보물- 그리디- 실버4
public class BJ_CT_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int sum=0;

        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0;i<a.length;i++){
            sum+=a[i]*b[a.length-1-i];
        }

        System.out.println(sum);

    }

}
