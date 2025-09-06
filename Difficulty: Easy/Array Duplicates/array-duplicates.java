class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()>1){
                ans.add(m.getKey());
            }
        }
        return ans;
    }
}