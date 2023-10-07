package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @link <a href="https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75">
 *     1679. Max Number of K-Sum Pairs</a>
 */
public class MaxPairs {

    public static void main(String[] args) {
        System.out.println(maxOperationsMinus(new int[]{3, 1, 3, 4, 3, 5, 5}, 6));
    }
    public static int maxOperationsTwoPointers(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int count = 0;
        while(low<high){
            int temp = nums[low]+nums[high];
            if(temp == k){
                low++;
                high--;
                count++;
            }else if(temp<k){
                low++;
            }else
                high--;
        }
        return count;
    }
    public static int maxOperationsMinus(int[] nums, int k) {

        int operation = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1 || nums[i] > k) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == -1 || nums[j] > k) continue;
                if (nums[i] + nums[j] == k) {
                    nums[i] = -1;
                    nums[j] = -1;
                    operation++;
                    break;
                }
            }
        }
        return operation;
    }

    public static int maxOperationsMap(int[] nums, int k) {
        int operation = 0;
        Arrays.sort(nums);
        int min = nums[0];
        int max = k - min;
        int maxIndex = 0;
        Set<Integer> index = new HashSet<>();
        for (int num : nums) {
            if (num <= max) {
                maxIndex++;
            }
        }
        System.out.println(maxIndex);
        for (int i = 0; i < maxIndex; i++) {
            if (index.contains(i)) continue;
            for (int j = i + 1; j < maxIndex; j++) {
                if (index.contains(j) || index.contains(i)) continue;
                if (nums[i] + nums[j] == k) {
                    index.add(i);
                    index.add(j);
                    operation++;
                    break;
                }
            }
        }
        return operation;
    }

    public static int maxOperations(int[] nums, int k) {
        Set<Integer> index = new HashSet<>();
        int operation = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index.contains(i)) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (index.contains(j) || index.contains(i)) continue;
                if (nums[i] + nums[j] == k) {
                    index.add(i);
                    index.add(j);
                    operation++;
                }
            }
        }
        return operation;
    }

    public static int maxOperations1(int[] nums, int k) {
        Set<Integer> index = new HashSet<>();
        Arrays.sort(nums);
        int operation = 0;
        int i = 0;
        while (i < nums.length && nums[i] <= k) {
            if (index.contains(i)) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] <= k) {
                if (index.contains(j) || index.contains(i)) {
                    j++;
                    continue;
                }
                if (nums[i] + nums[j] == k) {
                    index.add(i);
                    index.add(j);
                    operation++;
                    break;
                }
                j++;
            }
            i++;
        }
        return operation;
    }
}
