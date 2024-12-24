class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0, end = 0;
        for(int num : nums){
            start = Math.max(start, num);
            end += num;
        }

        while(start < end){
            int mid = start + (end - start) / 2;
            if(canSplit(nums, k, mid)){
                end = mid;
            }
            else{
                start = mid  + 1;
            }
        }
        return start;
    }

    private boolean canSplit(int[] nums, int k, int mid){
        int subArrayCount = 1;
        int currSum = 0;

        for(int num : nums){
            if(currSum + num > mid){
                subArrayCount++;
                currSum = num;

                if(subArrayCount > k){
                    return false;
                }
            }
             else{
                    currSum += num;
                }
        }
        return true;
    }
}