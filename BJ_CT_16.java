import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_CT_16 {
    //회사에 있는 사람 - 해시 - 실버5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String,String> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        //데이터 삽입
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(),st.nextToken());
        }

        //계산
        for(String key : map.keySet()){
            if (map.get(key).equals("enter") ) {
                result.add(key);

            }
        }

        //정렬
        Collections.sort(result, Collections.reverseOrder());

        //출력
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

    }
}
