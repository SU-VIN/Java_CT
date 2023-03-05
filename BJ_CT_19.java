import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_CT_19 {
    //골드4 연구소

    private  static final  int[] rx ={0,0,1,-1};
    private  static  final  int[] ry={1,-1,0,0};

    private static class Node{
        int r,c;

        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    private  static  int[][] map;
    private  static  int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //입력받기
        map = new int[N][M];

        ArrayDeque<Node> poison = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    poison.addLast(new Node(i,j));
                }
            }

        }

        ArrayDeque<Node> block = new ArrayDeque<>();
        int answer = 0;

        for(int i=0;i<N*M-2;i++){
            if(map[i/M][i%M]!=0)continue;
            block.addLast(new Node(i/M,i%M));
            for(int j=i+1;j<N*M-1;j++){
                if(map[j/M][j%M]!=0)continue;
                block.addLast(new Node(j/M,j%M));
                for(int k=j+1;k<N*M;k++){
                    if(map[k/M][k%M]!=0)continue;
                    block.addLast(new Node(k/M,k%M));
                    answer=Math.max(answer,bfs(poison,block));
                    block.pollLast();

                }
                block.pollLast();
            }
            block.pollLast();
        }


        System.out.println(answer);

    }
    //0의 개수를 반환
    private  static  int bfs(ArrayDeque<Node>poison,ArrayDeque<Node> block ){
        int[][] map2 = new int[N][M]; //여기서 bfs를 돌리자 원본은 냅둬야함

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map2[i][j] = map[i][j];
            }
        }

        for(Node node : block){
            map2[node.r][node.c]= 1;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();

        for(Node node : poison){
            queue.addLast(node);
        }

        while (!queue.isEmpty()){
            Node now = queue.pollFirst();

            for(int i=0;i<4;i++){
                int nr = now.r+rx[i];
                int nc = now.c+ry[i];

                if(nr<0||nc<0||nr>=N||nc>=M)
                    continue;
                if(map2[nr][nc]==1)
                    continue;

                if(map2[nr][nc]==0){
                    map2[nr][nc]=2;
                    queue.addLast(new Node(nr,nc));
                }
            }
        }

        int cnt = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map2[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;


    }
}
