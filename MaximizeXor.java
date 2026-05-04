//BRUTEFORCE-APPROACH
import java.util.*;
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int q = queries.length;
        int ans[] = new int[q];

        for(int i=0;i<q;i++){
            int x = queries[i][0];
            int m = queries[i][1];

            int max = -1;
            for(int num:nums){
                if(num <= m){
                    max = Math.max(max,x ^ num);
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}
