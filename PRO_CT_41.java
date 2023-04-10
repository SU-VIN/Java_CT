import java.util.HashSet;

public class PRO_CT_41 {

    public static int solution(String dirs) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        
        int[] now ={0,0};
        int[] next = new int[2];

        for (int i = 0; i < dirs.length(); i++) {
            StringBuilder sb = new StringBuilder();
            next[0]=now[0];
            next[1]=now[1];
            switch(dirs.charAt(i)){
                case 'U': // 0 +1
                next[1]+=1;
                sb.append(now[0]).append(now[1]).append(next[0]).append(next[1]);
                break;
                case 'D': // 0 -1
                next[1]-=1;
                sb.append(next[0]).append(next[1]).append(now[0]).append(now[1]);
                break;
                case 'L': // -1 0
                next[0]-=1;
                sb.append(next[0]).append(next[1]).append(now[0]).append(now[1]);
                break;
                case 'R': // 1 0
                next[0]+=1;
                sb.append(now[0]).append(now[1]).append(next[0]).append(next[1]);
                break;
                default:
                break;
            }

            if(next[0]<-5||next[0]>5||next[1]<-5||next[1]>5)
            continue;
            set.add(sb.toString());
            now[0]=next[0];
            now[1]=next[1];
        }
        answer=set.size();
        return answer;
    }


    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        System.out.println(solution(dirs));
    }
}
