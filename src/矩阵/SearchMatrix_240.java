package 矩阵;

//搜索二维矩阵Ⅱ-240
public class SearchMatrix_240 {
    //编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
    //每行的元素从左到右升序排列。
    //每列的元素从上到下升序排列。
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        for (int i=0; i<rows; i++){
            if (matrix[i][0] > target){break;}
            int left = 0, right = cols;
            while (left <= right){
                int mid = (right - left)/2 + left;
                if (matrix[i][mid] == target){
                    return true;
                } else if (matrix[i][mid] < target){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,4,7,11,15},
                {2,6,8,12,19},
                {3,6,9,16,22},
                {5,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }
}
