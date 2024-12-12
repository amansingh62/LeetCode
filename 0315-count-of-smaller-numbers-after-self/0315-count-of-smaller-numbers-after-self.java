class Solution {
     static public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        int[] indices = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i; 
        }

        mergeSort(nums, indices, 0, n - 1, result);
        return result;
    }

    static void mergeSort(int[] nums, int[] indices, int start, int end, List<Integer> result) {
        if (start >= end) {
            return; 
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, indices, start, mid, result); 
        mergeSort(nums, indices, mid + 1, end, result);

        merge(nums, indices, start, mid, end, result); 
    }

    static void merge(int[] nums, int[] indices, int start, int mid, int end, List<Integer> result) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        int rightCount = 0;

       
        while (i <= mid && j <= end) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                
                result.set(indices[i], result.get(indices[i]) + rightCount);
                temp[k++] = indices[i++];
            } else {
                rightCount++; 
                temp[k++] = indices[j++];
            }
        }

       
        while (i <= mid) {
            result.set(indices[i], result.get(indices[i]) + rightCount);
            temp[k++] = indices[i++];
        }

       
        while (j <= end) {
            temp[k++] = indices[j++];
        }

       
        for (i = 0; i < temp.length; i++) {
            indices[start + i] = temp[i];
        }
    }
}