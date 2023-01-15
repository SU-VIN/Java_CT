import java.util.Arrays;
import java.util.Stack;

public class PRO_CT_15 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] arr= new int[progresses.length];
        Stack<Integer> st = new Stack<>();
        int count =1;

        for(int i=0;i<arr.length;i++){
            arr[i]=(int)Math.ceil((100-progresses[i])/speeds[i]);
        }

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    st.push(count);
                    count=1;
                    break;
                }else{
                    count++;
                }
            }
        }

        int[] result = new int[st.size()];
        for(int i=0;i<result.length;i++){
            result[i]=st.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] progresses = {93,39,50};
        int[] speeds = {1,30,5};
        System.out.println(solution(progresses,speeds));
    }
}
