package leetcode
class PivotIndex{
    public fun pivotIndex(nums:IntArray):Int{
        var leftSum = 0
        var rightSum = 0
        for (num in nums) {
            rightSum += num
        }
        for (i in nums.indices) {
            if (leftSum == rightSum - nums[i]){
                return i
            }
            leftSum += nums[i]
            rightSum -= nums[i]

        }
        return -1
    }

    fun shipWithinDays(ws:IntArray,d:Int):Int{
        var max = 0
        var sum = 0
        for (w in ws) {
            max = Math.max(max,w)
            sum += w
        }
        var l = max
        var r = sum
        while (l < r){
            var mid = l + r / 2
            if (check(ws,mid,d)){
                r = mid
            }else{
                l = mid + 1
            }
        }
        return r
    }

    private fun check(ws: IntArray, t: Int, d: Int): Boolean {
        var n = ws.size
        var i = 1
        var cnt = 1
        var total = ws[0]
        while (i < n){
            while (i < n && total + ws[i] <= t){
                total += ws[i]
                i += 1
            }
            total = 0
            cnt += 1
        }
        return cnt - 1 <= d
    }
}