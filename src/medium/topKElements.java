class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // prisha note: hashmap stores number + freq
        HashMap<Integer, Integer> numFreq = new HashMap<Integer, Integer>(); 

        for (int i = 0; i < nums.length; i++) {
            if (numFreq.containsKey(nums[i])) {
                int currFreq = numFreq.get(nums[i]);
                numFreq.put(nums[i], currFreq + 1);
            } else {
                numFreq.put(nums[i], 1);
            }
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>(); 
        }

        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            int num = entry.getKey(); 
            int freqValue = entry.getValue(); 
            freq[freqValue].add(num);
        }

        int answer[] = new int[k];
        int index = 0; 
        for (int i = freq.length - 1; i > 0; i--) {
            if (index < k) {
                for (int x : freq[i]) {
                    answer[index] = x; 
                    index++; 
                    if (index == k) {
                        return answer; 
                    }
                }
            }
        }

        return answer; 
    }
}
