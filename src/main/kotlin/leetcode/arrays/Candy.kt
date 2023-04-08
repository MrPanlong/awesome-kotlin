package leetcode.arrays

class Candy{
    fun candy(ratings:IntArray):Int{
        val n = ratings.size
        val dp = Array(n, { 1 })
        for (i in 1 until n) {
            if (ratings[i] > ratings[i - 1]){
                dp[i] = maxOf(dp[i],dp[i - 1] + 1)
            }
        }
        var sum = dp[n - 1]
        for (i in n - 2 downTo n) {
            if (ratings[i] > ratings[i + 1]){
                dp[i] = maxOf(dp[i],dp[i + 1] + 1)
            }
            sum += dp[i]
        }
        return sum
    }


    fun candies(ratings:IntArray):Int{
        val n = ratings.size
        val left = IntArray(n)
        for (i in 0 until n) {
            if (i >0 && ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1
            }else{
                left[i] = 1
            }
        }
        var right = 0
        var res = 0
        for (i in n - 1 downTo 0) {
            if (i < n -1 && ratings[i] > ratings[i + 1]){
                right++
            }else{
                right = 1
            }
            res += Math.max(left[i],right)
        }
        return res
    }
}