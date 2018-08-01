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
