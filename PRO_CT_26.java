import java.util.HashSet;

public class PRO_CT_26 {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int[] arr1=new int[topping.length];
        int[] arr2=new int[topping.length];

        for(int i=0;i<topping.length;i++){
            set.add(topping[i]);
            arr1[i]=set.size();
        }
        set.clear();;

        for(int i=topping.length-1;i>=0;i--){
            set.add(topping[i]);
            arr2[i]=set.size();
        }

        for(int i=0;i<topping.length-1;i++){
            if(arr1[i]==arr2[i+1]){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] toppint={1,2,1,3,1,4,1,2};
    }
}
