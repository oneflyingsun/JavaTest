package algorithm;
/**
 * @Author: ZhaoCong
 * @Date: 2019-01-11
 * @Description:
 */
public class HouseRobber {


    private static int rob(int[] nums, int start, int end) {
        int preMax = nums[start];
        int curMax = Math.max(preMax, nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = curMax;
            curMax = Math.max((preMax + nums[i]), curMax);
            preMax = temp;
        }
        return curMax;
    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        // 动态规划，在 198 号问题基础上修改
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            // 考虑不抢劫 0 号房间和不抢劫 n-1 号房间的情况
            return Math.max(rob2(nums, 0, n - 2), rob2(nums, 1, n - 1));
        }

    }

    public static int rob2(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[0] = nums[start + 0];
        dp[1] = Math.max(dp[0], nums[start+1]);
        if (end - start <= 1) {
            return Math.max(dp[0], dp[1]);
        }
        for (int i = 2; i <= end-start; i++) {
            dp[i] = Math.max(nums[start+i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end-start];
    }
}
