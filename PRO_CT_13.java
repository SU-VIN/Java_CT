import java.util.StringTokenizer;
//레벨2 JadenCase
public class PRO_CT_13 {
    public static String solution(String s)  {
        StringBuilder sb = new StringBuilder();
        String[] arr =s.toLowerCase().split(" "); //소문자로 전환한 후 split을 통해 배열에 넣어줌

        for(int i=0;i<arr.length;i++){
            if(arr[i].length()==0) sb.append(" "); //해당 배열이 공백문자라면 그대로 공백을 삽입해줌
            else{
                sb.append(arr[i].substring(0,1).toUpperCase()); //아닐시 맨첫단어를 대문자로 변경하여 삽입
                sb.append(arr[i].substring(1));//첫단어가 아닌 나머지는 그대로 삽입해주고
                sb.append(" ");//띄어쓰기용 공백을 추가해준다
            }
        }

        if(s.substring(s.length()-1).equals(" ")) return sb.toString(); //원본 문자열의 마지막 문자가 공백이였다면 그래도 리턴
        return sb.toString().trim();//아니라면 trim을 통해 마지막 공백 제거 후 리턴
    }
    public static void main(String[] args) {
        String s = "3people     unFollowed me";
        System.out.println(solution(s));
    }
}
