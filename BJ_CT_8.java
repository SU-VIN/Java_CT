import java.util.Scanner;
//부녀회장이 될테야 -브론즈1- 구현
public class BJ_CT_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] result = new int[tc];
        for(int i=0;i<tc;i++){
            int a=sc.nextInt();//층
            int b=sc.nextInt();//호
            int[][] arr= new int[a+1][b]; //층이 0층부터 시작하므로 a+1행

            for(int j=0;j<=a;j++){
                for(int k=0;k<b;k++){
                    int sum=0; //a-1층의 1~b호까지 저장해 줄 변수
                    int n=0;

                    if(j==0) arr[j][k]=k+1; //0층은 i호에 i명 산다
                    else{ //0층 이상층일때
                        while(n<=k) { //1~b호까지 무한루프 돈다
                            sum += arr[j - 1][n];
                            n++;
                        }
                        arr[j][k]=sum;///a-1층의 1~b호까지 인원수 저장한걸 넣어줌
                    }
                }
            }

            result[i]=arr[a][b-1];//만약 2층 3호라면 [3][3]배열이 생성되기 때문에 a층 b호의 인원수 뽑기위해
        }
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }
}
