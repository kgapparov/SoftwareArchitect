package edu.tasks.sliding_window_maximum_239;

import edu.tasks.sliding_window_maximum_239.practice.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class SolutionTest {

    /**
     * inputs is test cases input arrays
     */
    List<int[]> inputs = List.of(
            new int[]{1,3,-1,-3,5,3,6,7},
            new int[]{1}
    );
    /**
     * size - the size of subArray for each test Cases
     */
    List<Integer> size = List.of(3, 1);


    /**
     * expected - the acutal results which expected
     */
    List<int[]> expected = List.of(
            new int[]{3,3,5,5,6,7},
            new int[] {1}
    );

    @Test
    void maxSlidingWindow() {
        for (int i = 0; i < inputs.size(); i++) {
            Assertions.assertArrayEquals(expected.get(i), Solution.maxSlidingWindow(inputs.get(i), size.get(i)));
        }
    }
}