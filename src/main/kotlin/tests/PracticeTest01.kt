package tests

import leetcode.arrays.FindMaxAverage

fun main(args: Array<String>) {
    var findMaxAverage: FindMaxAverage = FindMaxAverage()

    var score = intArrayOf(10, 2, 8, 9, 4)
    var res1 = findMaxAverage.priorityQueueSol(score)
    for (s in res1) {
        print(s+"\t")
    }
    print("\n")
    var res2 = findMaxAverage.arrayPairSum(score)
    println(res2)
}