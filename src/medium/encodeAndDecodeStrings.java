class Solution {
    // prisha note: use string builder next time bruh
    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }

        String encoded = "";

        for (int i = 0; i < strs.size(); i++) {
            String currString = strs.get(i);
            encoded+=currString.length(); 
            encoded+="#";
            encoded+= currString;
        }

        return encoded; 
    }

    public List<String> decode(String str) {

        List<String> decoded = new ArrayList<String>(); 
        int index = 0; 

        while (index < str.length()) {
            int stringIndex = index; 
            while (str.charAt(stringIndex) != '#') {
                stringIndex++; 
            }
            // prisha note : doing integer parse int bc before word, we stored length
            // so looks like 5#happy
            int length = Integer.parseInt(str.substring(index, stringIndex));
            index = stringIndex + 1; 
            stringIndex = index + length; 
            decoded.add(str.substring(index, stringIndex));
            index = stringIndex; 
        }

        return decoded; 

    }
}
