import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준 골드5 개똥벌레 누적합
public class BJ_CT_43 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[] suk = new int[H+2];
        int[] jong = new int[H+2]; //앞뒤로 0이 존재해야하므로 본배열크기의 +2를 해줌
        int[] sum = new int[H+1];
        
        //데이터 삽입
        for (int i = 0; i < N; i++) {
            if(i%2==0){ //석순일때
                suk[Integer.parseInt(br.readLine())]++;
                
            }else{//종유석일때
                //종유석은 index번호를 반대로 해줘야함
                //ex) 4 3 2 1
                jong[H-Integer.parseInt(br.readLine())+1]++;
                
            }
        }

        //누적합 구하기
        for (int i = 1; i <= H; i++) {
            suk[i]+=suk[i-1];
            
        }
        
        //종유석은 거꾸로 구해줘야함
        for (int i = H; i >=1; i--) {
            jong[i]+=jong[i+1];
           
        }

        int cnt = 0;
        int MIN = Integer.MAX_VALUE;
        //구간합 구해서 석순 종유석 합치기
        for (int i = 1; i <= H; i++) {
            sum[i]=(suk[H]-suk[i-1])+(jong[1]-jong[i+1]);

            if(sum[i]<MIN){
                MIN = sum[i];
                cnt=1;

            }else if(sum[i]==MIN){
                cnt++;
            }
        }

        System.out.println(MIN+" "+cnt);
    }
}
