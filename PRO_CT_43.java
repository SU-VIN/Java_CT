import java.util.HashSet;

//레벨1 폰켓몬 해시 25m
public class PRO_CT_43 {

    public static int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length/2; //pick마리 선택해야함

//        Arrays.sort(nums);
//        int cnt=0;
//        for (int i = 0; i < nums.length-1; i++) {
//            if(cnt==pick)break;
//
//            if(nums[i]!=nums[i+1])cnt++;
//
//        }
//
//        if(cnt!=pick)cnt++;
        //Hash 풀이
        HashSet<Integer> ponketmon = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!ponketmon.contains(nums[i])) ponketmon.add(nums[i]);
        }

        int cnt = ponketmon.size()>pick?pick:ponketmon.size();
        return cnt;
    }


    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));

    }


}
