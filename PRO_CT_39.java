import java.util.ArrayList;
//레벨3 DFS 단어변환
public class PRO_CT_39 {

    private static boolean[] visited;
    private static int answer;

    public static int solution(String begin, String target, String[] words) {
        answer = 0;
        visited=new boolean[words.length];
        DFS(begin,target,words,0);


        return answer;
    }

    private static void DFS(String begin,String target,String[] words,int cnt){
        if(begin.equals(target)){
            answer=cnt;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if(!visited[i]&&check(begin,words[i])==1){
                visited[i]=true;
                DFS(words[i],target,words,cnt+1);
                visited[i]=false;
            }
        }
    }

    //다른 단어가 하나만 있는지 탐색
    private static int check(String begin,String compare){
        int cnt=0;
        for (int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i)!=compare.charAt(i)) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin,target,words));
    }
}
