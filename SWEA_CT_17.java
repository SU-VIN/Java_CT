import java.io.IOException;
import java.util.Scanner;
//D3 화섭이의 정수 나열

public class SWEA_CT_17 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int T = 1; T <= tc; T++) {
            int N = sc.nextInt();
            String str = "";


            for (int i = 0; i < N; i++) {
                str+=sc.next();

            }
            int start= 0;

            while (true){

                if(!str.contains(String.valueOf(start))){
                    System.out.println("#" + T + " " + start);
                    break;
                }
                start++;
            }


        }
    }


}
