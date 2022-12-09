import java.util.Arrays;
import java.util.Collections;

public class javatest {
    public static void main(String[] args) {

//멀미나서 못하겠어요
//쉬자ㅋㅇㄴㅇㅣㅏㅓㅣㅙㅑㅗㅑㅗㅣㅘㅓㅏshwuhd
        String[] arr1 = {"나","가","다"};
        int [] arr2 = {3,4,2,5,1};
        Integer[] arr3 = new Integer[arr2.length];
        for(int i=0;i<arr3.length;i++){
            arr3[i]=arr2[i];
        }

//        Arrays.sort(arr1, Collections.reverseOrder());
        Arrays.sort(arr3,Collections.reverseOrder());
//
//        for(String x :arr1){
//            System.out.println(x);
//        }

        for(int x :arr3){
            System.out.println(x);
        }
    }
}
