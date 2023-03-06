import java.util.PriorityQueue;

public class PRO_CT_34 {
    //레벨2 더 맵게
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        if(pq.peek()>=K) return answer; //처음부터 완성인경우

        int min = pq.peek();
        while (min<K && pq.size()>1){
            int num1=pq.poll();
            int num2=pq.poll();
            int sum = num1+(num2*2);
            pq.add(sum);
            min=pq.peek();

            answer++;

        }

        if(min<K) return -1;

        return answer;
    }
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k=7;
        System.out.println(solution(scoville,k));
    }
}
