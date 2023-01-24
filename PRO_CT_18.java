import java.util.Stack;

//레벨2 괄호 회전하기
public class PRO_CT_18 {
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='('||s.charAt(j)=='{'||s.charAt(j)=='['){
                    stack.push(s.charAt(j));
                }else{
                    if(!stack.isEmpty()&&s.charAt(j)==')'&&stack.peek()=='('){
                        stack.pop();
                    }else if(!stack.isEmpty()&&s.charAt(j)=='}'&&stack.peek()=='{'){
                        stack.pop();
                    }else if(!stack.isEmpty()&&s.charAt(j)==']'&&stack.peek()=='['){
                        stack.pop();
                    }else{
                        stack.push(s.charAt(j));
                    }
                }
            }
            if(stack.size()==0) answer++;
            stack.clear();
            s=rotate(s);
        }


        return answer;
    }

    public static String rotate(String s){
        String first = s.substring(0,1);
        String rest = s.substring(1);
        s=rest+first;
        return s;
    }

    public static void main(String[] args) {
        String s = "{{{}";
        System.out.println(solution(s));
    }
}
