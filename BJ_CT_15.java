import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//최소힙
public class BJ_CT_15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int x= Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    pq.add(x);
                }
            }
        }

        System.out.println(sb);

    }
}
