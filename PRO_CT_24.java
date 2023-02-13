import java.util.PriorityQueue;

public class PRO_CT_24 {
    //징검다리 건너기 레벨3
    private  static class Stone{
        int idx,val;

        public Stone(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public static int solution(int[] stones, int k) {
        PriorityQueue<Stone>pq = new PriorityQueue<>((o1,o2)->Integer.compare(o2.val,o1.val));
        int count=0;
        int i=0;
        for(i=0;i<k;i++){
            pq.add(new Stone(i,stones[i]));
        }

        int answer = pq.peek().val;

        while (i<stones.length){
            pq.add(new Stone(i,stones[i]));
            i++;

            while (pq.peek().idx<i-k) {
                count++;
//                System.out.println(count+"번 지웠음 지운 숫자는"+pq.peek().idx);
//                System.out.println("i="+i);
                pq.poll(); //이미 지나온돌이라면 지워


            }

            answer=Math.min(answer,pq.peek().val);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k=3;
        System.out.println(solution(stones,k));
    }


}
