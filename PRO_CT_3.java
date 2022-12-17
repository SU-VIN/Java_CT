import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//레벨1 실패율
public class PRO_CT_3 {
    public static int[] solution(int N, int[] stages) {
        double[] answer = new double[N];
        int[] result =new int[N];
        Map<Integer,Double> map = new HashMap(); //key=스테이지번호 value=실패율

        for(int i=1;i<=N;i++){
            double failureLate = 0;//실패율
            double a=0; //스테이지에 도달했으나 아직 클리어 하지 못한 플레이어의 수
            double b=0; //스테이지에 도달한 플레이어 수
            for(int j=0;j<stages.length;j++){
                if(stages[j]==i){
                    a++;
                }
                if(stages[j]>=i){
                    b++;
                }
            }
            map.put(i,a/b);
            if(a==0&&b==0) map.put(i,0.0); //0/0은 NaN이 뜨기때문에 강제로 0을 넣어줌
        }

        List<Integer> keySet = new ArrayList<Integer>(map.keySet());
        keySet.sort((o1,o2)-> map.get(o2).compareTo(map.get(o1)));//value값으로 내림차순 정렬
        for (int i=0;i<N;i++) {
            result[i]=keySet.get(i);
        }

        return result;
    }
    public static void main(String[] args) {
        int n=5;
        int[] stages = {2,1,2,6,2,4,3,3};
        System.out.println(solution(n,stages));

    }
}
