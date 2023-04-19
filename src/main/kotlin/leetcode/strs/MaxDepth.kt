package leetcode

class MaxDepth{
    fun maxDepth(s:String):Int{
        var max = 0
        var current = 0
        s.forEach {
            when(it){
                '(' -> current++
                ')' -> current--
            }
            max = Math.max(current,max)
        }
        return max
    }


    fun minOperations(logs:Array<String>) : Int{
        var res = 0
        logs.forEach {
            when(it){
                "../" -> if (res != 0) res--
                "./" -> {}
                else -> res++
            }
        }
        return res
    }
}
