package 回溯;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

//    给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//    示例
//    输入：nums = [1,2,3]
//    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Subsets subsets = new Subsets();
        List<List<Integer>> list = subsets.subsets(nums);
        System.out.println(list);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        backTrack(nums, 0, subList, result);
        return result;
    }

    private void backTrack(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        //按层遍历
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums,i+1,list, res);//递归
            list.remove(list.size()-1);//回溯
        }
    }


//    public List<List<Integer>> subsets(int[] nums) {
//        if (nums == null || nums.length == 0){
//            return null;
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//        result.add(new ArrayList<>());
//
//        for (int num : nums){
//            int size = result.size();//确定数量
//            for (int i=0; i<size; i++){
//                List<Integer> sub = new ArrayList<>(result.get(i));
//                sub.add(num);
//                result.add(sub);
//            }
//        }
//        return result;
//    }


}
