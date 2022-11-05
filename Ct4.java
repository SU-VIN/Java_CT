//이상한 문자 만들기
public class Ct4 {
    public static String solution(String s) {
        String answer = "";
        int index = 0;
        String[] arr=s.split("");
        for(int i=0;i<arr.length;i++){
            if(arr[i].contains(" ")) index=0;
            else if (index%2==0) {
                arr[i]=arr[i].toUpperCase();
                index++;
            }else{
                arr[i]=arr[i].toLowerCase();
                index++;
            }
            answer+=arr[i];
        }


        return answer;
    }

    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(solution(s));
    }
}
