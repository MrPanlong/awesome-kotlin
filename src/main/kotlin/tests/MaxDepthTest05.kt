package tests

import leetcode.MaxDepth

fun main(args: Array<String>) {
    var maxDepth = MaxDepth()
    var s = "((())"
    var res = maxDepth.maxDepth(s)
    println(res)


    var str = arrayOf<String>("d1/", "d2/", "./", "d3/", "../", "d31/")
    var minOperations = maxDepth.minOperations(str)
    print(minOperations)
}