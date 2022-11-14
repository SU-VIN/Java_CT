//연월일 달력 테케만 통과
import java.util.Scanner;

public class SWEA_CT_4 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int count= 0;
        float result=0;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String date = "";
            for(int i=0;i<8;i++){
                count++;
                date+=sc.nextInt();
                if(count==4||count==6){
                    date+="/";
                }
            }
            String[] arr= date.split("/");
            if(Integer.parseInt(arr[1])>0&&Integer.parseInt(arr[1])<=12){
                //정상일때
                if(Integer.parseInt(arr[1])<=7){
                    if(Integer.parseInt(arr[1])%2==0){
                        if(Integer.parseInt(arr[1])==2){
                            if(Integer.parseInt(arr[2])>0&&Integer.parseInt(arr[2])<=28){
                                date = date;
                            }else{
                                date ="-1";
                            }
                        }else{
                            if(Integer.parseInt(arr[2])>0&&Integer.parseInt(arr[2])<=30){
                                date = date;
                            }else{
                                date ="-1";
                            }

                        }

                    }else{
                        if(Integer.parseInt(arr[2])>0&&Integer.parseInt(arr[2])<=31){
                            date = date;
                        }else{
                            date="-1";
                        }
                    }
                }else{
                    //7월이상
                    if(Integer.parseInt(arr[1])%2==0){
                        if(Integer.parseInt(arr[2])>0&&Integer.parseInt(arr[2])<=31){
                            date = date;
                        }else{
                            date ="-1";
                        }
                    }else{
                        if(Integer.parseInt(arr[2])>0&&Integer.parseInt(arr[2])<=30){
                            date = date;
                        }else{
                            date ="-1";
                        }

                    }
                }
            }else{
                date ="-1";
            }

            System.out.println("#"+test_case+" "+date);

            date="";
        }
    }
}
