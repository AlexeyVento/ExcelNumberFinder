package com.example.excelnumberfinder;

import java.util.List;
import java.util.Random;

public class QuickSelect {
    private static final Random random = new Random();

    public static int findNthMin(List<Integer> nums, int n) {
        if (n < 1 || n > nums.size()) {
            throw new IllegalArgumentException("N must be between 1 and " + nums.size());
        }
        return quickSelect(nums, 0, nums.size() - 1, n - 1);
    }

    private static int quickSelect(List<Integer> nums, int left, int right, int k) {
        if (left == right) return nums.get(left);

        int pivotIndex = partition(nums, left, right, random.nextInt(right - left) + left);

        if (k == pivotIndex) return nums.get(k);
        else if (k < pivotIndex) return quickSelect(nums, left, pivotIndex - 1, k);
        else return quickSelect(nums, pivotIndex + 1, right, k);
    }

    private static int partition(List<Integer> nums, int left, int right, int pivotIndex) {
        int pivotValue = nums.get(pivotIndex);
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums.get(i) < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, right, storeIndex);
        return storeIndex;
    }

    private static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
