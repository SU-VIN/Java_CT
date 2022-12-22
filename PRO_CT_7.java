public class PRO_CT_7 {
    //레벨1 푸드파이트대회
    public static String solution(int[] food) {
        String answer = "";
        String water = "0";
        int num=0;
        for(int i=1;i<food.length;i++){
            while (num<food[i]/2){
                answer+=i;
                num++;
            }
            num=0;
        }
        StringBuffer str=new StringBuffer(answer);
        String reverseStr = str.reverse().toString();
        return answer+water+reverseStr;
    }
    public static void main(String[] args) {
        int[] food = {1,3,4,6};
        System.out.println(solution(food));
    }
}
