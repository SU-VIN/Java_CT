import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//실버1 구간합구하기5 누적합/구간합 prefixsum
public class BJ_CT_42 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer( br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][]= new int[N+1][N+1];
        int array[][]= new int[M][4]; //x1,x2 - y1,y2

        //맵 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //배열 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                array[i][j]=Integer.parseInt(st.nextToken());
                
            }
            
        }

        //누적합 배열로 바꾸기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j]=map[i-1][j]+map[i][j-1]+map[i][j]-map[i-1][j-1];
            }
            
        }

        //구간합 구하기
        for (int i = 0; i < M; i++) {
            int x1 = array[i][0]; //(2,2) (3,4)
            int x2 = array[i][1];
            int y1 = array[i][2];
            int y2 = array[i][3];
            //(y1,y2)- (x1-1,y2) - (y1,x2-1) +(x1-1,x2-1)

            System.out.println(map[y1][y2]-(map[x1-1][y2]+map[y1][x2-1])+map[x1-1][x2-1]);


            
        }
    }
    
}
