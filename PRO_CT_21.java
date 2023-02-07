import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//가장 큰 수 레벨2
public class PRO_CT_21 {
    public static String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int n :numbers){
            list.add(Integer.toString(n));
        }

        Collections.sort(list,(o1,o2)->{
            int a = Integer.parseInt(o1+o2);
            int b = Integer.parseInt(o2+o1);
            return Integer.compare(b,a);
        });

        for(String s:list){
            sb.append(s);
        }

        if(sb.charAt(0)=='0') return "0";

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers ={6,10,2};
        System.out.println(solution(numbers));
    }
}
