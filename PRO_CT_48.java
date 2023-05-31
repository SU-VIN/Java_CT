 public class PRO_CT_48 {
    //레벨2 조이스틱 그리디
    static int Alpha =0;

    public static int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        String[] arr = new String[name.length()];

        for (int i = 0; i <arr.length; i++) {
            arr[i]=name.substring(i,i+1);
        }

        countAlpah(arr);

        for (int i = 0; i < name.length(); i++) {
            int nextIndex = i+1;
            while (nextIndex<name.length()&&name.charAt(nextIndex)=='A'){
                nextIndex++;
            }

            //정방향 역방향 비교
            move= Math.min(move,(i*2)+name.length()-nextIndex);
            //중간에 방향 틀기
            move=Math.min(move,(name.length()-nextIndex)*2+i);
        }
        return Alpha+move;
    }
    public static void countNext(String name,int move){

    }
    //A = 65 Z =90
    public static void countAlpah(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].contains("A")) continue; //무시

            if(arr[i].charAt(0)<='N'){//N보다 작거나같으면 정방향이 이득
                Alpha+=(arr[i].charAt(0)-'A');
            }else{//N보다 크면 역방향이 이득임
                Alpha+=('Z'-arr[i].charAt(0)+1);
            }
        }
    }


    public static void main(String[] args) {
        String name = "JAN";
        System.out.println(solution(name));

     }
}
