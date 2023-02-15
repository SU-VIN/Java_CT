import java.util.ArrayList;
import java.util.HashMap;

public class PRO_CT_25 {
    //카카오 레벨2 오픈채팅방
    public String[] solution(String[] record) {
        HashMap<String,String> nickName = new HashMap<>();
        HashMap<String,String> message = new HashMap<>();
        message.put("Enter","님이 들어왔습니다.");
        message.put("Leave","님이 나갔습니다.");

        for(String s:record){
            String[] split=s.split(" ");
            if(split.length==3){ //leave는 문자열의 길이가 2임 닉네임이 바뀌는 경우는 enter, change
                nickName.put(split[1],split[2]);
            }
        }

        ArrayList<String> answer = new ArrayList<>();

        for(String s :record){
            String[] split=s.split(" ");
            if(message.containsKey(split[0])){ //enter,leave만 봄
                answer.add(nickName.get(split[1])+message.get(split[0]));
            }
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] record ={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    }
}
