class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false; 
        }

        s = s.toLowerCase(); 
        t = t.toLowerCase();

        HashMap<Character, Integer> sTrack = new HashMap<>(); 
        HashMap<Character, Integer> tTrack = new HashMap<>(); 

        // prisha note: loop logic could have been simplified if used line
        // sTrack.put(i, sTrack.getOrDefault(i, 0) + 1); and vice versa for tTrack

        for (int i = 0; i < s.length(); i++) {
            if (sTrack.containsKey(s.charAt(i)) == false) {
                sTrack.put(s.charAt(i), 1);
            } else {
                sTrack.put(s.charAt(i), sTrack.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (tTrack.containsKey(t.charAt(i)) == false) {
                tTrack.put(t.charAt(i), 1);
            } else {
                tTrack.put(t.charAt(i), tTrack.get(t.charAt(i)) + 1);
            }
        }


        return sTrack.equals(tTrack);

        // prisha note: another cool way to solver (faster than hashmap approach) is to use an array of size 26 to track the count of each character in s and t.
        // prisha note: code also does test case check and lowercase conversion like above
        /*
        int count[] = new int[26]; 

        for (int i = 0; i < count.length; i++) {
            count[s.charAt(i) - 'a']++; 
            count[t.charAt(i) - 'a']--;
        }

        for (int x: count) {
            if (x != 0) {
                return false; 
            }
        }

        return true; 
        */

    }
}
