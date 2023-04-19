package leetcode.arrays


class SearchRange{
    fun findErrorNums(nums:IntArray):IntArray{
        var ans: IntArray = IntArray(2)
        var tmp = IntArray(nums.size + 1)
        var sum = 0
        var target = (1 + nums.size) * nums.size / 2
        for (num in nums) {
            if (tmp[num] != 0){
                ans[0] = num
            }else{
                tmp[num] = 1
            }
            sum += num
        }
        ans[1] = target - sum + ans[0]
        return ans

    }
//    fun searchRange(nums:IntArray,target:Int):IntArray{
//        var left = 0
//        var right = nums.size - 1
//        while (left <= right){
//            var mid = (left + right) / 2
//            var vmid = nums[mid]
//            if (vmid < target){
//                left = mid + 1
//            }else
//        }
//    }
}