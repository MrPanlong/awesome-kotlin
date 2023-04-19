package leetcode.arrays

import java.util.*

class MostBooked{
    fun mostBooked(n:Int,meetings:Array<IntArray>):Int{
        var cnt = IntArray(n)
        var idle = PriorityQueue<Int>()
        for (i in 0 until n) {
            idle.offer(i)
        }
        var pq = PriorityQueue<Pair<Int, Int>> {
            o1, o2 -> o1.first - o2.first
        }
        return 0
    }
}

fun main(args: Array<String>) {
}