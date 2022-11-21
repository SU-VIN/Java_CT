//큐- 공주구하기
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CT19{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int count=0;
        int answer=0;
        Queue<Integer> queue =new LinkedList<>();
        for(int i=1;i<=n;i++) {
            queue.offer(i);
        }

        while(queue.size()!=0) {
            for(int i=1;i<t;i++) {
                queue.offer(queue.remove());
            }
            queue.remove();

            if(queue.size()==1) {
                answer=queue.remove();
            }


        }
        System.out.println(answer);

    }
}