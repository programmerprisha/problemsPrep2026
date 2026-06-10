class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> values = new HashMap<>(); 

        for (int i = 0; i < strs.length; i++) {
            String currWord = strs[i];
            int[] letters = new int[26];
            for (int k = 0; k < currWord.length(); k++) {
                letters[currWord.charAt(k) - 'a']++; 
            }
            if (values.containsKey(Arrays.toString(letters))){
                List<String> list = values.get(Arrays.toString(letters));
                System.out.println("here");
                list.add(currWord);
                values.put(Arrays.toString(letters), list);
            }
            else {
                List<String> list = new ArrayList<String>(); 
                list.add(currWord);
                values.put(Arrays.toString(letters), list);
            }
        }

        List<List<String>> answer = new ArrayList<List<String>>(); 

        for (List<String> val: values.values()) {
            answer.add(val);
        }
        return answer;
        
    }
}