import java.util.ArrayDeque;
import java.util.ArrayList;
//레벨2 카카오 [1차] 캐시
public class PRO_CT_14 {
//    public static int solution(int cacheSize, String[] cities) {
//        int answer = 0;
//        ArrayList<String> arr = new ArrayList<>();
//
//        if(cacheSize<1) return cities.length*5; //캐시 사이즈가 0일때 계산 해줘야한다
//        else{
//            for(int i=0;i<cities.length;i++){
//                //도시이름이 존재할때
//                if(arr.contains(cities[i].toUpperCase())){
//                    int idx=arr.indexOf(cities[i].toUpperCase()); //기존에 존재하던 문자의 인덱스 번호를 구한다
//                    arr.remove(idx); //해당 인덱스를 지우고
//                    arr.add(cities[i].toUpperCase()); //새롭게 넣어준다
//                    answer+=1;
//                }else{
//                    //도시 이름이 존재하지 않을때
//                    if(arr.size()<cacheSize){
//                        arr.add(cities[i].toUpperCase()); //ArrayList의 크기가 캐시보다 작을땐 일단 넣어준다
//                    }else{
//                        arr.remove(0); //크다면 젤 오래된 값을 지워주고
//                        arr.add(cities[i].toUpperCase()); //값을 넣어주고 ArrayList의 사이즈를 계속 유지해준다
//                    }
//
//                    answer+=5;
//                }
//            }
//        }
//        return answer;
//    }

//queue로 풀기
    public static int solution(int cacheSize, String[] cities){

        ArrayDeque<String> cache = new ArrayDeque<>();
        int answer = 0;

        for(String city : cities){      //O(N) N=100,000
            city=city.toUpperCase();   //O(N) N=20

            if(cache.contains(city)){  //O(N*M) 30*20 *100,000
                answer+=1;
                cache.remove(city);
                cache.addLast(city);
            }else{
                answer+=5;
                cache.addLast(city);
                if(cache.size()>cacheSize){
                    cache.pollFirst();
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {

        int cacheSize =3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(solution(cacheSize,cities));

    }

}
