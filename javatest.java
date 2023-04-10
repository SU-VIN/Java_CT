import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class javatest {

    public static int solution(int n, int m, int k, int[] u, int[] v, int[] l) {
        int answer = 0;
        int max = Integer.MAX_VALUE;
        u = Arrays.copyOfRange(u,0,n);
        v = Arrays.copyOfRange(v,0,n);

        //컨베이너 벨트가 이어져있는지 확인
        for (int i = 1; i <= n; i++) {
            if(u[i-1]!=i&&v[i-1]!=i){
                return -1;
            }
        }

        //벨트 길이 최솟값 구하기
        boolean[] visited = new boolean[l.length];
        choice(l,visited,0,n);


        


        return answer;
    }

    static void choice(int[] arr, boolean[] visited, int start, int r){
        if(r==0){
            return
        }else{
            for (int i = 0; i < arr.length; i++) {
                visited[i]=true;
                choice(arr,visited,i+1,r-1);
                visited[i]=false;
            }
        }
    }

    static int[] print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n=4;
        int m=6;
        int k=9;
        int[] u = {1,2,3,1,1,2};
        int[] v ={2,3,4,4,3,4};
        int[] l ={3,3,3,3,1,2};
//        int n=3;
//        int m=3;
//        int k=1;
//        int[] u = {1,1,2};
//        int[] v ={2,3,3};
//        int[] l ={2,2,2};
        System.out.println(solution(n,m,k,u,v,l));

    }
}
