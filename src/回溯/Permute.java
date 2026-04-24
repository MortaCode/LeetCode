package 回溯;

import java.util.ArrayList;
import java.util.List;

//全排列
public class Permute {

//    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//    示例
//    输入：nums = [1,2,3]
//    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    public static void main(String[] args) {
        //画结构图
        Permute solution = new Permute();
        int[] nums = new int[]{1,2,3};
        System.out.println(solution.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0){return null;}
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        backTrack(nums, used, level, list);
        return list;
    }

    private void backTrack(int[] nums, boolean[] used, List<Integer> level, List<List<Integer>> list) {
        int n = nums.length;
        if (level.size() == n){
            list.add(new ArrayList<>(level));
        }

        for (int i=0; i<n; i++){
            if (!used[i]){
                //当前轮
                used[i] = true;
                level.add(nums[i]);
                //下一轮
                backTrack(nums, used, level, list);
                //
                used[i] = false;
                level.remove(level.size()-1);
            }
        }
    }
}
