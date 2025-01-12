class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int buy = -prices[0];
        int sell = 0;
        int cooldown = 0;

        for(int i = 1; i < prices.length; i++){
            int preBuy = buy;
            int preSell = sell;

            buy = Math.max(preBuy, preSell - prices[i]);
            sell = Math.max(preSell, cooldown);
            cooldown = preBuy + prices[i];
        }
        return Math.max(sell, cooldown);
    }
}