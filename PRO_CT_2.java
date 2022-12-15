//레벨 1 콜라문제
public class PRO_CT_2 {
    public static int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            answer+=(n/a)*b;
            int rest = (n/a)*b+(n%a);
            n=rest;
        }
        return answer;
    }
    public static void main(String[] args) {
        int a=3; //a개의 병을 가져다주면
        int b=1; //새로운b병을 줌
        int n=20; //가져다줄 빈병 수
        System.out.println(solution(a,b,n));
    }
}
