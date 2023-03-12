public class PRO_CT_36 {
    //dfs 네트워크
//    private  static int[][] computer;
//
//    private  static  boolean[] visited;
//    public static int solution(int n, int[][] computers) {
//        computer=computers;
//        visited= new boolean[n];
//        int answer = 0;
//
//        for(int i=0;i<n;i++){
//            if(!visited[i]){
//                dfs(i);
//                answer++;
//            }
//        }
//        return answer;
//    }
//
//    private  static void dfs(int now){//현재 정점
//        //현재 정점이 이미 방문한 정점이면 리턴한다
//        if(visited[now])  return;
//
//        visited[now]= true;
//
//        for(int i=0;i<computer.length;i++){
//            if(computer[now][i]==1)
//                dfs(i);
//        }
//
//    }
    
    private static int[][] computer;
    private static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;
        computer=computers;
        visited = new boolean[n];
        
        //현재 정점을 파라미터로 넘겨받는 함수를 정의한다
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    private static void dfs (int now){
        //현재 정점이 이미 방문한 정점이면 return한다
        if(visited[now]) return;
        //현재 정점의 방문체크를 한다
        visited[now]=true;
        //해당 정점에서 방문 가능한 다음 정점을 파라미터 넘기면서 현재 함수를 재귀 호추ㄹ한다
        for (int i = 0; i < computer.length; i++) {
            if(computer[now][i]==1)
                dfs(i);
        }
    }
    public static void main(String[] args) {

        int n = 5;
        int[][] computers={{1, 1, 0,0,0},{1, 1, 0,0,0},{0, 0, 1,1,1},{0, 0, 1,1,1},{0, 0, 1,1,1}};
        System.out.println(solution(n,computers));

    }
}
