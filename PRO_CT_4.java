import javax.print.DocFlavor;
import java.util.Stack;
//레벨1 카카오 다트게임
public class PRO_CT_4 {
    public static int solution(String dartResult) {
        int answer = 0;
        String num=""; //int가아닌 string으로 하는 이유는 숫자가 2자리 일수도 있기때뮨
        int[] arr=new int[3]; //3번의 점수가 나오기때문에
        int index=0;


        for(int i=0;i<dartResult.length();i++){
            switch(dartResult.charAt(i)){
                //SDT일경우 제곱 계싼
                case'S':
                    arr[index]=(int)Math.pow(Integer.parseInt(num),1);
                    index++;
                    num="";
                    break;
                case'D':
                    arr[index]=(int)Math.pow(Integer.parseInt(num),2);
                    index++;
                    num="";
                    break;
                case'T':
                    arr[index]=(int)Math.pow(Integer.parseInt(num),3);
                    index++;
                    num="";
                    break;
                    //SDT끝낸후 index를 증가시켜주므로 * # 경우엔 index-1해서 계산 해야함
                case'*':
                    arr[index-1]*=2;
                    if(index>=2) arr[index-2]*=2; //첫번째에 나온다면 패스
                    break;
                case'#':
                    arr[index-1]*=-1;
                    break;
                default:
                    num+=String.valueOf(dartResult.charAt(i));
                    break;

            }
        }

        for(int i=0;i<arr.length;i++){
            answer+=arr[i];
        }

        return answer;
}
    public static void main(String[] args) {
        String dartResult= "1D2S#10S";
        System.out.println(solution(dartResult));
    }
}
