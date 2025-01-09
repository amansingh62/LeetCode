class Solution {
    public int longestArithSeqLength(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }

        int n = nums.length;
        int maxLength = 1;
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for(int i = 0; i < n; i++){
            dp[i] = new HashMap<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j];
                int length = dp[j].getOrDefault(diff, 1) + 1;

                dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 1), length));

                maxLength = Math.max(maxLength, dp[i].get(diff));
            }
        }
        return maxLength;
    }
}