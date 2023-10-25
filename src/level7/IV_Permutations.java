/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 15-02-2022/02/2022
 *   Time: 10:39 PM
 *   File: IV_Permutations
 */

/**
 * LEETCODE QUESTION 46 =>
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any
 * order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 */

package level7;

import java.util.ArrayList;
import java.util.List;

public class IV_Permutations {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int index = 0;
            solve(nums, ans, index);
            return ans;
        }

        private void solve(int[] nums, List<List<Integer>> ans, int index) {
            if (index >= nums.length) {
                List<Integer> list = new ArrayList<>();
                for (int num : nums) {
                    list.add(num);
                }
                ans.add(new ArrayList<>(list));
                return;
            }

            for (int i = index; i < nums.length; i++) {
                swap(i, index, nums);
                solve(nums, ans, index + 1);
                swap(i, index, nums);
            }
        }

        private void swap(int i, int j, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
