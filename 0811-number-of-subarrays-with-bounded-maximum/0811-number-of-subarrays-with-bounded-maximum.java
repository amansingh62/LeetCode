class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0; 
        int start = 0; 
        int lastValid = -1; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                start = i + 1;
                lastValid = -1;
            } else if (nums[i] >= left) {
                lastValid = i;
            }
            
            if (lastValid != -1) {
                count += lastValid - start + 1;
            }
        }

        return count;
    }
}
