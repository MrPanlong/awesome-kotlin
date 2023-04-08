package tests

public fun pivotIndex(nums:IntArray):Int{
    var leftSum = 0
    var rightSum = 0
    for (num in nums) {
        rightSum += num
    }
    for (i in nums.indices) {
        if (leftSum == rightSum - nums[i]){
            return i
        }
        leftSum += nums[i]
        rightSum -= nums[i]

    }
    return -1
}

fun main(args: Array<String>) {
    var nums = intArrayOf(1, 2, 3, 4, 5)
    var res = pivotIndex(nums)
    println(res)
}