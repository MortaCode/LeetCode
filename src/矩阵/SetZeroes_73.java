package 矩阵;

//矩阵置零-73
public class SetZeroes_73 {
    //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int row = matrix.length, col = matrix[0].length;
        boolean[] rowFlag = new boolean[row];
        boolean[] colFlag = new boolean[col];
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (matrix[i][j] == 0){
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (rowFlag[i] || colFlag[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,1},
                {1,0,1},
                {1,1,0}
        };
        setZeroes(matrix);
        int row = matrix.length, col = matrix[0].length;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
}
