import java.util.ArrayDeque;

//레벨 4 카카오 행렬과 연산
public class PRO_CT_15 {
    public static int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = new int[rc.length][rc[0].length];
        ArrayDeque<Integer>left = new ArrayDeque<>();
        ArrayDeque<Integer>right = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>>mid = new ArrayDeque<>();

        //큐에 데이터 받기
        //O(N) N=r*c = 100,000
        for(int i=0;i<rc.length;i++){
            left.addLast(rc[i][0]);
            ArrayDeque<Integer> midQueue = new ArrayDeque<>();
            for(int j=1;j<rc[0].length-1;j++){
                midQueue.addLast(rc[i][j]);

            }
            mid.addLast(midQueue);
            right.addLast(rc[i][rc[i].length-1]);
        }

        //O(N) N=100,000
        for(String operation:operations){
            if("ShiftRow".equals(operation)){
                left.addFirst(left.pollLast()); //O(1)
                mid.addFirst(mid.pollLast());//O(1)
                right.addFirst(right.pollLast());//O(1)

            }else{
                mid.peekFirst().addFirst(left.pollFirst());//O(1)
                right.addFirst(mid.peekFirst().pollLast());//O(1)
                mid.peekLast().addLast(right.pollLast());//O(1)
                left.addLast(mid.peekLast().pollFirst());//O(1)
            }
        }


        for(int i=0;i<answer.length;i++){
            answer[i][0]=left.pollFirst();
            ArrayDeque<Integer> midqueue=mid.pollFirst();
            for(int j=1;j<answer[i].length-1;j++){
                answer[i][j]=midqueue.pollFirst();
            }
            answer[i][answer[i].length-1]=right.pollFirst();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][]rc = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String[] operatoins = {"Rotate", "ShiftRow"};

        System.out.println(solution(rc,operatoins));
    }
}
