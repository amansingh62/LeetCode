class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> dp = new HashMap<>();

        for(int stone : stones){
            dp.put(stone, new HashSet<>());
        } 

        dp.get(0).add(1);

        for(int stone : stones){
            for(int jump : dp.get(stone)){
                int nextPosition = stone + jump;

                if(dp.containsKey(nextPosition)){
                    if(jump - 1 > 0) dp.get(nextPosition).add(jump - 1);
                    dp.get(nextPosition).add(jump);
                    dp.get(nextPosition).add(jump + 1);
                }
            }
        }
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}