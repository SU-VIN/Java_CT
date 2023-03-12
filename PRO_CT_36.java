public class PRO_CT_36 {
    //dfs 네트워크
    private  static int[][] computer;

    private  static  boolean[] visited;
    public static int solution(int n, int[][] computers) {
        computer=computers;
        visited= new boolean[n];
        int answer = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    private  static void dfs(int now){//현재 정점
        //현재 정점이 이미 방문한 정점이면 리턴한다
        if(visited[now])  return;

        visited[now]= true;

        for(int i=0;i<computer.length;i++){
            if(computer[now][i]==1)
                dfs(i);
        }

    }
    public static void main(String[] args) {

        int n = 3;
        int[][] computers={{1, 1, 0},{1, 1, 0},{0, 0, 1}};
        System.out.println(solution(n,computers));

    }
}
