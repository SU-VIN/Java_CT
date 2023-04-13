import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//골드4 백트래킹 좋은수열
public class BJ_CT_30 {
    static int N;
    static String result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        backtracking("");

    }

    private static void backtracking(String result){
        //리턴조건
        if(result.length()==N){
            System.out.println(result);
            System.exit(0); //현재 실행하고 있는 프로세스 강제 종료
        }

        //재귀 돌아가용~
        //1,2,3 밖에 없으니 3번 돌아요
        for (int i = 1; i <=3; i++) {
            if(isGood(result+i)){
                backtracking(result+i);
            }
        }
    }
    
    private static boolean isGood(String str){
        int length = str.length()/2;
        for (int i = 1; i <= length; i++) {
            if(str.substring(str.length()-i).equals(str.substring(str.length()-2*i,str.length()-i))){
                return false;
            }

        }

        return true;
    }
}
