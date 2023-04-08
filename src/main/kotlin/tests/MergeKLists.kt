package tests

class MergeKLists{
    public fun find(A:IntArray,B:IntArray):Int{
        var lenA = A.size
        var lenB = B.size

        val dp = mutableListOf<IntArray>()
        (0 until lenA + 1).forEach{
            dp.add(it, IntArray(lenB + 1))
        }
        var result = 0
        for (i in 1..lenA) {
            for (j in 1..lenB) {
                if (A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1
                    result = Math.max(result,dp[i][j])
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    var num1 = intArrayOf(1, 2, 3, 2, 1)
    var num2 = intArrayOf(3, 2, 1, 4, 7)
    var mergeKLists = MergeKLists()
    var find = mergeKLists.find(num1, num2)
    println(find)

}