public class binaryTree {

    private  static final int ANS = 17;
    public static void main(String[] args) {
        int left =1; //답으로 나올 수 있는 최소값
        int right = 50; //답으로 나올 수 있는 최대값

        while (left<right){
            int mid = (left+right)/2;
            if(isPossible(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        System.out.println("result = "+left);
    }

    private static boolean isPossible(int answer){
        if(answer>=ANS){
            return true; //작거나 답일때
        }
        return false; //클때
    }
}
