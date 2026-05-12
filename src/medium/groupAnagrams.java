class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> tracker = new HashMap<>(); 

        for (int i = 0; i < strs.length; i++) {
            String currWord = strs[i];
            int count[] = new int[26];
            for (int k = 0; k < currWord.length(); k++) {
                char currChar = currWord.charAt(k);
                count[currChar - 'a']++; 
            }
            String key = Arrays.toString(count);
            tracker.putIfAbsent(key, new ArrayList<>());
            tracker.get(key).add(currWord);
        }
        return new ArrayList<>(tracker.values());
    }
}