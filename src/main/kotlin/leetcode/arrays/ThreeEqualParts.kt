package leetcode.arrays

import java.util.*

class ThreeEqualParts{
    fun threeEqualParts(arr:IntArray):IntArray{
        var sum = Arrays.stream(arr).sum()
        if (sum % 3 != 0){
            return arrayOf(-1,1).toIntArray()
        }
        if (sum == 0){
            return arrayOf(0,2).toIntArray()
        }
        //find index of starting 1 of third string
        var idxThird = 0
        var temp = 0
        for (i in arr.size - 1 downTo 0) {
            if (arr[i] == 1){
                temp++
                if (temp == sum / 3){
                    idxThird = i
                    break
                }
            }
        }
        var res1 = findEndIdx(arr, 0, idxThird)
        if (res1 <0) return arrayOf(-1,1).toIntArray()
        var res2 = findEndIdx(arr, res1 + 1, idxThird)
        if (res2 <0) return arrayOf(-1,1).toIntArray()
        return arrayOf(res1,res2).toIntArray()
    }

    private fun findEndIdx(arr: IntArray, i: Int, j: Int): Int {
        var left = i; var right = j
        while (arr[left] == 0) left++
        while (right < arr.size){
            if (arr[left] != arr[right]) return -1
            left++
            right++
        }
        return left - 1
    }
}