package com.company.test;

import org.junit.jupiter.api.Test;

import static com.company.main.stack.NearestGreaterElementLeft.nearestGreaterElementLeft;
import static com.company.main.stack.NearestGreaterElementRight.nearestGreaterElementRight;
import static com.company.main.stack.NearestSmallerElementLeft.nearestSmallerElementLeft;
import static com.company.main.stack.NearestSmallerElementRight.nearestSmallerElementRight;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NearestElementTest {
    @Test
    void validateNearestGreaterElementLeft(){
        int[] nums = new int[]{3,4,2,5,6,1};
        int[] expected = new int[]{-1,-1,4,-1,-1,6};
        int[] res = nearestGreaterElementLeft(nums);
        assertEquals(res.length, expected.length);
        assertArrayEquals(expected, res);
    }

    @Test
    void validateNearestGreaterElementRight(){
        int[] nums = new int[]{3,4,2,5,6,1};
        int[] expected = new int[]{4,5,5,6,-1,-1};
        int[] res = nearestGreaterElementRight(nums);
        assertEquals(res.length, expected.length);
        assertArrayEquals(expected, res);
    }

    @Test
    void validateNearestSmallerElementLeft(){
        int[] nums = new int[]{3,4,2,5,6,1};
        int[] expected = new int[]{-1,3,-1,2,5,-1};
        int[] res = nearestSmallerElementLeft(nums);
        assertEquals(res.length, expected.length);
        assertArrayEquals(expected, res);
    }

    @Test
    void validateNearestSmallerElementRight(){
        int[] nums = new int[]{3,4,2,5,6,1};
        int[] expected = new int[]{2,2,1,1,1,-1};
        int[] res = nearestSmallerElementRight(nums);
        assertEquals(res.length, expected.length);
        assertArrayEquals(expected, res);
    }



}
