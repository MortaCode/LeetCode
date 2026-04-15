package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return null;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing(e -> e[0]));

        int[] curInterval = intervals[0];
        result.add(curInterval);

        for (int[] ints : intervals){
            int curTail = curInterval[1];
            int nextHead = ints[0];
            int nextTail = ints[1];

            if (curTail > nextHead){
                curInterval[1] = Math.max(curTail, nextTail);
            } else {
                curInterval = ints;
                result.add(curInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]
                {
                        {1,3},
                        {2,6},
                        {8,10},
                        {15,18}
                };//[[1,6],[8,10],[15,18]]
        int[][] merge = merge(intervals);
        int m = merge.length, n = merge[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.println(merge[i][j]);
            }
        }
    }
}
