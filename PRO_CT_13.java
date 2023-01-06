public class PRO_CT_13 {
    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i].toLowerCase();

        }

        return answer;
    }
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(solution(s));
    }
}
