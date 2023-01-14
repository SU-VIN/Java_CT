import java.util.ArrayList;
//레벨2 카카오 [1차] 캐시
public class PRO_CT_14 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> arr = new ArrayList<>();

        if(cacheSize<1) return cities.length*5;
        else{
            for(int i=0;i<cities.length;i++){
                if(arr.contains(cities[i].toUpperCase())){
                    int idx=arr.indexOf(cities[i].toUpperCase());
                    arr.remove(idx);
                    arr.add(cities[i].toUpperCase());
                    answer+=1;
                }else{
                    if(arr.size()<cacheSize){
                        arr.add(cities[i].toUpperCase());
                    }else{
                        arr.remove(0);
                        arr.add(cities[i].toUpperCase());
                    }

                    answer+=5;
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
