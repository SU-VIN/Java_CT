import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//삼성 sw기출 실버3 퇴사 브루트 포스

public class BJ_CT_47 {
    static int N;
    static int[] time;
    static int[] pay;
    static boolean[] visited;
    static int result;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        time = new int[N+1];
        pay = new int[N+1];
        visited = new boolean[N+1];

        //데이터 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i]= Integer.parseInt(st.nextToken());
            pay[i]= Integer.parseInt(st.nextToken());
        }

        result=0;

  
        cal(1,0,0);
                

        System.out.println(result);

    }
    //다음 인덱스 index + time[index]
    static void cal(int day,int money,int nowMoney){


        //리턴조건
        if(day>N+1){
            result = Math.max(result,money-nowMoney);
            return;
        }else if(day==N+1){
            result = Math.max(result,money);
        }

        for (int i = day; i <=N; i++) {
            cal(time[i]+i,money+pay[i],pay[i]);
        }

        
    }
}
