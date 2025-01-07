class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;

        int[] minDP = new int[amount + 1];

        for(int i = 1; i <= amount; i++){
            minDP[i] = Integer.MAX_VALUE;
           
           for(int coin : coins){
            if(coin <= i && minDP[i - coin] != Integer.MAX_VALUE){
                minDP[i] = Math.min(minDP[i], 1 + minDP[i - coin]);
            }

           }
        }

         return minDP[amount] == Integer.MAX_VALUE ? -1 : minDP[amount];
    }
}