package leetcode
/**
 *
 *@author panlong
 *@date 2023/4/3
 */
class PrevPermOpt1{
    fun prevPermOpt1(arr:IntArray):IntArray{
        val n = arr.size
        for (i in n - 2 downTo 0) {
            if (arr[i] > arr[i + 1]){
                var j = n - 1
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]){
                    j--
                }
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
                break
            }
        }
        return arr
    }
}

