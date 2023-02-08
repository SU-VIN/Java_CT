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
                    bridge.addFirst(t); //다리에 추가해주고
                    total+=t; //총무게에 더해주고
                    count++; //1초++
                    break;
                }
                //다리에 올라온 트럭이 다리 길이와 같아질때
                else if(bridge.size()==bridge_length){
                    total-=bridge.pollLast(); //총무게에서 제일 먼저나가는 트럭을 빼줌
                    //break를 안했기때문에 t가 넘어가지 않고 계속 돔
                }
                //큐가 비어있지 않을때
                else{
                    if(total+t>weight){ //최대무개를 초과한다면
                        //이미 최대길이와 같은지를 위에서 비교했기때문에
                        bridge.addFirst(0); //0으로 값을 채워준다
                        count++;
                        //break를 안했기때문에 t가 넘어가지 않고 계속 돔
                    }else{//최대무게를 넘지 않는다면
                        bridge.addFirst(t); //다리에 추가해주고
                        total+=t; //총무게 더해주고
                        count++;//1초++;
                        break;
                    }
                }


            }
        }

        //마지막트럭이 다리에 올라간 시점에서 종료되므로 걸린시간+다리의 길이를 더해준다
        return count+bridge_length;
    }

    public static void main(String[] args) {
        int bridge_length=2;
        int weight=10;
        int[] truck_weight={7,4,5,6};

        System.out.println(solution(bridge_length,weight,truck_weight));
    }
}
