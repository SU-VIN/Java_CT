
import java.util.HashMap;
//레벨1 성격유형검사 카카오
public class PRO_CT_11 {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        StringBuilder sb= new StringBuilder(answer);
        HashMap<Character,Integer> mbti = new HashMap<>();

        for(int i=0;i<survey.length;i++){
            if(choices[i]<=3){
                char ch = survey[i].charAt(0);
                mbti.put(ch,mbti.getOrDefault(ch,0)+4-choices[i]);

            }else if(choices[i]>=5){
                char ch = survey[i].charAt(1);
                mbti.put(ch,mbti.getOrDefault(ch,0)+choices[i]-4);
            }
        }

        sb.append(mbti.getOrDefault('R',0)>=mbti.getOrDefault('T',0)?'R':'T');
        sb.append(mbti.getOrDefault('C',0)>=mbti.getOrDefault('F',0)?'C':'F');
        sb.append(mbti.getOrDefault('J',0)>=mbti.getOrDefault('M',0)?'J':'M');
        sb.append(mbti.getOrDefault('A',0)>=mbti.getOrDefault('N',0)?'A':'N');

        return sb.toString();
    }
    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        System.out.println(solution(survey,choices));
    }
}
