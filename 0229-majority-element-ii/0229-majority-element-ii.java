class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int count1 = 0, count2 = 0;
        int ans1 = Integer.MIN_VALUE, ans2 = Integer.MIN_VALUE;

        for(int num : nums){
            if(num == ans1){
                count1++;
            }
            else if(num == ans2){
                count2++;
            }
            else if(count1 == 0){
                ans1 = num;
                count1++;
            }
            else if(count2 == 0){
                ans2 = num;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(num == ans1){
                count1++;
            }
            else if(num == ans2){
                count2++;
            }
        }
        int length = nums.length / 3;
        if(count1 > length){
            result.add(ans1);
        }
        if(count2 > length){
            result.add(ans2);
        }

        return result; 
    }
}