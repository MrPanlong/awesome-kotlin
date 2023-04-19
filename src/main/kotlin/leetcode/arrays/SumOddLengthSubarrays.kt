package leetcode

class SumOddLengthSubarrays{
    fun sumOddLengthSubarrays(arr:IntArray):Int{
        val n = arr.size
        val prefixSums = IntArray(n + 1)
        for (i in 0 until n) {
            prefixSums[i + 1] = prefixSums[i] + arr[i]
        }
        var sum = 0
        for (start in 0 until n) {
            var length = 1
            while (start + length <= n){
                val end = start + length - 1
                sum += prefixSums[end + 1] - prefixSums[start]
                length += 2
            }
        }
        return sum
    }
}