public class PRO_CT_8 {
    //레벨1- 크기가 작은 부분문자열
    public static int solution(String t, String p) {
        int answer = 0;


        for(int i=0;i<=t.length()-p.length();i++){
            if(Long.parseLong(t.substring(i,i+p.length()))<=Long.parseLong(p)){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String t="3141592";
        String p="271";
        System.out.println(solution(t,p));
    }
}
