import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
    //골드1 뱀
public class BJ_CT_51 {
    static int N;
    static int[][] map;
    static int[] dr = {-1,0,1,0}; //상 좌 하 우
    static int[] dc = {0,1,0,-1};

    static int time=0;

    static class Dir{
        int num;
        String dir;

        public Dir(int num, String dir){
            this.num=num;
            this.dir=dir;
        }
    }

    static class Node{
        int r,c,d;
        
        public Node(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }

    static ArrayDeque<Dir> Dirdq = new ArrayDeque<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        //사과 데이터 처리
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
            
        }
        
        int L = Integer.parseInt(br.readLine());
        //방향 데이터 처리
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Dirdq.addLast(new Dir(Integer.parseInt(st.nextToken()),st.nextToken()));
        }
        //초기 뱀 처리
        map[1][1]=2;


        bfs();
        System.out.println(time);
    }

    //   0
    // 3   1
    //   2

    public static void bfs(){
        ArrayDeque<Node> dq = new ArrayDeque<>();
        //처음엔 1방향으로 감
        dq.addLast(new Node(1,1,1));
        //1 == 사과 2==뱀 0==길
        ArrayDeque<Node>snake = new ArrayDeque<>();
        snake.addLast(new Node(1, 1, 0));
        while(!dq.isEmpty()){
            time+=1;
            Node now = dq.pollFirst();

            
            int dx = now.r+dr[now.d];
            int dy = now.c+dc[now.d];

            //벽에 부닥치면
            if(dx<1||dy<1||dx>N||dy>N) return; 
            //내몸에 부닥치면
            if(map[dx][dy]==2)return;

            if(map[dx][dy]==1){//사과를 만났다면
                map[dx][dy]=2; //머리 먼저가고
                map[now.r][now.c]=2; //꼬리유지
                snake.addLast(new Node(dx, dy, 0)); //뱀 길이 늘려주기

                //방향체크
                if(!Dirdq.isEmpty()&&time==Dirdq.peekFirst().num){
                    
                    if(Dirdq.pollFirst().dir.equals("D")){ //오른쪽 90도
                        int nextDir = now.d+1;
                        if(nextDir>3) nextDir=0;
                        dq.addLast(new Node(dx, dy, nextDir));
                    }else{//왼쪽 90도
                        int nextDir = now.d-1;
                        if(nextDir<0) nextDir=3;
                        dq.addLast(new Node(dx, dy, nextDir));
                    }
                }else{
                dq.addLast(new Node(dx, dy, now.d));
                }

            }else{//사과가 아니라면
                map[dx][dy]=2; //머리 먼저
                Node remove = snake.pollFirst(); //꼬리 한칸 지워주고
                map[remove.r][remove.c]=0;
                snake.addLast(new Node(dx, dy, 0)); //뱀 길이 유지

                //방향체크
                if(!Dirdq.isEmpty()&&time==Dirdq.peekFirst().num){
                    
                    if(Dirdq.pollFirst().dir.equals("D")){ //오른쪽 90도
                        int nextDir = now.d+1;
                        if(nextDir>3) nextDir=0;
                        dq.addLast(new Node(dx, dy, nextDir));
                    }else{//왼쪽 90도
                        int nextDir = now.d-1;
                        if(nextDir<0) nextDir=3;
                        dq.addLast(new Node(dx, dy, nextDir));
                    }
                }else{
                dq.addLast(new Node(dx, dy, now.d));
                }
            }


            // System.out.println("////////////////////////");
            // for (int i = 1; i <=N; i++) {
            //     for (int j = 1; j <=N; j++) {
            //          System.out.print(map[i][j]+" ");
            //      }
            //         System.out.println("\n");
            // }        
            
            // System.out.println("////////////////////////");
                
        }


        }
    }


