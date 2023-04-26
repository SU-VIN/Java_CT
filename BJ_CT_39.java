import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//골드3 아기상어 bfs + 구현
public class BJ_CT_39 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int sharkSize = 2;
    static int sharkEat = 0;
    static int sharkMove;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};



    public static class Node{
        int r,c,dist;
        public Node(int r, int c,int dist){
            this.r=r;
            this.c=c;
            this.dist = dist;
        }
    }

    static Node shark;
    static ArrayList<Node> list = new ArrayList<>();

    //9는 아기상어 크기는 2 자기보다 작은 물고기만 먹을수 있고 같은 크기는 지나가기만 허용
    //더이상 먹을 수 있는 물고기가 없을때까지 아기상어가 움직이는 횟수 리턴
    //1순위 거리가 가장 가까운 물고기(아기상어가 있는칸에서 물고기가 있는칸으로 이동할때 지나가야하는 칸의 최소개수)
    //거리가 가까운 물고기가 많으면 (상)위치의 물고기 그러한 물고기가 여러마리라면 (좌)위치의 물고기먼저
    //자기의 크기수 만큼 물고기를 먹으면 아기상어 크기 1증가
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];



        //데이터 삽입
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    shark=new Node(i, j,0);
                    map[i][j]=0; //상어위치는 상어도 움직일 수 있으니 0으로 바꿔줌
                }
            }
        }   


            bfs();
        
            System.out.println(sharkMove);



    }

    private static void bfs(){
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(shark);
        visited[shark.r][shark.c]=true;


        while(true){
        while(!dq.isEmpty()){
            Node now = dq.pollFirst();
            int time = now.dist;


            for (int i = 0; i < 4; i++) {
                int dx = now.r+dr[i];
                int dy = now.c+dc[i];

                if(dx<0||dy<0||dx>=N||dy>=N)continue;
                if(visited[dx][dy]) continue;

                if(map[dx][dy]==0||map[dx][dy]==sharkSize){//움직일 수 있음
                    dq.addLast(new Node(dx, dy,time+1));
                    visited[dx][dy]=true;
                }
                if(map[dx][dy]!=0&&map[dx][dy]<sharkSize){//먹을 수 있음
                    dq.addLast(new Node(dx, dy,time+1));
                    visited[dx][dy]=true;
                    list.add(new Node(dx, dy, time+1)); //리스트에 넣어둠
                }
            }
        }

        //이 while문을 빠져나오면 아기상어가 물고기를 먹은것

        if(!list.isEmpty()){ 
            eat();
            //한번의 식사끝 다음식사 준비

            dq.clear();
            visited = new boolean[N][N];

            dq.add(shark);
            visited[shark.r][shark.c]=true;
        }else{
            return;
        }






    }
    }

    //리스트에 값이 존재한다면 어떤걸 먹을지 정해야함
    private static void eat(){
        //리스트 정렬
        Collections.sort(list,new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2){
                if(o1.dist==o2.dist){ //거리가 같다면
                    if(o1.r==o2.r){//x값도 같다면
                        if(o1.c>o2.c) return 1;
                        else return -1;
                    }else{
                        if(o1.r>o2.r)return 1;
                        else return -1;
                    }
                }else if(o1.dist>o2.dist){
                    return 1; 
                }else{
                    return -1;
                }
            }
        });

        Node now = list.get(0); //정렬한 첫번째 인덱스가 먹을것

        shark.r = now.r;
        shark.c = now.c;


        if(++sharkEat==sharkSize){
            sharkSize++;
            sharkEat=0;
        }

        sharkMove+=now.dist; //상어가 이동한거리 증가해줌

        map[now.r][now.c]=0;//먹음처리

        list.clear();


    }
    
}
