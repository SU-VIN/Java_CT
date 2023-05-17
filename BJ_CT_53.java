import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//골드3 경사로 구현
public class BJ_CT_53 {
    static int N,L;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int result= 0;


        for (int i = 0; i < N; i++) {
            if(slopeRow(i)) result++;// ㅡ 방향
            if(slopeCol(i)) result++;
            
        }

        
        System.out.println(result);
        
    }

    static public boolean slopeRow(int row){
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N-1; i++) {

            int diff =map[row][i]-map[row][i+1];

            if(Math.abs(diff)>1)return false;//층이 1이상이면 나가

            if(diff==-1){ // /방향
                for (int j = 0; j < L; j++) {
                    if(i - j < 0 || visited[i - j]) return false; //경사로가 outofindx 일때
                    if(map[row][i]!=map[row][i-j])return false; //경사둘곳의 높이가 다를때
                    visited[i-j]=true;//경사 설치
                    
                }

            }else if(diff==1){ // \방향
                for (int j = 1; j <= L; j++) {
                    if(i+j>=N||visited[i+j])return false; 
                    if(map[row][i]-1!=map[row][i+j])return false;
                    visited[i+j]=true;
                    
                }
            }

        }
        return true;
    }


    static public boolean slopeCol(int col){
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N-1; i++) {

            int diff =map[i][col]-map[i+1][col];

            if(Math.abs(diff)>1)return false;//층이 1이상이면 나가

            if(diff==-1){ // /방향
                for (int j = 0; j < L; j++) {
                    if(i - j < 0 || visited[i - j]) return false; //경사로가 outofindx 일때
                    if(map[i][col]!=map[i-j][col])return false; //경사둘곳의 높이가 다를때
                    visited[i-j]=true;//경사 설치
                    
                }

            }else if(diff==1){ // \방향
                for (int j = 1; j <= L; j++) {
                    if(i+j>=N||visited[i+j])return false; 
                    if(map[i][col]-1!=map[i+j][col])return false;
                    visited[i+j]=true;
                    
                }
            }

        }
        return true;
    }
       

}
