import java.util.ArrayDeque;
import java.util.Queue;
//레벨2 -두큐의합같게만들기
public class PRO_CT_19 {
    public static int solution(int[] queue1, int[] queue2) {
        long sum1=0;
        long sum2=0;
        int count = 0;
        int max = queue1.length*3; //최악의 수

        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();

        for(int i=0;i<queue1.length;i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
        }

        long result=(sum1+sum2);
        if(result%2!=0) return -1; //두큐의 합이 홀수면 두큐의 합이 같아질 수 없음
        if(sum1==sum2) return 0; //처음부터 같으면 바로 return

        for(int i=0;i<queue1.length;i++){
            deque1.addLast(queue1[i]);
            deque2.addLast(queue2[i]);
        }
        long midResult= result/2;

        while(count<=max){
            if(sum1>midResult){
                sum1-=deque1.peekFirst();
                sum2+=deque1.peekFirst();
                deque2.addLast(deque1.pollFirst());
            }else{
                sum1+=deque2.peekFirst();
                sum2-=deque2.peekFirst();
                deque1.addLast(deque2.pollFirst());
            }
            count++;
            if(sum1==(result/2)) return count;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] queue1 = {1,2,1,2};
        int[] queue2 = {1,10,1,2};
        System.out.println(solution(queue1,queue2));

    }
}
