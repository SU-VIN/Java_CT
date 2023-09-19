import java.util.HashMap;

public class 의상 {
    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String,Integer>hash = new HashMap<>();

        for(int i=0;i<clothes.length;i++){
            hash.put(clothes[i][1],hash.getOrDefault(clothes[i][1],0)+1);
        }

        for (Integer value : hash.values()) {
            answer*=(1+value);
        }



        return answer-1;
    }
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
}
