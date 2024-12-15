class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> remainderCount = new HashMap();
        remainderCount.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for(int num : nums){
            prefixSum += num;
            int remainder = prefixSum % k;

            if(remainder < 0){
                remainder += k;
            }
            
            count += remainderCount.getOrDefault(remainder, 0);
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}