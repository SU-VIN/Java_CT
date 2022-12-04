import java.util.Scanner;
import java.util.Stack;
//그룹 단어 체커 -문자열- 실버5
public class BJ_CT_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        int flag =0;


        for (int i = 0; i < n; i++) {
            String s = "";
            String str = sc.next();
            Stack<Character> st = new Stack<>();
            st.push(str.charAt(0));
            for (int k = 1; k < str.length(); k++) {
                if (st.peek() != str.charAt(k)) st.push(str.charAt(k));
            }

            for (int l = 0; l < st.size(); l++) s += st.get(l);


            for (int j = 0; j < s.length(); j++) {
                if(s.indexOf(s.charAt(j),j+1)>=0){//포함 그룹단어 아님
                    result++;
                    break;
                }
            }

        }
        System.out.println(n-result);
    }}

