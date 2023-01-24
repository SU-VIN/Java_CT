import java.util.ArrayDeque;
//레벨2 주식가격
public class PRO_CT_17 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                deque.addLast(prices[j]); //데큐에 add해주고
                if(prices[i]>prices[j]) { //만약 넣은 값이 나보다 작다면
                    break; //break해주고
                }
            }
            answer[i]=deque.size(); //지금까지의 데큐 사이즈를 결과값에 삽입
            deque.clear(); //다음 연산을 위해 clear
            if(i==prices.length-1) answer[i]=0; //마지막은 무조건 0 이 들어가야하기때문에 0 삽입
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] prices = {1,2,3,2,3};
        System.out.println(solution(prices));

    }
}
