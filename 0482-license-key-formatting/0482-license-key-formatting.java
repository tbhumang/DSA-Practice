class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String t=s.replace("-","").toUpperCase();
        StringBuilder r=new StringBuilder();
        int n=t.length(), first=n%k;
        if(first>0) r.append(t.substring(0,first));
        for(int i=first;i<n;i+=k) {
            if(r.length()>0) r.append("-");
            r.append(t.substring(i,Math.min(i+k,n)));
        }
        return r.toString();
    }
}
