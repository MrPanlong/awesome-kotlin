@file:Suppress("UNREACHABLE_CODE")

package leetcode.arrays

import java.util.*

fun lastStoneWeight(stones:IntArray):Int{
    val pq = PriorityQueue<Int> { a, b -> b - a }
    for (stone in stones) {
        pq.offer(stone)
    }
    while (pq.size > 1){
        var a = pq.poll()
        var b = pq.poll()
        if (a > b){
            pq.offer(a - b)
        }
    }
    return if (pq.isEmpty()) 0 else pq.poll()
}