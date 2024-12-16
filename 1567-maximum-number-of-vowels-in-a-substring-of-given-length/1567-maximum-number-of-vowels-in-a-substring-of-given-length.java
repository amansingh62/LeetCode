class Solution {
    public int maxVowels(String s, int k) {
        HashMap<Character, Boolean> vowelMap = new HashMap<>();
        vowelMap.put('a', true);
        vowelMap.put('e', true);
        vowelMap.put('i', true);
        vowelMap.put('o', true);
        vowelMap.put('u', true);

        int maxVowels = 0;
        int currVowels = 0;

        for(int i = 0; i < k; i++){
            if(vowelMap.getOrDefault(s.charAt(i), false)){
                currVowels++;
            }
        }
        maxVowels = currVowels;

        for(int i = k; i < s.length(); i++){
            if(vowelMap.getOrDefault(s.charAt(i - k), false)){
                currVowels--;
            }
            if(vowelMap.getOrDefault(s.charAt(i), false)){
                currVowels++;
            }
            maxVowels = Math.max(maxVowels, currVowels);
        }
        return maxVowels;
    }
}