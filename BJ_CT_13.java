import java.io.*;
import java.util.StringTokenizer;
// 실버3 구간합구하기4 누적합 사용
public class BJ_CT_13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st=new StringTokenizer(br.readLine());
        arr[1]=Integer.parseInt(st.nextToken());
        for(int i=2;i<=N;i++){
            arr[i]=arr[i-1]+Integer.parseInt(st.nextToken());
        }
        // 5 9 12 14 15
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write((arr[end]-arr[start-1])+"\n");
        }

        bw.flush();

    }
}
