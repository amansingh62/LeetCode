class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }

        StringBuilder keyBuilder = new StringBuilder();
        for(int c : count){
            keyBuilder.append(c).append('-');
        }

        String key = keyBuilder.toString();

        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(str);

    }
       return new ArrayList<>(map.values());
    }
}