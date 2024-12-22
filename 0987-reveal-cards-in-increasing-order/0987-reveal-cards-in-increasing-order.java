class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < deck.length; i++){
            queue.offer(i);
        }
        int[] result = new int[deck.length];

        for(int card : deck){
            result[queue.poll()] = card;

            if(!queue.isEmpty()){
               queue.offer(queue.poll());
            }
        }
        return result;
    }
}