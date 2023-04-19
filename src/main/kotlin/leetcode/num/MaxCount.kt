package leetcode.num


class MaxCount{
    fun maxCount(m:Int,n:Int,ops:Array<IntArray>):Int{
        if (ops.isEmpty()) return m * n
        var row = Int.MAX_VALUE
        var col = Int.MIN_VALUE
        for (item in ops) {
            row = Math.min(row,item[0])
            col = Math.max(col, item[1])
        }
        return row * col
    }
}