package 数组;

public class Rotate {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        int n = nums.length;
        swap(nums, 0, n-1);
        swap(nums, 0, k-1);  //第k位，下标是k-1
        swap(nums, k, n);
    }

    public void swap(int[] nums, int left, int right){
        while (left < right){
            int item = nums[left];
            nums[left] = nums[right];
            nums[right] = item;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate.rotate(nums, 2);
        for (int num : nums){
            System.out.println(num);
        }
    }
}
