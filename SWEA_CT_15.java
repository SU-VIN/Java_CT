import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_CT_15 {
    public static void main(String[] args) throws IOException {
        int T = 10;
        
        System.setIn(new FileInputStream("/Users/imsubin/Documents/GitHub/Java_CT/input-3.txt"));
        Scanner sc = new Scanner(System.in);

        int[] map;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < T; i++) {
            int result = 0;
            int N = sc.nextInt(); // 덤프횟수
            map = new int[100];
            //데이터 삽입
            for (int j = 0; j < map.length; j++) {
                map[j]=sc.nextInt();
            }

            for (int j = 0; j < N; j++) {
                Arrays.sort(map);
                map[99]--;
                map[0]++;
                Arrays.sort(map);
                if(map[99]-map[0]==1||map[99]-map[0]==0){
                    break;
                }
            }

            dq.addLast(map[99]-map[0]);

        }


        for (int i = 1; i <= T; i++) {
            System.out.println("#"+i+" "+dq.pollFirst());
            
        }
    }
}
