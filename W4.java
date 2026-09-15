import java.util.Arrays;

public class W4 {

    // Q1. Two Sum
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // Q2. Best Time to Buy and Sell Stock
    static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    // Q3. Contains Duplicate
    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // Q4. Merge Two Sorted Arrays
    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    // Q5. Rotate Array
    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       W4 - CATEGORY C PROBLEMS");
        System.out.println("========================================");

        // Q1
        System.out.println("\n===== QUESTION 1: TWO SUM =====");

        int[] nums1 = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("Target: " + target);

        int[] answer1 = twoSum(nums1, target);

        System.out.println("Indices: " + Arrays.toString(answer1));

        // Q2
        System.out.println("\n===== QUESTION 2: BEST TIME TO BUY AND SELL STOCK =====");

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Maximum Profit: " + maxProfit(prices));

        // Q3
        System.out.println("\n===== QUESTION 3: CONTAINS DUPLICATE =====");

        int[] nums3 = {1, 2, 3, 1};

        System.out.println("Array: " + Arrays.toString(nums3));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums3));

        // Q4
        System.out.println("\n===== QUESTION 4: MERGE TWO SORTED ARRAYS =====");

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        int[] merged = mergeSortedArrays(arr1, arr2);

        System.out.println("Merged Array: " + Arrays.toString(merged));

        // Q5
        System.out.println("\n===== QUESTION 5: ROTATE ARRAY =====");

        int[] nums5 = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original Array: " + Arrays.toString(nums5));
        System.out.println("Rotate By: " + k);

        int[] rotated = rotateArray(nums5, k);

        System.out.println("Rotated Array: " + Arrays.toString(rotated));

        System.out.println("\n========================================");
        System.out.println("       ALL 5 QUESTIONS COMPLETED");
        System.out.println("========================================");
    }
}