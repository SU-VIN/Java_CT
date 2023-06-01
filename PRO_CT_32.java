import java.util.Collections;
import java.util.PriorityQueue;
//우선순위 큐 레벨2 프로세스(구 프린터)
public class PRO_CT_32 {

//    public static int solution(int[] priorities, int location) {
//        int answer = 0;
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//
//        for(int i=0;i<priorities.length;i++){
//            queue.add(priorities[i]);
//        }
//
//        while (!queue.isEmpty()){
//            for(int i=0;i<priorities.length;i++){
//                if(priorities[i]==queue.peek()){ //우선순위큐에서 가장 값이 큰값과 같다면
//                    if(i==location){ //그 값의 index가 location과 같다면
//                        answer++;
//                        return answer;
//                    }
//                    //우선순위 큐에서 가장 큰값과 같지만 그 값의 index가 location과는 같지 않다면
//                    //뽑아줌
//                    queue.poll();
//                    answer++;
//                }
//            }
//        }
//        return answer;
//    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                if(pq.peek()==priorities[i]){
                    if(i==location){
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }
}
