import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//백준 생태학 해시 실버2
public class BJ_CT_18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer>map = new HashMap<>();
        float total=0;
        String tree= "";

        while ((tree=br.readLine())!=null){
            total++;
            map.put(tree,map.getOrDefault(tree,0)+1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for(String s: keySet){
            System.out.print(s+" ");
            System.out.println(String.format("%.4f",map.get(s)/total*100));
        }


    }
}
