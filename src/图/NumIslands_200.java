package 图;

import java.util.LinkedList;
import java.util.Queue;

//岛屿数量-200
public class NumIslands_200 {

//    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//    此外，你可以假设该网格的四条边均被水包围。


    //思路：遇到陆地"1"，放入队列。队列非空，出队，上下左右入队
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int numIslands = 0;
        int rows = grid.length, cols = grid[0].length;
        //Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == '1'){
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i*cols+j);
                    grid[i][j] = '0';
                    numIslands++;
                    while (!queue.isEmpty()){
                        Integer idx = queue.poll();
                        int row = idx / cols;
                        int col = idx % cols;
                        if (row-1 >= 0 && grid[row - 1][col] == '1'){
                            queue.add((row-1)*cols + col);
                            grid[row-1][col] = '0';
                        }
                        if (row+1 < rows && grid[row + 1][col] == '1'){
                            queue.add((row+1)*cols + col);
                            grid[row+1][col] = '0';
                        }
                        if (col-1 >= 0 && grid[row][col-1] == '1'){
                            queue.add(row*cols + col - 1);
                            grid[row][col-1] = '0';
                        }
                        if (col+1 < cols && grid[row][col+1] == '1'){
                            queue.add(row*cols + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return numIslands;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','0','1','1','0'},
                {'0','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        NumIslands_200 numIslands = new NumIslands_200();
        System.out.println(numIslands.numIslands(grid));
    }
}
