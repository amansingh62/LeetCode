class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m * k > n) return -1;

        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for(int bloom : bloomDay){
            start = Math.min(start, bloom);
            end = Math.max(end, bloom);
        }

        while(start < end){
            int mid = start + (end - start) / 2;
            if(canMakeBouquets(bloomDay, m, k, mid)){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
        }
    

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int mid){
       int bouquets = 0, flowers = 0;
       for(int day : bloomDay){
        if(day <= mid){
            flowers++;
            if(flowers == k){
                bouquets++;
                flowers = 0;
            }
        }
        else{
            flowers = 0;
        }
        if(bouquets >= m){
            return true;
        }
       
       }
        return false;
    }
}
