package leetcode.dp


class MinCost{
    fun minCost(houses:IntArray,cost:Array<IntArray>,m:Int,n:Int,target:Int):Int{
        var dp = Array(m) { Array(n + 1) { Array<Int>(target + 1){ Int.MAX_VALUE} } }
        if (houses[0] == 0){
            for (i in 1..n) {
                dp[0][i][0] = cost[0][i-1]
            }
        }
        for (i in 1 until m) {
            for (j in 1..n) {
                for (k in 0 until target) {
                    if (houses[i] == 0){
                        for (j_old in 1..n) {
                            if (dp[i - 1][j_old][k] == Int.MAX_VALUE) continue

                            if (j_old == j){
                                dp[i][j][k] = Math.min(dp[i - 1][j_old][k] + cost[i][j - 1],dp[i][j][k])
                            }else{
                                dp[i][j][k+1] = Math.min(dp[i - 1][j_old][k] + cost[i][j - 1],dp[i][j][k+1])
                            }
                        }
                    }else{
                        if (dp[i - 1][j][k] == Int.MAX_VALUE) continue

                        if (houses[i] == j){
                            dp[i][j][k] = Math.min(dp[i - 1][j][k],dp[i][houses[i]][k + 1])
                        }
                    }
                }
            }
        }
        var ans = Int.MAX_VALUE
        for (j in 1..n) {
            ans = Math.min(ans,dp[m - 1][j][target - 1])
        }
        return if (ans == Int.MAX_VALUE) -1 else ans
    }


    /**
     * standard solution
     */
    data class Key(val k1:Int,val k2:Int,val k3:Int)
    fun minCosts(houses: IntArray, cost: Array<IntArray>, m:Int, n:Int, target: Int):Int{
        val memo = mutableMapOf<Key, Int>()
        fun dfs(pos:Int,neib:Int,currColor:Int):Int{
            if (neib > target) return -1
            if (pos == houses.size) return if (neib == target) 0 else -1
            val key = Key(pos,neib,currColor)
            if (memo[key] != null) return memo[key]!!
            if (houses[pos] !=0){
                memo[key] = dfs(pos + 1,if(houses[pos] == currColor) neib else neib + 1,houses[pos])
                return memo[key]!!
            }
            var min = Int.MAX_VALUE
            for (color in 1..n) {
                var takeColor = dfs(pos + 1, if (color == currColor) neib else neib + 1, color)
                if (takeColor != -1) min = minOf(min,cost[pos][color - 1] + takeColor)
            }
            memo[key] = if (min == Int.MAX_VALUE) -1 else min
            return memo[key] !!
        }
        return dfs(0,0,-1)
    }
}

fun main(args: Array<String>) {

}