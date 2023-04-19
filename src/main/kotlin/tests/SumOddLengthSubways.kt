package tests

import leetcode.arrays.SumOddLengthSubarrays

fun main(args: Array<String>) {
    var sumOddLengthSubarrays = SumOddLengthSubarrays()
    var arr = arrayOf<Int>(1, 4, 2, 5, 3)
    var res = sumOddLengthSubarrays.sumOddLengthSubarrays(arr.toIntArray())
    print(res)
}