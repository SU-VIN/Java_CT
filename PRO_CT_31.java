import java.util.ArrayList;

//레벨2 n^2 배열 자르기
public class PRO_CT_31 {
    public static Object[] solution(int n, long left, long right) {
        ArrayList<Long> arrayList = new ArrayList<>();

        long max = 0;
        for(long i=left;i<=right;i++){
             max = Math.max(i/n,i%n);
             arrayList.add(max+1);
        }





        return arrayList.toArray();
    }
    public static void main(String[] args) {
        int n =3;
        int left =2;
        int right=5;
        System.out.println(solution(n,left,right));
    }
}
