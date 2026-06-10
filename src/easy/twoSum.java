class Solution {
    public int[] twoSum(int[] nums, int target) {
        // prisha note: store index not value for value
        // key == nums[i] and value = i
       HashMap<Integer, Integer> map = new HashMap<>(); 

       for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.containsKey(target - curr)) {
                return new int[] {map.get(target - curr), i};
            }
            map.put(curr, i);
       }

       return new int[0];
    }
}
