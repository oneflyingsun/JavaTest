package algorithm;
/*
*   算法
*   所有元素都是成对的，只有一个元素是单一的，求问如何在O(N)的复杂度里面找出这个元素
*
* */

public class OnlyOneNum {
    public static int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }
    public static void main(String []args){
        int[] nums={2,2,4};
        System.out.println(singleNumber(nums));
    }
}
/*

 */