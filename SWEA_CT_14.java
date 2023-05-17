import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_CT_14 {
    public static void main(String[] args)throws IOException {
        int T = 10;
        int result=0;
        int[] map;
        int N;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        System.setIn(new FileInputStream("/Users/imsubin/Documents/GitHub/Java_CT/input-2.txt"));
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= T; i++) {
            
            // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // N = Integer.parseInt(br.readLine());
            N = sc.nextInt();
            map = new int[N];
            result = 0;

            // StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                // map[j]=Integer.parseInt(st.nextToken());
                map[j] = sc.nextInt();
            }
            
            for (int j = 2; j < N-2; j++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(map[j-2]);
                pq.add(map[j-1]);
                pq.add(map[j+1]);
                pq.add(map[j+2]);

                if(map[j]>pq.peek()){
                    result+=map[j]-pq.poll();
                }
            }
            dq.addLast(result);
        }

        for (int i = 1; i <=T ; i++) {
            System.out.println("#"+i+" "+dq.pollFirst());
        }

    }
    
}
