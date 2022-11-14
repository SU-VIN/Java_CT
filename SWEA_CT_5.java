//연월일 달력 재코딩
import java.util.Scanner;

public class SWEA_CT_5 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int count= 0;
        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next(); //문자열 한방에 받을 수 있음
            //2000 02 25
            int year = Integer.parseInt(str.substring(0,4));
            int month = Integer.parseInt(str.substring(4,6));
            int day = Integer.parseInt(str.substring(6));

            if(month>0&&month<13&&day<=days[month]){
                System.out.println("#"+test_case+" "+ String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day));
            }else{
                System.out.println("#"+test_case+" "+"-1");
            }

        }
    }
}
