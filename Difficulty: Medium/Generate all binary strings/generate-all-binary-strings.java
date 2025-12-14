class Solution {
    private static void genrate(int n,String curr,ArrayList<String> res ){
      if(curr.length()==n){
          res.add(curr);
          return;
      }  
      
      // add 0 always try
      genrate(n,curr+"0",res);
     
     // try to add 1 if previous is not 1
     if(curr.isEmpty() || curr.charAt(curr.length()-1)!=1){
         genrate(n,curr+"1",res);
     }
    }
    public ArrayList<String> binstr(int n) {
        
        ArrayList<String> res=new ArrayList<>();
        genrate(n,"",res);
        return res;
    }
}
