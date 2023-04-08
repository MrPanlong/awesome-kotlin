package leetcode.arrays
/**
 *
 *@author panlong
 *@date 2023/4/8
 */
fun maximumDifference(nums: IntArray): Int {
    val n = nums.size
    var ans = -1;
    var preMin = nums[0]
    for (i in 1 until n) {
        if (nums[i] > preMin) {
            ans = maxOf(ans, nums[i] - preMin)
        } else {
            preMin = nums[i]
        }
    }
    return ans
}

fun main(args: Array<String>) {
    var arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8).toIntArray()
    var res = maximumDifference(arr)
    print("res is $res")
}