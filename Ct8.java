//짝지어 제거하기
import java.util.Stack;

public class Ct8 {

    public int solution(String s)
    {
        Stack<Character> result = new Stack<Character>(); // size == 0
        for(int i=0;i< s.length();i++){ // length = 6 // 012345
            char c = s.charAt(i);
            if(!result.isEmpty()&&result.peek()==c){
                result.pop();
            }else {
                result.push(c);
            }

        }
        return result.size()==0?1:0;
    }
    public static void main(String[] args) {
        Ct8 sol = new Ct8();
        String s ="baabaa";
        System.out.println(sol.solution(s));
    }
}
