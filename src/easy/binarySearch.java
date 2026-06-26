class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; 

        while (left <= right) {
            int index = (left + right)/2; 
            if (nums[index] == target) {
                return index; 
            } else if (nums[index] < target) {
                left++; 
            } else {
                right--;
            }
        }

        return -1;  
    }
}
