// Link: https://leetcode.com/problems/next-greater-element-i/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap <Integer, Integer> hm = new HashMap<>();
        Stack <Integer> st = new Stack<>();
        for (Integer num : nums2){
            while(!st.isEmpty() && st.peek() < num) 
                hm.put(st.pop(), num);
            st.push(num);
        }
        
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = hm.getOrDefault(nums1[i], -1);
        } 
        
        return nums1;
        
        //M-1 brute force:         
        // int ans[] = new int[nums1.length];
        // for(int i = 0; i < nums1.length; i++) {
        //     int idx2 = 0;
        //     ans[i] = -1;
        //     while(idx2 < nums2.length && nums1[i] != nums2[idx2]) idx2++;
        //     idx2++;
        //     while(idx2 < nums2.length) {
        //         if(nums1[i] < nums2[idx2]){
        //             ans[i] = nums2[idx2];
        //             break;
        //          }
        //         idx2++;
        //     }
        // }
        // return ans;
    }
