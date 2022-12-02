import java.util.Scanner;
import java.util.Stack;

public class BJ_CT_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result =0;
        Stack<Character> st = new Stack<>();


        for(int i=0;i<n;i++){
            String s = "";
            String str = sc.next();
            st.push(str.charAt(0));
            for(int k=1;k<str.length();k++){
                if(st.peek()!=str.charAt(k)) st.push(str.charAt(k));
            }

            for(int l=0;l<st.size();l++) s+=st.get(l);

            for(int j=0;j<s.length();j++){
                if(s.indexOf(s.charAt(j),j+1)>=0) {
                    result++;
                    break;
                }

            }
        }

        System.out.println(result);
    }
}
