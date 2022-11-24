//OX퀴즈 - 브론즈2 구현
import java.util.Scanner;

public class BJ_CT_4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];//출력할 점수를 담을 배열

        for(int i=0;i<n;i++){
            String str = sc.next();
            int count = 0;
            int sum=0;

            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='O'){//문제를 맞았다면
                    count++; //점수를 증가해주고
                    sum+=count; //총 점수에 더해줌
                }else{//문제를 틀렸다면
                    count=0; //0으로 초기화
                }
            }

            arr[i]=sum;
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }


    }
}
