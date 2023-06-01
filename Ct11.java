import java.util.Stack;

//같은 숫자는 싫어
public class Ct11 {
//    public int[] solution(int []arr) {
//        int[] answer = {};
//        Stack<Integer> result = new Stack<Integer>();
//        for(int i=0;i<arr.length-1;i++){
//            if(arr[i]!=arr[i+1]){
//                result.push(arr[i]);
//            }
//            if(i==arr.length-2){
//                result.push(arr[i+1]);
//            }
//
//        }
//
//        answer = new int[result.size()];
//        for(int i=0;i<result.size();i++){
//            answer[i]=result.get(i);
//        }
//
//
//        return answer;
//    }

    public static int[] solution(int []arr) {;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(st.isEmpty()){
                st.push(arr[i]);
            }else{
                if(st.peek()!=arr[i]){
                    st.push(arr[i]);
                }
            }


        }
        int[] answer = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            answer[i]=st.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] arr={1,1,3,3,0,1,1};
        System.out.println(solution(arr));

    }
}
