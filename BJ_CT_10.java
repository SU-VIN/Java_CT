import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//세그먼트 트리
public class BJ_CT_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int[] narr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            narr[i]=Integer.parseInt(st.nextToken());
        }

        int m =Integer.parseInt(br.readLine());
        int[] marr= new int[m];
        st= new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){
            marr[i]=Integer.parseInt(st.nextToken());
        }

        int[] check = new int[m];
        Arrays.fill(check,0);

        String str= "";
//--------------------입력처리-----------------------------------

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(marr[i]==narr[j]) check[i]=1;
            }
        }

        for(int i=0;i<check.length;i++){
            str+=check[i]+" ";
        }
        System.out.println(str);
    }
}
