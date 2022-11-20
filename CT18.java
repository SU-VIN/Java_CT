//삽입정렬
import java.util.Arrays;
import java.util.Scanner;

class CT18{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr =new int[n];
        String result="";
        int tmp=0;
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }

        for(int i=1;i<arr.length;i++) {
            int target =arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>target) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=target;
        }

        System.out.println(Arrays.toString(arr));

    }

}