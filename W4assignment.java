import java.util.*;

public class W4assignment {

    // Q1. Product of Array Except Self
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: product of elements to the left
        int leftProduct = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Backward pass: product of elements to the right
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    // Q2. Maximum Subarray
    static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (currentSum + nums[i] > nums[i]) {
                currentSum = currentSum + nums[i];
            } else {
                currentSum = nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    // Q3. 3Sum
    static int[][] threeSum(int[] nums) {

        Arrays.sort(nums);

        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(new int[]{
                        nums[i],
                        nums[left],
                        nums[right]
                    });

                    // Skip duplicate left values
                    while (left < right &&
                           nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right &&
                           nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int[][] answer = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    // Q4. Subarray Sum Equals K
    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        // Empty prefix
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            int requiredSum = currentSum - k;

            if (prefixSumCount.containsKey(requiredSum)) {
                count += prefixSumCount.get(requiredSum);
            }

            prefixSumCount.put(
                currentSum,
                prefixSumCount.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    // Q5. Find Minimum in Rotated Sorted Array
    static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("      W4 ASSIGNMENT - CATEGORY C");
        System.out.println("========================================");

        // Q1
        System.out.println("\n===== QUESTION 1 =====");

        int[] nums1 = {1, 2, 3, 4};

        System.out.println("Input: " + Arrays.toString(nums1));

        int[] result1 = productExceptSelf(nums1);

        System.out.println("Output: " + Arrays.toString(result1));

        // Q2
        System.out.println("\n===== QUESTION 2 =====");

        int[] nums2 = {
            -2, 1, -3, 4, -1, 2, 1, -5, 4
        };

        System.out.println("Input: " + Arrays.toString(nums2));

        int result2 = maxSubArray(nums2);

        System.out.println("Maximum Subarray Sum: " + result2);

        // Q3
        System.out.println("\n===== QUESTION 3 =====");

        int[] nums3 = {
            -1, 0, 1, 2, -1, -4
        };

        System.out.println("Input: " + Arrays.toString(nums3));

        int[][] result3 = threeSum(nums3);

        System.out.println("Triplets:");

        for (int[] triplet : result3) {
            System.out.println(Arrays.toString(triplet));
        }

        // Q4
        System.out.println("\n===== QUESTION 4 =====");

        int[] nums4 = {1, 1, 1};
        int k = 2;

        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("K: " + k);

        int result4 = subarraySum(nums4, k);

        System.out.println("Number of Subarrays: " + result4);

        // Q5
        System.out.println("\n===== QUESTION 5 =====");

        int[] nums5 = {3, 4, 5, 1, 2};

        System.out.println("Input: " + Arrays.toString(nums5));

        int result5 = findMin(nums5);

        System.out.println("Minimum Element: " + result5);

        System.out.println("\n========================================");
        System.out.println("       ALL QUESTIONS COMPLETED");
        System.out.println("========================================");
    }
}