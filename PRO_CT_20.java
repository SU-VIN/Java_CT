import java.util.ArrayDeque;

//기능개발 레벨2
public class PRO_CT_20 {

    public static int[] solution(int[] progresses, int[] speeds) {

        int[] arr =new int[progresses.length];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayDeque<Integer> score = new ArrayDeque<>();

        //데이터 계산해서 새롭게 만들기
        for(int i=0;i<progresses.length;i++){
            arr[i]=(int)Math.ceil(((double) 100-progresses[i])/(double)speeds[i]);
        }

        for(int i=0;i<arr.length;i++){
            if(i==0) deque.addLast(arr[i]); //처음 데이터는 무조건 넣어주고
            else{
                if(arr[i]<=deque.peekFirst()){ //peekFirst보다 값이 작다면
                    deque.addLast(arr[i]); //데큐에 계속 값을 넣어주고
                    if(i==arr.length-1)score.addLast(deque.size()); //마지막 값일때 처리

                }else{ //크다면
                    score.addLast(deque.size()); //결과를 저장하는 score에 현재 데큐의 사이즈를 넣어줌
                    deque.clear();//일이 끝났으니 클리어 해주고
                    deque.addLast(arr[i]); //현재의 값을 데큐에 넣어줌
                    if(i==arr.length-1)score.addLast(deque.size());//마지막 값일때 처리
                }
            }

        }

        //값을 담을 배열을 만들어주고
        int[] result =new int[score.size()];

        //하나씩 배열에 담아줌
        for(int i=0;i<result.length;i++){
            result[i]=score.pollFirst();
            System.out.println(result[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] progresses={95, 90, 99, 99, 80, 99};
        int[] speeds={1, 1, 1, 1,1};
        System.out.println(solution(progresses,speeds));

    }
}
