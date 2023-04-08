package leetcode

import java.util.stream.Collectors

class DistributeCandies{
    fun distributeCandies(candies:IntArray):Int{
        var kinds = HashSet<Int>()
        for (candy in candies) {
            kinds.add(candy)
        }
        var res = if (kinds.size >= candies.size / 2) {
            candies.size / 2
        } else {
            kinds.size
        }
        return res
    }

    fun findLHS(nums:IntArray):Int{
        var map = HashMap<Int, Int>()
        for (num in nums) {
            map.put(num,map.getOrDefault(num,0) + 1)
        }
        var list: MutableList<Int> = map.values.stream().collect(Collectors.toList())

        var max = 0
        for (i in map.keys) {
            if (map.containsKey(i + 1)){
                max = Math.max(max,map.get(i) !! + map.get(i + 1)!!)
            }
        }
        return max
    }
}