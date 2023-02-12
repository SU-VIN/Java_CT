import java.util.Collections;
import java.util.PriorityQueue;

public class PRO_CT_23 {
    //디펜스 게임 레벨2
    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer>pq= new PriorityQueue<>(Collections.reverseOrder());


        for(int e:enemy){
            pq.add(e);
            //무적권을 사용해야할 상황
            if(k>0 && n<e){
                n+=pq.poll();
                k--;
            }
            n-=e;
            if(n<0) break;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n=7;
        int k=3; //무적권
        int[]enemy = {4, 2, 4, 5, 3, 3, 1}; //순서 안바뀜!
        System.out.println(solution(n,k,enemy));
    }
}
