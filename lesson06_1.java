import java.util.Arrays;

import org.w3c.dom.ranges.Range;

public class lesson06_1 {
    public static void main(String[] args) {
        int[] sort = {5,9,3,6,4,7,1,3,7,5};

        int[] mergeResult = mergeSort(sort);

        
        for (int item : mergeResult) {
            System.out.print(item + ",");
        }
    }

    public static int[] mergeSort(int[] sort) {
        if (sort == null) {
            return new int[0];
        }
        if (sort.length == 1) {
            return sort;
        }

        int midIndex = sort.length / 2;
        int left[] = mergeSort(Arrays.copyOfRange(sort, 0, midIndex)); 
        int right[] = mergeSort(Arrays.copyOfRange(sort, midIndex, sort.length));

        return merge(left, right);
    }

    public static int[] merge(int[] leftList, int[] rightList) {
        int currentIndexLeft = 0;
        int currentIndexRight = 0;
        int mergeResultIndex = 0;

        int[] mergeResult = new int[leftList.length + rightList.length];
        
        for (int i = 0; i < mergeResult.length; i++) {
            if (currentIndexLeft > leftList.length -1 || currentIndexRight > rightList.length -1) {
                break;
            }
            if (leftList[currentIndexLeft] <= rightList[currentIndexRight]) {
                mergeResult[mergeResultIndex] = leftList[currentIndexLeft];
                currentIndexLeft++;
            } else {
                mergeResult[mergeResultIndex] = rightList[currentIndexRight];
                currentIndexRight++;
            }
            mergeResultIndex++;
        }

        if (currentIndexLeft < leftList.length ) {
            for (int i = currentIndexLeft; i< leftList.length; i++ ) {
                mergeResult[mergeResultIndex] = leftList[i];
                mergeResultIndex++;
            }
        } else {
            for (int i = currentIndexRight; i< rightList.length; i++ ) {
                mergeResult[mergeResultIndex] = rightList[i];
                mergeResultIndex++;
            }
        }

        return mergeResult;
    }
}
