import java.io.IOException;
import java.util.Scanner;


//나누기 - 브론즈2
public class BJ_CT_3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(); //1000
        int f=sc.nextInt(); //3
        String num = Integer.toString(n); //1000을 문자열로
        int end=0; //변경시킬 마지막 두자리 수
        String front = ""; //마지막 두 자리를 제외한 숫자
        String back = ""; //마지막 두 자리



        while (true){
            front = num.substring(0,num.length()-2); //10
            if(Integer.toString(end).length()==1){ //한자리 수 일때 00~09
                back = String.format("%02d",end);
            }else{//두자리 수 일때
                back = Integer.toString(end);
            }


            String result = front+back;



            n=Integer.parseInt(result);

            if(n%f==0) break;
            else end++;
        }
        System.out.println(back);


        //n의 가장 뒤 두 자리를 바꿔 n을 f로 나누어 떨어지게
        //00 01 02 .. 10 11 ..98 99

    }
}
