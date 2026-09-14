class Solution {
    public String smallestGoodBase(String n) {
        long x=Long.parseLong(n);
        for(int m=60;m>=1;m--){
            long k=(long)Math.pow(x,1.0/m);
            if(k<2) continue;
            long sum=1,p=1;
            for(int i=1;i<=m;i++){
                if(p>(x-1)/k){sum=x+1;break;}
                p*=k; sum+=p;
            }
            if(sum==x)return ""+k;
        }
        return ""+(x-1);
    }
}
