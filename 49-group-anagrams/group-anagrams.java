class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // \U0001f447 same as Valid Anagram
            char[] chars = str.toCharArray(); 
            Arrays.sort(chars); 
            String key = new String(chars); // \U0001f448 sorted version as key

            // group them in map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
