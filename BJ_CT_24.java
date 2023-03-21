import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_CT_24 {
    //알파벳 골드4 backtracking

    private static class Node{
        int r,c;

        public Node(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    //상하좌우 이동
    private static final int[] rx = {0,0,-1,1};
    private static final int[] ry = {1,-1,0,0};

    private static int R,C;
    private static char[][] map;

    private static boolean[] used;

    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer=0;
        used=new boolean['Z'-'A'+1];

        map=new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i]=br.readLine().toCharArray();
        }


        //cnt 가 1인 이유는 처음 정점을 포함하기때문
        used[map[0][0]-'A']=true;
        backTracking(new Node(0,0),1);

        System.out.println(answer);

    }

    private static void backTracking(Node now, int cnt){
        answer=Math.max(answer,cnt);

        for (int i = 0; i < 4; i++) {
            int nr = now.r+ry[i];
            int nc = now.c+rx[i];

            //예외처리
            if(nr<0||nc<0||nr>=R||nc>=C){
                continue;
            }

            if(used[map[nr][nc]-'A']){
                continue;
            }

            used[map[nr][nc]-'A']=true;

            backTracking(new Node(nr,nc),cnt+1);

            used[map[nr][nc]-'A']=false;
        }
    }
}
