import java.util.Arrays;
//최소 직사각형
public class Ct14 {
    public int solution(int[][] sizes) {
        int temp = 0;
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }

            if(max1<sizes[i][0]){
                max1=sizes[i][0];
            }
            if(max2<sizes[i][1]){
                max2=sizes[i][1];
            }

        }

        return max1*max2;
    }

    public static void main(String[] args) {
        Ct14 sol = new Ct14();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(sol.solution(sizes));

    }
}
