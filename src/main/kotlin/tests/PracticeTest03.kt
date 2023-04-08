package tests

import leetcode.MaxCount

fun main(args: Array<String>) {

    var m = 3
    var n = 3
    var ops = arrayOf(intArrayOf(2, 2), intArrayOf(3, 3))

    var maxCount = MaxCount()

    println(maxCount.maxCount(m, n, ops))



}