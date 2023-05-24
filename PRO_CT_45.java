import java.util.Arrays;
import java.util.HashSet;
//레벨2 해시 전화번호 목록 32m
public class PRO_CT_45 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            //정렬했는데 뒤의 길이가 앞의길이보다 짧으면 무시 String 형식이란걸 기억
            if(phone_book[i].length()>phone_book[i+1].length()) continue;

            set.add(phone_book[i]); //해시에 넣어주고
            int size = phone_book[i].length();//이값의 길이

            String str = phone_book[i+1].substring(0,size); //다음값을 앞의 길이만큼 잘라줌
            if(set.contains(str)) return false;//잘라준 값이 해시에 존재하면 return false
            //해시의 key탐색, value접근/삭제 key저장은 O(1)인걸 활용, hash의 contain 도 o(1)임
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"123", "1005", "1006", "1007"};
        System.out.println(solution(phone_book));
    }
}
