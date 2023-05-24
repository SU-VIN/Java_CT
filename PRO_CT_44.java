import java.util.HashMap;
//레벨1 해시 완주하지 못한 선수 30m
public class PRO_CT_44 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer>name = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            name.put(participant[i],name.getOrDefault(participant[i],0)+1);
        }

        for (int i = 0; i < completion.length; i++) {
            name.put(completion[i],name.getOrDefault(completion[i],0)-1);
        }

        for(String key : name.keySet()){
            if(!name.get(key).equals(0)){//키에 매핑된값이 0이 아니라면
                answer=key;
                break;
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant,completion));
    }
}
