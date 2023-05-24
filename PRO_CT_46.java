import java.util.*;

public class PRO_CT_46 {
    //레벨3 해시 베스트앨범 2h
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        boolean[] visited = new boolean[plays.length];
        ArrayList<Integer> list = new ArrayList<>();//결과 담을 리스트
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> origin = new HashMap<>();
        HashMap<Integer,String> count = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            origin.put(genres[i],origin.getOrDefault(genres[i],0)+1);
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(String str:map.keySet()){
            count.put(map.get(str),str);
            pq.add(map.get(str));
        }

        int cnt = map.size(); //장르 갯수;
        //우선장르 정하기
        String[] arr = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i]=count.get(pq.poll());
        }

        for (int i = 0; i < arr.length; i++) {
            int[] play = new int[origin.get(arr[i])];
            int k=0;
            for (int j = 0; j < genres.length; j++) {
                if(genres[j].contains(arr[i])){
                    play[k]=plays[j];
                    k++;
                }


            }
            Arrays.sort(play);
//            for (int j = 0; j < play.length; j++) {
//                System.out.println(play[j]);
//            }

            if(play.length<2){
                list.add(play[play.length-1]);
            }else{
                list.add(play[play.length-1]);
                list.add(play[play.length-2]);
            }

        }
        int[] result = new int[list.size()];

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("----------------");

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < plays.length; j++) {
                if(!visited[j]&&list.get(i)==plays[j]){
                    result[i]=j;
                    System.out.println(result[i]);
                    visited[j]=true;
                    break;

                }
            }
        }



        return result;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {800, 600, 150, 800, 2500};
        System.out.println(solution(genres,plays));

    }
}
