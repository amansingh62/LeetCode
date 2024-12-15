class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int count = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 1; j < cols; j++){
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for(int start = 0; start < cols; start++){
            for(int end = start; end < cols; end++){
              HashMap<Integer, Integer> mapSum = new HashMap<>();
              mapSum.put(0, 1);
              int currSum = 0;
            
            for(int i = 0; i < rows; i++){
                int rowSum = matrix[i][end];
                if(start > 0){
                    rowSum -= matrix[i][start - 1];
                }
                currSum += rowSum;

                count += mapSum.getOrDefault(currSum - target, 0);
                mapSum.put(currSum, mapSum.getOrDefault(currSum, 0) + 1);
            }
            }
        }
        return count;
    }
}