class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // prisha note: had to sort the array to effectively use the two pointer approach!!!
        // also the duplicate checks -- be careful

        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1; 
            int right = nums.length - 1; 
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; 
            }
            if (nums[i] > 0) {
                break; 
            }
        
            while (left < right) {
                List<Integer> currList = new ArrayList<Integer>(); 
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    currList.add(nums[i]);
                    currList.add(nums[left]);
                    currList.add(nums[right]);
                    answer.add(currList);
                    left++; 
                    right--; 
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++; 
                    }
                } else if (sum < 0) {
                    left++; 
                } else {
                    right--;
                }
            }
        }

        return answer;  

    }
}
