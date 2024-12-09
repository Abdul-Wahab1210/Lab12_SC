package Lab12;

import java.util.ArrayList;
import java.util.List;

public class RecursiveBinarySearch {

    /**
     * Performs a recursive binary search to find the indices of the target value in the sorted array.
     *
     * @param array  The sorted array of strings.
     * @param target The value to search for.
     * @param left   The starting index of the search range.
     * @param right  The ending index of the search range.
     * @return A list of indices where the target value appears, or an empty list if not found.
     */
    public static List<Integer> binarySearchRecursive(String[] array, String target, int left, int right) {
        List<Integer> result = new ArrayList<>();

        // Base case: If the search range is invalid, the target is not in the array.
        if (left > right) {
            return result;
        }

        // Calculate the middle index.
        int mid = left + (right - left) / 2;

        // Compare middle element with target.
        int comparison = array[mid].compareTo(target);

        if (comparison == 0) {
            // If found, add the index of the middle element.
            result.add(mid);

            // Check left side for other occurrences of the target.
            // Expand left until we reach an element that's different.
            int leftIndex = mid - 1;
            while (leftIndex >= left && array[leftIndex].equals(target)) {
                result.add(leftIndex);
                leftIndex--;
            }

            // Check right side for other occurrences of the target.
            // Expand right until we reach an element that's different.
            int rightIndex = mid + 1;
            while (rightIndex <= right && array[rightIndex].equals(target)) {
                result.add(rightIndex);
                rightIndex++;
            }
        } else if (comparison < 0) {
            // Recur on the right half of the array.
            result.addAll(binarySearchRecursive(array, target, mid + 1, right));
        } else {
            // Recur on the left half of the array.
            result.addAll(binarySearchRecursive(array, target, left, mid - 1));
        }

        return result;
    }

    /**
     * Wrapper method to handle edge cases and initiate the recursive search.
     *
     * @param array  The sorted array of strings.
     * @param target The value to search for.
     * @return A list of indices where the target value appears, or an empty list if not found.
     */
    public static List<Integer> binarySearch(String[] array, String target) {
        // Error handling for null or empty arrays.
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }
}
