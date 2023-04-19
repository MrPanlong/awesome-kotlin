package leetcode.arrays
/**
 *
 *@author panlong
 *@date 2023/4/17
 */
class LongestIncreasingPath{
    private val dp = Array(1005){IntArray(1005)}
    private var dir = arrayOf(intArrayOf(0,-1), intArrayOf(0,1),
            intArrayOf(-1,0), intArrayOf(1,0))

    fun longestIncreasingPath(matrix:Array<IntArray>) :Int{
        if (matrix.size == 0) return 0
        var ans = 0
        var n = matrix.size
        var m = matrix[0].size
        for (i in 0 until n) {
            for (j in 0 until m) {
                ans = Math.max(ans,dfs(matrix,i,j))
            }
        }
        return ans
    }

    private fun dfs(matrix: Array<IntArray>, x: Int, y: Int): Int {
        if (dp[x][y] > 0) return dp[x][y]
        dp[x][y] = 1
        for (i in 0..3) {
            var nx = x + dir[i][0]
            var ny = y + dir[i][1]
            if (nx >= matrix.size || nx < 0 || ny >= matrix[0].size  || ny <0){
                continue
            }
            if (matrix[nx][ny] > matrix[x][y]){
                dp[x][y] = Math.max(dp[x][y],1 + dfs(matrix,nx,ny))
            }
        }
        return dp[x][y]
    }
}