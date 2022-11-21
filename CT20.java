import java.util.Scanner;

//DFS - 바둑이승차 풀었지만 출력이 너무 많이 나옴. ㅅㅂ 해결함
class CT20{
    static int Max;
    static int n;
    static int[] arr;
    static int[] check;
    static int maxResult;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Max=scanner.nextInt();
        n=scanner.nextInt();

        arr=new int[n]; //몸무게
        check=new int[n+1]; //체크배열


        for(int i=0;i<n;i++) {
            arr[i]=scanner.nextInt();
        }

        DFS(1);
        System.out.println(maxResult);
    }

    public static void DFS(int v) {
        if(v==n+1) {
            int sum=0;
            for(int i=1;i<=n;i++) {
                if(check[i]==1) {
                    sum+=arr[i-1];
                }
                if(sum<=Max&&sum>maxResult) {
                    maxResult=sum;
                }

            }

        }else {
            check[v]=1;
            DFS(v+1);

            check[v]=0;
            DFS(v+1);

        }
    }

}