//간단한 369게임.
import java.util.Scanner;

public class SWEA_CT_7 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        char temp;
        String num;
        String result ="";
        int count =0;
        for(int i=1;i<=T;i++)
        {
            num=Integer.toString(i);

            for(int j=0;j<num.length();j++){
                temp=num.charAt(j);
                if((int)temp%3==0&&temp!='0'){
                    count ++;
                }
            }
            if(count>0){
                for(int k=0;k<count;k++){
                    result+="-";
                }
            }else{
                result+=num;
            }

            result+=" ";
            count =0;

        }
        System.out.println(result);


    }
}
