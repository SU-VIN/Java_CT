import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//실버1 -연산자끼워넣기 백트랙킹
public class BJ_CT_29  {
    static int N;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] arr;
    static int[] operator;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      arr = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());

      //수열
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());

      }
      //연산자 [0]== + [1]== - [2]== * [3]== /
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      operator=new int[4];
      for (int i = 0; i < 4; i++) {
        operator[i]= Integer.parseInt(st2.nextToken());
      }

      //계산시작
      backtracking(arr[0],1);
      System.out.println(MAX);
      System.out.println(MIN);
    }

    private static void backtracking(int num,int index){
      //return조건
      if(index == N){ //수열 끝까지 계산을 다했다면
        MAX = Math.max(MAX,num);
        MIN = Math.min(MIN,num);
        return;
      }
      //백트랙킹
      //연산자4개니깐 4번돌아야함
      for (int i = 0; i < 4; i++) {
        if(operator[i]>0){
          operator[i]--; //사용했으면 갯수 줄여주기

          switch(i){
            case 0: //+
            backtracking(num+arr[index], index+1);
            break;
            case 1: //-
            backtracking(num-arr[index], index+1);
            break;
            case 2: //* 
            backtracking(num*arr[index], index+1);
            break;
            case 3: //%
            backtracking(num/arr[index], index+1);
            break;
          }
          operator[i]++;
        }
        
      }
    }

   
}
