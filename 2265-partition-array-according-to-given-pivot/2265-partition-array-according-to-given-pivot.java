class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       int[] result = new int[nums.length];
       int start = 0;

       for(int num : nums){
        if (num < pivot) {
                result[start++] = num;  
            }  }
        for (int num : nums) {
        if (num == pivot) {
            result[start++] = num;
        }
    }
    for (int num : nums) {
        if (num > pivot) {
            result[start++] = num;
        }
    }
    
    return result;
}
}