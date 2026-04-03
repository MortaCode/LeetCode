package 堆;


//数组中的第K个最大元素-215
public class FindKthLargest_215 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;   //5
        FindKthLargest_215 findKthLargest215 = new FindKthLargest_215();
        System.out.println(findKthLargest215.findKthLargest(nums, k));
    }
    //构建大根堆
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k)
            return 0;
        int size = nums.length;
        buildMaxHeap(nums, size);
        for (int i = nums.length-1; i>=nums.length-k+1; i--){ //大于等于
            swap(nums, i, 0);
            size--;
            modifyMaxHeap(nums,0, size);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int size){
        for (int i=size/2-1; i>=0; i--){
            modifyMaxHeap(nums, i, size);
        }
    }

    public void modifyMaxHeap(int[] nums, int i, int size){
        int left = i*2+1, right = i*2+2, target = i;
        if (left < size && nums[left] > nums[target]){
            target = left;
        }
        if (right < size && nums[right] > nums[target]){
            target = right;
        }
        if (target != i){
            swap(nums, i, target);
            modifyMaxHeap(nums, target, size);
        }
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
