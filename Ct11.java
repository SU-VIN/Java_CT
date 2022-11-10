import java.util.Stack;

//같은 숫자는 싫어
public class Ct11 {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> result = new Stack<Integer>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                result.push(arr[i]);
            }
            if(i==arr.length-2){
                result.push(arr[i+1]);
            }

        }

        answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }


        return answer;
    }
    public static void main(String[] args) {
        Ct11 sol = new Ct11();
        int[] arr={1,1,3,3,0,1,1};
        System.out.println(sol.solution(arr));

    }
}
