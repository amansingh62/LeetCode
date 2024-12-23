class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for(int pile : piles){
            end = Math.max(end, pile);
        }

        while(start < end){
            int mid = start + (end - start) / 2;
            if(canEatInTime(piles, h, mid)){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean canEatInTime(int[] piles, int h, int speed){
        int hours = 0;
        for(int pile : piles){
            hours += Math.ceil((double) pile / speed);
        }
        return hours <= h;
    }
}