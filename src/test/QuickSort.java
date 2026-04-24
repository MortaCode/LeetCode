package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,3,3,3};
        QuickSort quickSort = new QuickSort();
        int[] result = quickSort.topK(nums, 2);
        for (int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
    public int[] topK(int[] nums, int k){
        if (nums == null || nums.length == 0){return null;}
        //Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Integer> map = Arrays.stream(nums).boxed().collect(Collectors.toMap(Function.identity(), c -> 1, Integer::sum));
        List<int[]> list = new ArrayList<>();
        map.forEach((key,value) -> list.add(new int[]{key,value}));
        quickSort(list, 0, list.size()-1);
        int[] result = new int[k];
        for (int i=0; i<k; i++){
            result[i] = list.get(i)[0];
        }
        return result;
    }

    private void quickSort(List<int[]> list, int left, int right) {
        if (left <= right){
            int partation = partion(list, left, right);
            quickSort(list, left, partation-1);
            quickSort(list, partation+1, right);
        }
    }

    private int partion(List<int[]> list, int left, int right) {
        int randomIndex = (int)Math.random()*(right-left+1)+left;
        Collections.swap(list, left, randomIndex);

        int targrt = list.get(randomIndex)[1];
        int slow = left;
        for (int fast = left+1; fast<= right; fast++){
            if (list.get(fast)[1] > targrt){
                slow++;
                Collections.swap(list, slow, fast);
            }
        }
        Collections.swap(list, slow, left);
        return slow;
    }


}
