//x만큼 간격이 있는 n개의 숫자
import  java.util.Stack;
public class Ct2 {

    public static Stack<Long> solution(int x, int n) {
        Stack<Long> answer = new Stack<Long>();
        answer.push((long) x);
        for(int i=0;i<n-1;i++){
            answer.push(answer.get(i)+x);
        }
        return answer;
    }


    public static void main(String[] args) {
        int x=2;
        int n=5;
        System.out.println(solution(x,n));
    }
}
