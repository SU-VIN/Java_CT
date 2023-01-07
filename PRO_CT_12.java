import java.util.Arrays;
//레벨2 최댓값과 최솟값
public class PRO_CT_12 {
    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] result = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            result[i]=Integer.parseInt(arr[i]);
        }
        Arrays.sort(result);
        answer=result[0]+" "+result[result.length-1];
        return answer;
    }
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        System.out.println(solution(s));
    }
}
