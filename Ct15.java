import java.util.Scanner;

//완전탐색 - 뒤집은 소수
public class Ct15 {

    public static boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] arr = new int[T];
        String result ="";
        for(int i=0;i<T;i++)
        {
            arr[i]=sc.nextInt();

        }
        for(int i=0;i<arr.length;i++)
        {
            String tmp = new StringBuilder(Integer.toString(arr[i])).reverse().toString();
            int num = Integer.parseInt(tmp);
            System.out.println(num);

            if(isPrime(num)){
                result+=num+" ";
            }
        }
        System.out.println(result);
    }
}
