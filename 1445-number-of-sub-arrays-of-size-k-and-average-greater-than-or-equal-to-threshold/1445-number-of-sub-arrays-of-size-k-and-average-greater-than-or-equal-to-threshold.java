class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int average = k * threshold;
        int currSum = 0; 
        int count = 0;
        
        for(int i = 0; i < k; i++){
           currSum += arr[i];
        }
         if(currSum >= average){
            count++;
         }

         for(int i = k; i < arr.length; i++){
            currSum += arr[i];
            currSum -= arr[i - k];

            if(currSum >= average){
                count++;
            }
         }
         return count;
    }
}