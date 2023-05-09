import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//로봇청소기 골드5 구현 시물레이션
public class BJ_CT_49 {
    static int[] arr;
    static String[] saw;

    static public class Saw{
        int num,dir;

        public Saw(int num,int dir){
            this.num = num;
            this.dir=dir;
        }
    }

 public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    saw = new String[4];
    for (int i = 0; i < 4; i++) {
        saw[i]=br.readLine();
    }
    int N = Integer.parseInt(br.readLine());
    ArrayDeque<Saw> dq = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        dq.addLast(new Saw(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));

    }

    //데이터 삽입 끝--------------------------------------------

    //N = 0  S =1
    //1= 시계 -1 = 반시계

    while(!dq.isEmpty()){

        Saw now = dq.pollFirst();
        arr = new int [4];
        arr[now.num]=now.dir;
        if(now.num==0){
            zero(now.num,now.dir);
        }else if(now.num==1){
            one(now.num,now.dir);
        }else if(now.num==2){
            two(now.num,now.dir);
        }else{
            three(now.num, now.dir);
        }


        for (int i = 0; i < 4; i++) {
            if(arr[i]==1){
                saw[i]=right(saw[i]);
            }else if(arr[i]==-1){
                saw[i]=left(saw[i]);
            }
        }
    }

    int result = 0;
    if(saw[0].substring(0,1).equals("1")){
        result+=1;
    }
    if(saw[1].substring(0,1).equals("1")){
        result+=2;
    }
    if(saw[2].substring(0,1).equals("1")){
        result+=4;
    }
    if(saw[3].substring(0,1).equals("1")){
        result+=8;
    }
    System.out.println(result);
}




public static void zero(int nowIndex, int direction){
    if(saw[nowIndex].substring(2,3).equals(saw[1].substring(6,7))){
        arr[1]=0;
    }else{
        arr[1]=direction*-1;
    }

    if(saw[1].substring(2,3).equals(saw[2].substring(6,7))){
        arr[2]=0;
    }else{
        arr[2]=arr[1]*-1;
    }

    if(saw[2].substring(2,3).equals(saw[3].substring(6,7))){
        arr[3]=0;
    }else{
        arr[3]=arr[2]*-1;
    }
}
public static void one(int nowIndex, int direction){
    if(saw[nowIndex].substring(6,7).equals(saw[0].substring(2,3))){
        arr[0]=0;
    }else{
        arr[0]=direction*-1;
    }

    if(saw[nowIndex].substring(2,3).equals(saw[2].substring(6,7))){
        arr[2]=0;
    }else{
        arr[2]=direction*-1;
    }

    if(saw[2].substring(2,3).equals(saw[3].substring(6,7))){
        arr[3]=0;
    }else{
        arr[3]=arr[2]*-1;
    }
}
public static void two(int nowIndex, int direction){
    if(saw[nowIndex].substring(6,7).equals(saw[1].substring(2,3))){
        arr[1]=0;
    }else{
        arr[1]=direction*-1;
    }

    if(saw[nowIndex].substring(2,3).equals(saw[3].substring(6,7)) ){
        arr[3]=0;
    }else{
        arr[3]=direction*-1;
    }

    if(saw[1].substring(6,7).equals(saw[0].substring(2,3)) ){
        arr[0]=0;
    }else{
        arr[0]=arr[1]*-1;
    }
}
public static void three(int nowIndex, int direction){
    if(saw[nowIndex].substring(6,7).equals( saw[2].substring(2,3))){
        arr[2]=0;
    }else{
        arr[2]=direction*-1;
    }

    if(saw[1].substring(2,3).equals(saw[2].substring(6,7))){
        arr[1]=0;
    }else{
        arr[1]=arr[2]*-1;
    }

    if(saw[0].substring(2,3).equals(saw[1].substring(6,7))){
        arr[0]=0;
    }else{
        arr[0]=arr[1]*-1;
    }
}
//시계
public static String right(String str){
    String start = str.substring(0, 7);
    String end = str.substring(7);
    return end+start;
}

//반시계
public static String left(String str){
    String start = str.substring(0,1);
    String end = str.substring(1);
    return end+start;
}
}
