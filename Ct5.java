//두 개 뽑아서 더하기
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ct5 {

    public static List solution(int[] numbers) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();



        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(!result.contains(numbers[i]+numbers[j])) {
                    result.add(numbers[i] + numbers[j]);
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        System.out.println(solution(numbers));

    }
}
