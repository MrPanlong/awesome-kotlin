package leetcode

import java.util.*

class MaximalRectangle{
    fun maxRectangle(matrix:Array<CharArray>):Int{
        val m = matrix.size
        if (m == 0) return 0
        val n = matrix[0].size
        val left = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == '1'){
                    left[i][j] = if (j == 0) return 0 else left[i][j-1] + 1;
                }
            }
        }
        var res = 0
        for (j in 0 until n) {
            val up = IntArray(m)
            val down = IntArray(m)
            val stack = LinkedList<Int>()
            for (i in 0 until m) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.poll()
                }
                up[i] = if (stack.isEmpty()) -1 else stack.peek()
                stack.push(i)
            }
            stack.clear()
            for (i in m - 1 downTo 0) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.poll()
                }
                down[i] = if (stack.isEmpty()) return m else return stack.peek()
                stack.push(i)
            }
            for (i in 0 until m) {
                var height = down[i] - up[i] - 1
                var area = height * left[i][j]
                res = Math.max(res,area)
            }
        }
        return res
    }
}