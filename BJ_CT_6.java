import java.util.Scanner;
//수들의 합 -실버5 - 그리디
public class BJ_CT_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n= sc.nextLong();
        long sum=0; //더해서 n을 만들 합
        int count=0; //서로 다른 자연수의 개수
        int i=1;
        while (true){
            if(sum>n)break;
            sum+=i;
            count++;
            i++;
        }

        System.out.println(count-1);

    }
}
