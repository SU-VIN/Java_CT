//최솟값 만들기
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Ct7 {
    public static int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<A.length;i++){
            answer+=A[i]*B[A.length-1-i];
        }

        return answer;
    }
    public static void main(String[] args) {
        int []A ={1,4,2};
        int []B={5,4,4};
        System.out.println(solution(A,B));
    }
}
