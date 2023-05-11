import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//D3 최대상금
public class SWEA_CT_12 {
    static String num;
    static int cnt;
    static int[] arr;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = st.nextToken();
            cnt = Integer.parseInt(st.nextToken());
            arr = new int[num.length()];
            for (int j = 0; j < arr.length; j++) {
                arr[j]=Integer.parseInt(num.substring(j,j+1));
            }
            max = 0;

            if(num.length()<cnt){
                cnt=num.length();
            }
            //시작
            dfs(0,0);
            dq.addLast(max);
            
        }

        //출력
        for (int i = 1; i <=T; i++) {
            System.out.println("#"+i+" "+dq.pollFirst());
            
        }
    }


    public static void dfs(int start,int count){
        //리턴조건
        if(count==cnt){
            String str = "";
            for(int n : arr){
                str+=Integer.toString(n);
            }

            max = Math.max(max,Integer.parseInt(str));
            return;

        }

        for (int i = start; i < num.length(); i++) {
            for (int j = i+1; j < num.length(); j++) {
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

                dfs(i,count+1);

                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

            }
            
        }

    }
}