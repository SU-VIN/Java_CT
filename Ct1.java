public class Ct1 {

    public static double solution(int[] arr) {
        double answer = 0;
        for(int i=0;i<arr.length;i++){
            answer+=arr[i];
        }
        return answer/arr.length;
    }


    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        System.out.println(solution(arr));
    }
}
