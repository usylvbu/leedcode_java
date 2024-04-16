package topic;
/*35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法。
示例 1:
输入: nums = [1,3,5,6], target = 5
输出: 2
示例 2:
输入: nums = [1,3,5,6], target = 2
输出: 1
示例 3:
输入: nums = [1,3,5,6], target = 7
输出: 4
提示:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 为 无重复元素 的 升序 排列数组
-104 <= target <= 104
 */
public class 搜索插入位置 {
    /**
     * 在给定的有序整数数组中查找目标值，如果找到则返回其索引，如果未找到则返回插入位置的索引。
     *
     * @param nums 有序整数数组，其中的元素升序排列。
     * @param target 要在数组中查找的目标值。
     * @return 如果目标值存在于数组中，则返回其索引；如果目标值不存在，则返回它应该被插入的位置的索引。
     */
    public int searchInsert(int[] nums, int target) {
        int temp = 0; // 用于存储遍历过程中合适插入位置的索引

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                // 如果找到目标值，则直接返回其索引
                return i;
            }
            else if(nums[i] > target){
                // 如果当前元素大于目标值，说明目标值应该插入到当前位置的前面，直接返回当前位置的索引
                return i;
            }
            else if(nums[i] < target){
                // 如果当前元素小于目标值，更新合适插入位置的索引
                temp = i;
            }
        }
        // 遍历完整个数组后仍未找到目标值，返回更新后的合适插入位置的索引（加1是因为temp是插入位置的前一个索引）
        return temp+1;
    }
}
