import java.util.Scanner;

//신기한 수 - 브론즈3
public class BJ_CT_1 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n=scanner.nextInt();
//        int count =0;
//
//        for(int i=1;i<=n;i++){
//            String str = Integer.toString(i);
//            String[] arr= str.split("");
//            int sum=0;
//            for(int j=0;j<arr.length;j++){
//                sum+=Integer.parseInt(arr[j]);
//            }
//
//            if(i%sum==0) count++;
//        }
//
//        System.out.println(count);
//
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num= sc.nextInt();
        int count=0;

        for(int i=1;i<=num;i++){
            int sum =0;
            int n=i;

            while(n!=0){
                sum+=n%10;
                n=n/10;
            }

            if(i%sum==0) count++;

        }
        System.out.println(count);
    }
}