import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

//D3 비밀번호
public class SWEA_CT_18 {
    public static void main(String[] args) {
        int tc = 10;
        Scanner sc = new Scanner(System.in);
        String str = "";

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= tc; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            String lock = sc.next();
            for (int j = 0; j < N; j++) {
                arr[j]=Integer.parseInt(lock.substring(j,j+1));
            }

            //stack
            Stack<Integer> st = new Stack<>();
            for (int j = 0; j < N; j++) {
                if(st.isEmpty()){//스택이 비었으면 무조건 넣어줌
                    st.push(arr[j]);
                }else{

                    if(st.peek()==arr[j]){
                        st.pop();
                    }else{
                        st.push(arr[j]);
                    }

                }

            }

            str="";
            for (int j = 0; j < st.size(); j++) {
                str+=st.get(j);
            }

            dq.addLast(Integer.parseInt(str));

        }

        for (int i = 1; i <= tc; i++) {
            System.out.println("#"+i+" "+dq.pollFirst());

        }
    }
}
