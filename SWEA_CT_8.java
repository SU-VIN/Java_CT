//무한 문자열
import java.util.Scanner;

public class SWEA_CT_8{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        String x;
        String y;
        for(int test_case = 1; test_case <= T; ++test_case) {
            x=sc.next();
            y=sc.next();
            int xlen = x.length();
            int ylen = y.length();
            int gcd = getGCD(xlen,ylen);
            int lcm = (xlen*ylen)/gcd; //최소공배수

            String X = x;
            String Y = y;

            if(xlen==ylen){//길이가 같을때
                if(x.contains(y)){
                    System.out.println("#"+test_case+" "+"yes");
                }else{
                    System.out.println("#"+test_case+" "+"no");
                }
            }else{//길이가 다를때
                while (X.length() != lcm){
                    X+=x;
                }
                while (Y.length()!=lcm){
                    Y+=y;
                }
                if(X.equals(Y)){
                    System.out.println("#"+test_case+" "+"yes");
                }else{
                    System.out.println("#"+test_case+" "+"no");
                }
            }

        }

    }
    //최대공약수 구하기
    public static int getGCD(int x,int y){
        if(x%y==0){
            return y;
        }
        return getGCD(y,x%y);
    }
}
