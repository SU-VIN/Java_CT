import java.util.Scanner;
import java.util.Stack;
//스택-올바른 괄호
public class CT17 {
        public static void main(String args[]) throws Exception
        {
            Scanner sc = new Scanner(System.in);
            String T;
            T=sc.next();
            char[] arr = new char[T.length()];

            Stack<Character> st = new Stack<Character>();

            String result ="YES";

            for(int i=0;i<T.length();i++) {
                arr[i]=T.charAt(i);
            }

            for(int i=0;i<arr.length;i++) {
                if(arr[i]=='('){
                    st.push(arr[i]);
                }else {
                    if(st.size()==0) {
                        result="NO";
                        break;
                    }

                    st.pop();
                }

            }
            if(st.size()>0) {
                result="NO";
            }

            System.out.println(result);


        }
}
