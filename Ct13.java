//시저암호
public class Ct13 {
    public String solution(String s, int n) {
        String answer = "";
        //A = 65 Z =90 a=97 z=122
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                if(s.charAt(i)+n>90){
                    answer+=(char)(s.charAt(i)+n-26);
                }else {
                    answer += (char) (s.charAt(i) + n);
                }

            } else if (s.charAt(i)>='a'&&s.charAt(i)<='z') {
                if(s.charAt(i)+n>122){
                    answer+=(char)(s.charAt(i)+n-26);
                }else {
                    answer += (char) (s.charAt(i) + n);
                }
            }else{
                answer+=" ";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Ct13 sol = new Ct13();
        String s = "a B z";
        int n=4;
        System.out.println(sol.solution(s,n));

    }
}
