import java.util.Collections;
import java.util.PriorityQueue;
//레벨3 이중우선순위큐
public class PRO_CT_38 {
    public static int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer>pq =new PriorityQueue<>(); //오름차순 pq
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < operations.length; i++) {
            if(operations[i].contains("I")){ //큐에 삽입
                pq.add(Integer.parseInt(operations[i].substring(2)));


            }else{//삭제할시 D 1 == 최댓값 삭제 D-1 == 최솟값 삭제
                if(!pq.isEmpty() && operations[i].contains("-1")){ //최솟값
                    pq.poll();
                }else if(!pq.isEmpty()&&operations[i].contains("1")){//최대값
                    PriorityQueue<Integer>pqDes =new PriorityQueue<>(Collections.reverseOrder());
                    pqDes.addAll(pq);
                    pqDes.poll();
                    pq.clear();
                    pq.addAll(pqDes);

                }

            }
        }
        if(pq.size()==0){
            return new int[]{0,0};
        }

        while (pq.size()>0){
            int num =pq.poll();
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        return new int[] {max,min};
    }
    public static void main(String[] args) {
        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        System.out.println(solution(operations));

    }
}
