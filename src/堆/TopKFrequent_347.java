package 堆;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//前K个高频元素-347
public class TopKFrequent_347 {
    //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        TopKFrequent_347 topKFrequent347 = new TopKFrequent_347();
        int[] result = topKFrequent347.topKFrequent(nums, k);
        for (int i=0; i<k; i++){
            System.out.println(result[i]);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k)
            return null;
//        Map<Integer, Long> map = Arrays.stream(nums)
//                .boxed()  // IntStream -> Stream<Integer>
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Integer> map = Arrays.stream(nums).boxed().collect(Collectors.toMap(Function.identity(), a->1, Integer::sum));
        List<int[]> list = new ArrayList<>();
        map.forEach((key, value) ->{list.add(new int[]{key, value});});
        quickSort(list, 0, list.size()-1);
        int[] result = new int[k];
        for (int i=0; i<k; i++){result[i] = list.get(i)[0];}
        return result;
    }

    public void quickSort(List<int[]> list, int left, int right){
        if (left < right){
            int partion = partion(list, left, right);
            quickSort(list, left, partion-1);
            quickSort(list, partion+1, right);
        }
    }

    public int partion(List<int[]> list, int left, int right){
        int randomIndex = (int)Math.random()*(right-left+1) + left;
        Collections.swap(list, randomIndex, left);

        int target = list.get(left)[1];
        int slow = left;
        for (int fast = left+1; fast<=right; fast++){
            if (list.get(fast)[1] > target){
                slow++;
                Collections.swap(list, fast, slow);

                //Collections.swap(list, fast, slow++);
                //slow++;
            }
        }
        Collections.swap(list, left, slow);
        return slow;
    }
}
