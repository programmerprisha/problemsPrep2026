class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int answer[] = new int[nums.length - k + 1];
        Deque<Integer> list = new LinkedList<>(); 
        int left = 0; 
        int right = 0; 

        // prisha note: deque stores index not value and 
        while (right < nums.length) {
            while (list.isEmpty() == false && nums[list.getLast()] < nums[right]) {
                list.removeLast(); 
            }
            // adding index
            list.addLast(right);

            // prisha note: if the index is not in sliding window like window is 2nd element - 4th element, remove first element from the deque
            if (left > list.getFirst()) {
                list.removeFirst(); 
            }

            if ((right + 1) >= k) {
                answer[left] = nums[list.getFirst()];
                left++; 
            }

            right++; 
        }

        return answer; 
        
    }
}
