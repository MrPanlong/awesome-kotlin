package leetcode

import java.util.*
import kotlin.collections.HashMap

/**
 * @ClassName: FindMaxAverage
 * @Date: 2023/3/14 22:47
 * @Author: panLong
 * @Description: TODO
 */
 
class FindMaxAverage{
    fun findMaxAverage(nums:IntArray,k:Int) : Int {
        var sum = 0
        for (i in 0 until k) sum += nums[i]
        var max = sum
        for (i in k until nums.size){
            sum += nums[i] - nums[i -k]
            max = Math.max(max,sum)
        }
        return max/k
    }
    fun findErrorNums(nums:IntArray):IntArray{
        var dup = 0
        var miss = 0
        var set = hashSetOf<Int>()
        for (i in nums) {
            if (set.contains(i)) dup = i
            set.add(i)
        }
        for (j in 1..nums.size) {
            if (!set.contains(j)){
                miss = j
                break
            }
        }
        return intArrayOf(dup,miss)
    }
    fun findLengthOfLCIS(nums: IntArray):Int{
        var res = 0
        var cnt = 0
        for (i in nums.indices) {
            if (i == 0 || nums[i - 1] < nums[i]){
                res = Math.max(res,++cnt)
            }else{
                cnt = 1
            }
        }
        return res
    }

    fun  search(nums: IntArray,target:Int) :Int{
        var low = 0
        var high = nums.size - 1
        while (low <= high){
            var mid = (low + high) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] < target) low = mid + 1
            else high = mid - 1
        }
        return  -1
    }

    fun findPoisonedDuration(timeSeries:IntArray,duration:Int) : Int{
        if (timeSeries.isEmpty() || duration == 0) return 0
        var result = 0
        var start = timeSeries[0]
        var end = timeSeries[0] + duration
        for (value in timeSeries) {
            if (value > end){
                result += end - start
                start = value
            }
            end = value + duration
        }
        result += end - start
        return result
    }

    fun nextGreaterElement(findNums:IntArray,nums:IntArray) :IntArray{
        var map = HashMap<Int, Int>()
        var stack = Stack<Int>()
        for (num in nums) {
            while (!stack.isEmpty() && stack.peek() < num){
                map[stack.pop()] = num
            }
            stack.push(num)
        }
        for (i in findNums.indices){
            findNums[i] = map.getOrDefault(findNums[i],-1)
        }
        return findNums
    }

    fun priorityQueueSol(score:IntArray) :Array<String>{
        val queue = PriorityQueue<Pair<Int,Int>>(score.size,Comparator<Pair<Int,Int>>{
            o1,o2 -> o2.first.compareTo(o1.first)
        })
        score.forEachIndexed{i,sc ->
            queue.add(Pair(sc,i))
        }
        //queue:[(10,0),(9,3),(8,2),(2,1),(4,4)]
        var result = Array<String>(score.size) { "" }
        var i: Int = 0
        while (!queue.isEmpty()){
            var pair: Pair<Int, Int> = queue.poll()
            result[pair.second] = when(i + 1){
                1 -> "Gold Medal"
                2 -> "Silver Megal"
                3 -> "Bronze Medal"
                else -> (i + 1).toString()
            }
            i++
        }
        return result
    }
    fun arrayPairSum(nums: IntArray):Int{
        nums.sort()
        var result: Int = 0
        for (i in nums.indices.step(2)){
            result += nums[i]
        }
        return result
    }

    fun matrixReshape(mat:Array<IntArray>,r:Int,c:Int):Array<IntArray>{
        if (r * c != mat.size * mat[0].size){
            return mat
        }
        var list = mutableListOf<Int>()
        for (i in mat) {
            for (j in i) {
                list.add(j)
            }
        }
        //list:[1,2,3,4]
        var currentIndex = 0
        var new = Array(r) { IntArray(c) }
        for (i in new.indices) {
            var row = new[i]
            for (j in row.indices) {
                new[i][j] = list[currentIndex]
                currentIndex++
            }
        }
        return new
    }
}
