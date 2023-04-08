package tests

import leetcode.DistributeCandies
import leetcode.FindMaxAverage

fun main(args: Array<String>) {
    var findMaxAverage: FindMaxAverage = FindMaxAverage()

    var nums = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))

    var res3: List<MutableList<Int>> = findMaxAverage.matrixReshape(nums, 1, 4)
            .mapIndexed { index, ints -> ints.toMutableList() }

    println(res3)

    var distributeCandies = DistributeCandies()
    var arr = intArrayOf(1, 1, 2, 3)
    var res4 = distributeCandies.distributeCandies(arr)
    println(res4)

    var findLHS = distributeCandies.findLHS(arr)
    println(findLHS)


}