import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//주사위 게임 - 브론즈 3 구현
public class BJ_CT_2 {
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n=sc.nextInt();
//        int max=0;
//
//        for(int i=0;i<n;i++){
//            int sum=0;
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int x= Integer.parseInt(st.nextToken());
//            int y= Integer.parseInt(st.nextToken());
//            int z= Integer.parseInt(st.nextToken());
//
//            if(x==y&&y==z){ //다같은눈
//                sum=10000+(x*1000);
//            }else if (x!=y&&y!=z&&z!=x){ //다다른눈
//                sum=Math.max(Math.max(x,y),z)*100;
//            }else{ //같은눈이 2개만
//                if(x==y) sum= 1000+(x*100);
//                else if(y==z) sum= 1000+(x*100);
//                else if(z==x) sum= 1000+(x*100);
//            }
//
//            if(sum>max) max=sum;
//        }
//
//        System.out.println(max);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int max=0;

        for(int i=0;i<n;i++){
            int sum=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            int z= Integer.parseInt(st.nextToken());

            if(x==y&&y==z){ //다같은눈
                sum=10000+(x*1000);
            }else if (x!=y&&y!=z&&z!=x){ //다다른눈
                sum=Math.max(Math.max(x,y),z)*100;
            }else{ //같은눈이 2개만
                if(x==y) sum= 1000+(x*100);
                else if(y==z) sum= 1000+(y*100);
                else if(z==x) sum= 1000+(z*100);
            }

            if(sum>max) max=sum;
        }

        System.out.println(max);
    }
}
