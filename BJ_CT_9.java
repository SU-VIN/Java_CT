import java.util.Scanner;
import java.util.Stack;
//그룹 단어 체커 -문자열- 실버5
public class BJ_CT_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            String s = ""; //압축된 문자열 받을 변수
            String str = sc.next(); //문자열 입력해주고
            Stack<Character> st = new Stack<>();//압축된 문자열 우선은 스택으로 받아줘요
            st.push(str.charAt(0));
            for (int k = 1; k < str.length(); k++) { //문자열 압축!
                if (st.peek() != str.charAt(k)) st.push(str.charAt(k));
            }

            for (int l = 0; l < st.size(); l++) s += st.get(l); //스택에서 스트링변수로 옮겨줍니다


            for (int j = 0; j < s.length(); j++) {
                if(s.indexOf(s.charAt(j),j+1)>=0){//포함! 그룹단어 아님
                    result++;
                    break;
                }
            }

        }
        System.out.println(n-result); //총단어수에서 그룹단어가 아닌 단어를 뺌
    }}

