import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//D2 조교의 성적 매기기
public class SWEA_CT_11 {

    static String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<String> dq = new ArrayDeque<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); //학생수
            int K = Integer.parseInt(st.nextToken()); //학점을 알아낼 학생의 번호
            int value = N/10;

            Double[][] score = new Double[N][2]; //학생들의 점수를 담을 배열

            //점수 계산하기
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                score[j][0]=Double.valueOf(j);
                score[j][1]=(Integer.parseInt(st.nextToken())*0.35)+(Integer.parseInt(st.nextToken())*0.45)+(Integer.parseInt(st.nextToken())*0.2);
                
            }

            //점수 기준으로 정렬
            Arrays.sort(score, new Comparator<Double[]>() {
                @Override
                public int compare(Double[] o1, Double[] o2) {
                    return Double.compare(o2[1], o1[1]);
                }
            });

            //해당학생 인덱스 구하기
            int index=-1;
            int cnt =0;
            for (int j = 0; j < N; j++) {
                index = Arrays.asList(score[j][0]).indexOf(Double.valueOf(K-1));
                if(index==0){
                    index=cnt;
                    break;
                }cnt++;
            }

            
            //해당학생 학점구하기
            dq.addLast(grade[index/value]);
            
        }
        //출력
        for (int i = 1; i <=T; i++) {
            System.out.println("#"+i+" "+dq.pollFirst());
            
        }
        
    }
}
