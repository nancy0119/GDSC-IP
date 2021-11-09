// Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/restore-ip-addresses-official/ojquestion

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List <String> set = new ArrayList<>();
        restoreHelper(s, 0, 0, "", set);
        return set;
    }
    
    public void restoreHelper(String s, int par, int idx, String ans, List <String> set){
        if(par == 4 || s.length() == idx){
            if(par == 4 && s.length() == idx){
                set.add(ans.substring(0, ans.length() - 1));
            }
            return;
        }
        restoreHelper(s, par + 1, idx + 1, ans + s.charAt(idx) + ".", set);
        if(idx + 2 <= s.length() && isValid(s.substring(idx, idx + 2)))
            restoreHelper(s, par + 1, idx + 2, ans + s.substring(idx, idx + 2) + ".", set);
        if(idx + 3 <= s.length() && isValid(s.substring(idx, idx + 3)))
            restoreHelper(s, par + 1, idx + 3, ans + s.substring(idx, idx + 3) + ".", set);
    }
    public boolean isValid(String str){
        if(str.charAt(0) == '0')return false;
        int no = Integer.parseInt(str);
        return no >= 0 && no <=255;
    }
}