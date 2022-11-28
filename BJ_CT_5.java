import java.util.Scanner;
import java.util.Stack;

//막대기 - 브론즈2 스택
public class BJ_CT_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 막대기 개수
        int[] arr= new int[n]; // 막대기의 높이를 담을 배열
        Stack<Integer> st = new Stack<Integer>(); //스택을 사용해 비교할것임
        int count =0;

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=arr.length-1;i>=0;i--){ //배열의 끝에서 부터
            if(i==arr.length-1) { //첫번째 요소는 무조건 보이기때문에 count 증가시켜주고 스택에 푸시
                count++;
                st.push(arr[arr.length-1]);
            }

            if(arr[i]>st.peek()){ //그다음 요소들 부턴 스택의 최상위 값보다 큰 배열의 값만 푸시
                count++;
                st.push(arr[i]);
            }
        }


        System.out.println(count);
    }
}
