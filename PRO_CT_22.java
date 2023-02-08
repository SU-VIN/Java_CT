import java.util.ArrayDeque;
//레벨2 다리를 지나는 트럭
public class PRO_CT_22 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int count=0;
        int total=0;

        ArrayDeque<Integer> bridge = new ArrayDeque<>(bridge_length);

        for(int t:truck_weights){
            while (true){
                //큐가 비었을때
                if(bridge.isEmpty()){
                    bridge.addFirst(t);
                    total+=t;
                    count++;
                    break;
                }
                else if(bridge.size()==bridge_length){
                    total-=bridge.pollLast();
                }
                //큐가 비어있지 않을때
                else{
                    if(total+t>weight){
                        bridge.addFirst(0);
                        count++;
                        //break를 안했기때문에 t가 넘어가지 않고 계속 돔
                    }else{
                        bridge.addFirst(t);
                        total+=t;
                        count++;
                        break;
                    }
                }


            }
        }



        return count+bridge_length;
    }

    public static void main(String[] args) {
        int bridge_length=2;
        int weight=10;
        int[] truck_weight={7,4,5,6};

        System.out.println(solution(bridge_length,weight,truck_weight));
    }
}
