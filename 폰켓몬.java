

import java.util.HashSet;

public class 폰켓몬 {
    
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            int length = (nums.length)/2;
            HashSet<Integer> hash = new HashSet<Integer>();

            for(int i=0;i<nums.length;i++){
                hash.add(nums[i]);
            }

            

            return hash.size()<length?hash.size():length;
        }
    }


    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        System.out.println(nums);

    }
}
