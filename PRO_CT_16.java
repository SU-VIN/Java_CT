import java.util.ArrayDeque;
//레벨2 올바른 괄호
public class PRO_CT_16 {
    static boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> deque = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                deque.addLast(s.charAt(i)); //데큐에 넣어줌
            }else{
                if(!deque.isEmpty()&&deque.peek()=='('){ //&&연산자를 이용해 데큐가 비어있지 않은지부터 봐야함
                    deque.pollLast(); //( ) 이 짝지어졌을때 하나를 pop해줌
                }else{
                    deque.addLast(s.charAt(i)); //올바른 괄호가 아니면 add해줌
                }
            }
        }

        return deque.size()==0?true:false; //데큐의 크기가 0이라면 올바른 괄호
    }

    public static void main(String[] args) {
        String s= "(())()";
        System.out.println(solution(s));
    }
}
