import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_CT_45 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] train = new int[N+2];

        //데이터 삽입
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            train[i]=Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        //기차 누적합
        for (int i = 1; i <=N; i++) {
            train[i]+=train[i-1];
        }
    }
}
