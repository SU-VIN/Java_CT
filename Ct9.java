//핸드폰 번호 가리기
public class Ct9 {
    public String solution(String phone_number) {
        return "*".repeat(phone_number.length()-4)+phone_number.substring(phone_number.length()-4,phone_number.length());
    }
    public static void main(String[] args) {
        Ct9 sol = new Ct9();
        String pn = "01033334444";
        System.out.println(sol.solution(pn));
    }


}

