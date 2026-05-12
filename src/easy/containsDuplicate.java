class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> mappedNums = new HashSet<>(); 
        for (int i = 0; i < nums.length; i++) {
            if (mappedNums.contains(nums[i])){
                return true; 
            }
            mappedNums.add(nums[i]);
        }
        return false; 
    }
}