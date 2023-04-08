package leetcode.arrays

open class AddStrings{
    fun addStrings(num1:String,num2:String):String{
        var i = num1.length - 1
        var j = num2.length - 1
        var add = 0
        val sb = StringBuilder()
        while (i >= 0 || j >= 0 || add!=0){
            val x: Int = if (i >= 0) num1[i] - '0' else 0
            val y: Int = if (j >= 0) num2[j] - '0' else 0
            val res = x + y + add
            sb.append(res%10)
            add = res/10
            i--
            j--
        }
        sb.reverse()
        return sb.toString()
    }

    fun arrayNesting(nums:IntArray):Int{
        var ans = 0
        var n = nums.size
        var vis = BooleanArray(n)
        for (i in 0 until n) {
            var cnt = 0
            while (!vis[i]){
                vis[i] = true
                var j = i
                j = nums[i]
                ++cnt
            }
            ans = Math.max(ans,cnt)
        }
        return ans
    }
}