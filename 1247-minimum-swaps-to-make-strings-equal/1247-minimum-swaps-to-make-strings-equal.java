class Solution {
    public int minimumSwap(String s1, String s2) {
        int swap = 0;
        int c1=0;// counts XY
        int c2=0;// countsYX
        for(int i=0;i<s1.length();i++){
       if(s1.charAt(i)=='x' && s1.charAt(i)!=s2.charAt(i))
       {
        c1+=1;
       }
       if(s1.charAt(i)=='y' && s1.charAt(i)!=s2.charAt(i))
       {
        c2+=1;
       }
        }
      if((c1+c2)%2!=0) return -1;
      else
      {
        swap = (c1/2)+(c2/2);
        if(c1%2 == 1)
         swap += 2;
      }
      return swap;
    }
}