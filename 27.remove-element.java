/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] == val){
                nums[i] = nums[n--];
            }
        }
    }
}
// @lc code=end

/*
    3, 2, 1, 3

*/

