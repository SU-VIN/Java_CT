import java.util.Arrays;
import java.util.Collections;
//레벨1 과일장수
public class PRO_CT_9 {
    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] arr= new Integer[score.length];
        for(int i=0;i<score.length;i++){
            arr[i]=score[i];
        }
        Arrays.sort(arr, Collections.reverseOrder()); //내림차순 정렬
        //012 345 678 91011
        //444 444 222 21 1
        for(int i=m-1;i<arr.length;i+=m){
            if(arr[i]>k){
                answer+=k*m;
            }else{
                answer+=arr[i]*m;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int k=3;
        int m=4;
        int[] score = {1,2,3,1,2,3,1};
        System.out.println(solution(k,m,score));

    }
}
