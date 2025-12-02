class Solution {
    static class Item{
        int value,weight;
        double ratio;
        
        Item(int value,int weight){
            this.value=value;
            this.weight=weight;
            this.ratio=(double)value/weight;
        }
    }
    
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        
        int n=val.length;
        Item[] items=new Item[n];
        for(int i=0;i<n;i++){
            items[i]=new Item(val[i],wt[i]);
        }
        
       Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        
        double ans=0;
        for(Item itm:items){
            if(capacity==0) break;
            
            if(itm.weight<=capacity){
                ans+=itm.value;
                capacity-=itm.weight;
            }
            else{
                ans+=capacity*itm.ratio;
                capacity=0;
            }
        }
        
        return ans;
    }
}