import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//레벨2 귤고르기 해시
public class PRO_CT_30 {

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //vaule기준으로 정렬
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys,(o2, o1)->(map.get(o1).compareTo(map.get(o2))));

        for(Integer key : keys){
            answer+=map.get(key);
            cnt++;
            if(answer>=k)break;
        }
        return cnt;
    }
    public static void main(String[] args) {

        int k = 4;
        int tangerine[]= {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k,tangerine));

    }
}
