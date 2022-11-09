//삼총사
public class Ct6 {

    public static int solution(int[] number) {
        int answer = 0;
        for(int i=0;i<number.length;i++){
            for(int j=i+1;j<number.length;j++){
                for(int l=j+1;l<number.length;l++){
                    if(number[i]+number[j]+number[l]==0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println(solution(numbers));

    }
}
