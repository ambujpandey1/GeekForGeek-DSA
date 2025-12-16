// User function Template for Java
class Solution {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) return "";

        String prefix = arr[0];

        for (int i = 1; i < arr.length; i++) {
            while (!arr[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }
        return prefix;
        
    }
}