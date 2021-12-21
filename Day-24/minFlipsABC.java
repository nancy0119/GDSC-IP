// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/minimum-flips-abc/ojquestion
class minFlipsABC {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        int currOr = a | b;
        for(int i = 0; i < 32; i++){
            int mask = (1 << i);
            int cOB = (mask & currOr);
            int cB = (mask & c);
            if(cOB != cB){
                if(cB != 0)ans++;
                else{
                    int aB = (mask & a);
                    int bB = (mask & b);
                    if(aB != 0 && bB != 0)ans += 2;
                    else ans++;
                }
            }
        }
        return ans;
    }
}
// cOB - currOrBit
// cB - cBit