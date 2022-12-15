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

        int max = Math.max(score[0],Math.max(score[1],score[2]));//3개의 값중 최대 구하기

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<score.length;i++){
            if(score[i]==max){ //스코어의 값이 최대값과 같다면
                result.add(i+1); //리스트에 추가! ( 인덱스가 0부터 시작하기때문에 1을 더해줌)
            }
        }

        int[] arr= new int[result.size()]; //배열로 리턴해야하기에 다시 리스트 -> 배열
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
