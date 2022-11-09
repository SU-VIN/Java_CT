//문자열 다루기 기본
public class Ct10 {
    //48 ==0 57 ==9
    public boolean solution(String s) {
        if(s.length()==4||s.length()==6){
            for(int i=0;i<s.length();i++){
                if(!(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                    return  false;
                }

            }
            return true;

        }
        return false;
    }
    public static void main(String[] args) {
        Ct10 sol = new Ct10();
        String s = "12e4";
        System.out.println(sol.solution(s));

    }
}
