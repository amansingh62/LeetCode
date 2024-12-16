class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();
        int maxCount = 0; 
      
        
            for(int i = 0; i <= n - minSize; i++){
                String substring = s.substring(i, i + minSize); 

                if(uniqueCharacter(substring) <= maxLetters){
                    map.put(substring, map.getOrDefault(substring, 0) + 1);
                    maxCount = Math.max(maxCount, map.get(substring));
                }
            }
            return maxCount;
        }
        
    private int uniqueCharacter(String substring){
        HashSet<Character> set = new HashSet<>();
        for(char c : substring.toCharArray()){
            set.add(c);
        }
        return set.size();
    }
}