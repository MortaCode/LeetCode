package 图;

import java.util.LinkedList;
import java.util.Queue;

//腐烂的橘子-994
public class OrangesRotting_994 {

//    在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
//
//    值 0 代表空单元格；
//    值 1 代表新鲜橘子；
//    值 2 代表腐烂的橘子。
//    每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
//
//    返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。


    //新鲜橘子数量、腐烂橘子队列
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
        int freshOrange = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == 1){
                    freshOrange++;
                }
                if (grid[i][j] == 2){
                    queue.add(i * cols + j);
                }
            }
        }

        int times = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            //一轮结束
            while (size > 0){
                Integer location = queue.poll();
                for (int i=0; i<4; i++){
                    int row = location / cols;
                    int col = location % cols;
                    int x = row + directions[i][0];
                    int y = col + directions[i][1];
                    if (x >= 0 && x < rows && y >= 0 && y<cols && grid[x][y] == 1){
                        grid[x][y] = 2;
                        freshOrange--;
                        queue.add(x * cols + y);
                    }
                }
                size--;
            }
            times++;
            if (freshOrange == 0){return times;}
        }
        return -1;
    }

    public static void main(String[] args) {
        OrangesRotting_994 orangesRotting = new OrangesRotting_994();
        int[][] grid = new int[][]{
                {1,0,0},
                {2,1,0},
                {1,1,0}

        };
        System.out.println(orangesRotting.orangesRotting(grid));
    }
}
