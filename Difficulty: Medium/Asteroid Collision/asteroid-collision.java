// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        int n=N;
        ArrayList<Integer> st=new ArrayList<>(); // use as a stack

        for(int i=0;i<n;i++){

            if(asteroids[i]>0) st.add(asteroids[i]);

            else{

                while(!st.isEmpty() && st.get(st.size()-1)>0 && st.get(st.size()-1)<Math.abs(asteroids[i])){
                    st.remove(st.size()-1);
                }

                if(!st.isEmpty() &&st.get(st.size()-1)==Math.abs(asteroids[i]) )  st.remove(st.size()-1);

                else if(st.isEmpty() || st.get(st.size()-1)<0) st.add(asteroids[i]);
            }
        }

        int[] ans=new int[st.size()];
        for(int i=0;i<st.size();i++){
            ans[i]=st.get(i);
        }

        return ans;
        
    }
}
