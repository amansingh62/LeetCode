class Solution {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return backtrack(n, 1, visited);
    }

    private int backtrack(int n, int index, boolean[] visited){
        if(index > n){
            return 1;
        }

        int count = 0;
        for(int num = 1; num <= n; num++){
            if(!visited[num] && (num % index == 0 || index % num == 0)){
                visited[num] = true;
                count += backtrack(n, index + 1, visited);
                visited[num] = false;
            }
        }
        return count;
    }
}