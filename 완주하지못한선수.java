

import java.util.HashMap;

public class 완주하지못한선수 {

        public static String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String,Integer>hash = new HashMap<String,Integer>();

            for(String name : participant){
                hash.put(name,hash.getOrDefault(name,0)+1);
            }


            for(String name : completion){
                hash.put(name,hash.getOrDefault(name,0)-1);
            }

            for(String name : hash.keySet()){
                if(hash.get(name).equals(1)){
                    return name;
                }
            }
            System.out.println(hash);
            return answer;
        }
    
    public static void main(String[] args) {
        String[] participant={"mislav", "stanko", "mislav", "ana"};
        String[]completion={"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
