class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> values = new HashSet<Integer>(); 
        int answer = 0; 

        for (int i = 0; i < nums.length; i++) {
            values.add(nums[i]);
        }

        for (int num : values) {
            int currNum = num;
            if (values.contains(currNum - 1) == false) {
                int currStreak = 0; 
                int value = currNum; 
                while (values.contains(value)) {
                    currStreak++; 
                    value++; 
                }

                if (currStreak > answer) {
                    answer = currStreak; 
                }
            }
        }

        return answer; 
    }
}