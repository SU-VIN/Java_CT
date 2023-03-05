import java.util.ArrayDeque;
import java.util.Arrays;

public class PRO_CT_33 {
    //레벨2 게임 맵 최단거리
    private  static final  int[] rx ={0,0,1,-1};
    private  static  final  int[] ry={1,-1,0,0};

    private static class Node{
        int r,c;

        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

        public static int solution(int[][] maps) {
            int N = maps.length;
            int M = maps[0].length;

            ArrayDeque<Node> queue = new ArrayDeque<>(); // 탐색을 위한 큐
            boolean[][] visited = new boolean[N][M]; // 방문 처리 배열
            int[][] dist = new int[N][M]; // 최단 거리 배열

            // 초기 시작 위치 설정
            queue.addLast(new Node(0, 0)); // 시작(출발) 정점
            visited[0][0] = true; // 첫 위치는 방문 처리
            dist[0][0] = 1;

            // 탐색
            while (!queue.isEmpty()) {
                Node now = queue.pollFirst(); // 현재 노드의 위치, 현재 방문한 정점

                // 상 하 좌 우 탐색
                for (int i = 0; i < 4; i++) {
                    int next_r = now.r + rx[i];
                    int next_c = now.c + ry[i];

                    // 맵 밖으로 나가는 경우
                    if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= M) {
                        continue;
                    }

                    // 벽이 비어있는 경우(벽이 막혀있는 경우)
                    if (maps[next_r][next_c] == 0) {
                        continue;
                    }

                    // 방문 처리
                    if (!visited[next_r][next_c]) { // 방문하지 않았다면 true
                        visited[next_r][next_c] = true;
                        dist[next_r][next_c] = dist[now.r][now.c] + 1;
                        queue.addLast(new Node(next_r, next_c));
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(dist[i]));
            }

            System.out.println(dist[N - 1][M - 1]);

            return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
        }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
}
