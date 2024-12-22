class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0, end = rows * cols - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            int midRow = mid / cols;
            int midCol = mid % cols;
            int midValue = matrix[midRow][midCol];

            if(midValue == target){
                return true;
            }
            else if(midValue < target){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}