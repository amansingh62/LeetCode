class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int start = 0;
        int end = n;
        int[] result = new int[n + 1];
        
        for(int i = start; i < n; i++){
            if(s.charAt(i) == 'I'){
                result[i] = start++;
            }
            else{
                result[i] = end--;
            }
        }
        result[n] = start;
        return result;
    }
}