import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
//레벨2 전화번호 목록
public class PRO_CT_28 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<phone_book.length;i++){
            set.add(phone_book[i]);
        }
        System.out.println(set);

        for(String s:set){
            for(int i=0;i<s.length();i++){
                if(set.contains(s.substring(0,i))){
                    System.out.println(s);
                    return false;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] phone_book={"12","123","1235","567","88"};
        System.out.println(solution(phone_book));
    }
}
