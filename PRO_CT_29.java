import java.util.Arrays;

public class PRO_CT_29 {
    //레벨3 이분탐색 입국심사
    //답을 정해둠
    private    static  final int MAX = 1_000_000_000;
    private    static int N;
    private    static int [] time;
    public static long solution(int n, int[] times) {
        N=n;
        time=times;

        long left =1; //답으로 나올 수 있는 최소값
        long right = (long)MAX*MAX; //답으로 나올 수 있는 최대값

        while (left<right){
            long mid = (left+right)/2;
            if(isPossible(mid)){
                right=mid;
                System.out.println("right = " + right);

            }else{
                left=mid+1;
                System.out.println("left = " + left);

            }
        }

        return left;
    }


    private static boolean isPossible(long answer){
        long n = N;
        System.out.println("answer = " + answer);
        for(int i:time){

            n-=answer/i;
        }
        return n<=0; //n이 양수면 아직 처리못함 n이 음수면 다 처리한것
    }

    public static void main(String[] args) {
        int n= 6;
        int[] times ={7,10};
        System.out.println(solution(n,times));
    }

}
