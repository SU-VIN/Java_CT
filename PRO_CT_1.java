import java.util.ArrayList;
import java.util.List;
//프로그래머스 lv1 모의고사 완전탐색
public class PRO_CT_1 {
    public static int[] solution(int[] answers) {
        int[] a ={1,2,3,4,5};
        int[] b= {2,1,2,3,2,4,2,5};
        int[] c= {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};


        for(int i=0;i<answers.length;i++){
            if(answers[i]==a[i%a.length]) score[0]++;
            if(answers[i]==b[i%b.length]) score[1]++;
            if(answers[i]==c[i%c.length]) score[2]++;

        }

        int max = Math.max(score[0],Math.max(score[1],score[2]));

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<score.length;i++){
            if(score[i]==max){
                result.add(i+1);
            }
        }

        int[] arr= new int[result.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=result.get(i);
        }

        return arr;

    }
    public static void main(String[] args) {
        int[] answer = {1,3,2,4,2};
        System.out.println(solution(answer));

    }
}
