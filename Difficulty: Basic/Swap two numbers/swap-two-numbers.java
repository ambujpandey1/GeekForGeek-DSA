class Solution {
    static List<Integer> get(int a, int b) {
        // code here
        a=a^b;
        b=a^b;
        a=a^b;
        
        List<Integer> ans=new ArrayList<>();
        ans.add(a);
        ans.add(b);
        return ans;
    }
}