package 矩阵;

import java.util.ArrayList;
import java.util.List;

//螺旋矩阵-54
public class SpiralOrder_54 {
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;
        int rows = matrix.length, cols = matrix[0].length;

        List<Integer> list = new ArrayList<>();
        boolean[][] used = new boolean[rows][cols];
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1, 0}};
        int total = rows * cols;

        int row = 0, col = 0, directionIndex = 0;
        for (int i=0; i<total; i++){
            used[row][col] = true;
            list.add(matrix[row][col]);

            int nextRow = row + direction[directionIndex][0];
            int nextCol = col + direction[directionIndex][1];
            if (nextRow<0 || nextRow>=rows || nextCol<0 || nextCol>=cols || used[nextRow][nextCol] == true){  //是小于等于rows和cols
                directionIndex = (directionIndex + 1) % direction.length;
            }

            row = row + direction[directionIndex][0];
            col = col + direction[directionIndex][1];
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> spiralOrder = spiralOrder(matrix);
        System.out.println(spiralOrder);
    }
}
