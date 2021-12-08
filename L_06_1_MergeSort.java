import java.util.Arrays;

public class L_06_1_MergeSort {
    public static void main(String[] args) {
        int[] sort = {5,9,3,6,4,7,1,3,7,5};

        int[] mergeResult = mergeSort(sort);

        
        for (int item : mergeResult) {
            System.out.print(item + ",");
        }
    }

    /** 
     * 使用函数的递归（嵌套）调用，实现归并排序（从小到大）
     * 
     * @param to_sort-等待排序的数组 
     * @return int[]-排序后的数组 
     */
    public static int[] mergeSort(int[] sort) {
        // 如果不能在分解，补全
        if (sort == null) {
            return new int[0];
        }

        // 如果分解到只剩下一个数，将该数返回
        if (sort.length == 1) {
            return sort;
        }

        // 二分分解
        int midIndex = sort.length / 2;
        int left[] = mergeSort(Arrays.copyOfRange(sort, 0, midIndex)); 
        int right[] = mergeSort(Arrays.copyOfRange(sort, midIndex, sort.length));

        // 合并排序后的两半
        return merge(left, right);
    }

    /**
     * 合并两个已经排序完毕的数组（从小到大）
     * @param leftList 左边的数组
     * @param rightList 右边的数组
     * @return int[]-合并后的数组
     */
    public static int[] merge(int[] leftList, int[] rightList) {
        int currentIndexLeft = 0;
        int currentIndexRight = 0;
        int mergeResultIndex = 0;

        int[] mergeResult = new int[leftList.length + rightList.length];
        
        // 轮流从两个数组中取出较小的值，放入合并后的数组中
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

        // 将某个数组内剩余的数字放入合并后的数组中
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
