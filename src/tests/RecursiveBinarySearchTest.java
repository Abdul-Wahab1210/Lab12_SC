package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Lab12.RecursiveBinarySearch;
import java.util.List;

public class RecursiveBinarySearchTest {

    @Test
    public void testTargetExistsInMiddle() {
        String[] testArray = {"apple", "banana", "cherry", "date", "elderberry", "fig"};
        List<Integer> expected = List.of(2);
        assertEquals(expected, RecursiveBinarySearch.binarySearch(testArray, "cherry"));
    }

    @Test
    public void testTargetExistsAtBeginning() {
        String[] testArray = {"apple", "banana", "cherry", "date", "elderberry", "fig"};
        List<Integer> expected = List.of(0);
        assertEquals(expected, RecursiveBinarySearch.binarySearch(testArray, "apple"));
    }

    @Test
    public void testTargetExistsAtEnd() {
        String[] testArray = {"apple", "banana", "cherry", "date", "elderberry", "fig"};
        List<Integer> expected = List.of(5);
        assertEquals(expected, RecursiveBinarySearch.binarySearch(testArray, "fig"));
    }

    @Test
    public void testTargetDoesNotExist() {
        String[] testArray = {"apple", "banana", "cherry", "date", "elderberry", "fig"};
        List<Integer> expected = List.of();
        assertEquals(expected, RecursiveBinarySearch.binarySearch(testArray, "grape"));
    }

    @Test
    public void testEmptyArray() {
        String[] testArray = {};
        List<Integer> expected = List.of();
        assertEquals(expected, RecursiveBinarySearch.binarySearch(testArray, "apple"));
    }

    @Test
    public void testNullArray() {
        List<Integer> expected = List.of();
        assertEquals(expected, RecursiveBinarySearch.binarySearch(null, "apple"));
    }

    @Test
    public void testSingleElementTargetFound() {
        String[] testArray = {"apple"};
        List<Integer> expected = List.of(0);
        assertEquals(expected, RecursiveBinarySearch.binarySearch(testArray, "apple"));
    }

    @Test
    public void testSingleElementTargetNotFound() {
        String[] testArray = {"apple"};
        List<Integer> expected = List.of();
        assertEquals(expected, RecursiveBinarySearch.binarySearch(testArray, "banana"));
    }
}
