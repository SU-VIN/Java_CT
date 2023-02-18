import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//베스트셀러 - 해시 - 실버4
public class BJ_CT_17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            String name = br.readLine();
            map.put(name,map.getOrDefault(name,0)+1);
        }


        //정렬
        List<Map.Entry<String,Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()>o2.getValue())return-1;
                else if (o1.getValue()<o2.getValue()) {
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });


        System.out.println(list.get(0).getKey());

    }
}
