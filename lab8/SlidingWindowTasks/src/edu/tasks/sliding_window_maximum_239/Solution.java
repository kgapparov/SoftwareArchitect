package edu.tasks.sliding_window_maximum_239;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return null;
        if (nums.length < k) {
            k = nums.length;
        }

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!window.isEmpty()&& nums[window.peekLast()] < nums[i]) {
                window.removeLast();
            }
            window.addLast(i);
        }

        result[resultIndex++] = nums[window.peek()];

        for (int end = k; end < nums.length; end++) {
            //clean window
            while (!window.isEmpty()&& nums[window.peekLast()] < nums[end]) {
                window.removeLast();
            }

            //controll window size
            if (!window.isEmpty() && window.peek() <= end - k) {
                window.removeFirst();
            }

            window.addLast(end);

            result[resultIndex++] = nums[window.peek()];
        }
        return result;
    }
}
