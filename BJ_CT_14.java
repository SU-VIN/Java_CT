import java.io.*;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;
//골드4 오큰수
public class BJ_CT_14 {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//        int [] arr = new int[N];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for(int i=0;i<N;i++){
//            arr[i]=Integer.parseInt(st.nextToken());
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        for(int i=0;i<N;i++){
//            while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
//                arr[stack.pop()]=arr[i];
//            }
//            stack.add(i);
//        }
//
//        while (!stack.isEmpty()){
//            arr[stack.pop()]=-1;
//        }
//
//        for(int i=0;i<N;i++){
//            bw.write(arr[i]+" ");
//        }
//
//
//        bw.flush();
//
//
//    }
    //다시풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[]num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i]=Integer.parseInt(st.nextToken());

        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[]answer=new int[N];

        //뒤부터 탐색
        for(int i=N-1;i>=0;i--){
            while (!stack.isEmpty()&&stack.peekLast()<=num[i]){
                stack.pollLast();
            }
            answer[i]=stack.isEmpty()?-1:stack.peekLast();
            stack.addLast(num[i]);
        }

        for(int i:answer){
            bw.write(i+" ");
        }
        bw.flush();
}
}
