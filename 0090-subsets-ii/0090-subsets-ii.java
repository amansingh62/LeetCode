class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, current, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result){
       result.add(new ArrayList<>(current));

       for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i - 1]) continue;

        current.add(nums[i]);
        backtrack(nums, i + 1, current, result);
        current.remove(current.size() - 1);
       }
    }
}