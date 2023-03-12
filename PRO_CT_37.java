public class PRO_CT_37 {
//레벨2 피로도 dfs
    private static boolean[] visited;
    public static int answer = 0;
    public static int solution(int k, int[][] dungeons) {
        visited= new boolean[dungeons.length];

        dfs(k,0,dungeons);
        return answer;
    }

    private static void dfs(int k,int cnt,int[][] dungeons){
        answer=Math.max(answer,cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i]=true;
                dfs(k-dungeons[i][1],cnt+1,dungeons);
                visited[i]=false;
            }
        }
    }
    public  static void main(String[] args) {
        int k=80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(k,dungeons));
    }


}
