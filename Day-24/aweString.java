// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/bit-manipulation/find-longest-awesome-substring/ojquestion


class aweString {
    public int longestAwesome(String s) {
// M1
//         Integer state = 0;
//         int ans = 0;
//         HashMap<Integer, Integer> stateIdx = new HashMap<>();
//         stateIdx.put(0, -1);
//         for(int i = 0; i < s.length(); i++){
//             char c = s.charAt(i);
//             int mask = (1 << (c - '0'));
//             state ^= mask;
//             //check for even
//             Integer j = stateIdx.get(state);
//             if(j != null){
//                 ans = Math.max(ans, i -  j);
//             }
//             //check for odd
//             for(int no = 0; no < 10; no++){
//                 j = stateIdx.get(state ^ (1 << no));
//                 if(j != null){
//                     ans = Math.max(ans, i -  j);
//                 }
//             }
//             if(!stateIdx.containsKey(state))stateIdx.put(state, i);
//         }
//         

// M2
            Integer stateIdx[] = new Integer[(1 << 10)];
            int ans = 0;
            int state = 0;
            stateIdx[0] = -1;
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                int mask = (1 << (ch - '0'));
                state ^= mask;
                //check for even
                Integer j = stateIdx[state];
                if(j != null)ans = Math.max(ans, i - j);
                //check for odd
                for(int no = 0; no < 10; no++){
                    j = stateIdx[state ^ (1 << no)];
                    if(j != null)ans = Math.max(ans, i - j);
                }
                if(stateIdx[state] == null)stateIdx[state] = i;
            }
        return ans;
    }
}