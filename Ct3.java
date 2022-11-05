//두 정수 사이의 합
public class Ct3 {
    public static long solution(int a, int b) {
        long answer = 0;
        for(int i=Math.min(a,b);i<=Math.max(a,b);i++){
            answer+=i;
        }
        return answer;
    }
    public static void main(String[] args) {
        int a=3;
        int b=5;
        System.out.println(solution(a,b));
    }
}
