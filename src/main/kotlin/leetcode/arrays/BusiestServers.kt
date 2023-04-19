package leetcode.arrays

import java.util.*
import kotlin.collections.ArrayList

fun busiestServers(k:Int,arrival:IntArray,load:IntArray):List<Int>{
    if (arrival.size <= k) return IntRange(0,arrival.size-1).toList()
    var pq = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.first - o2.first }
    var ts = TreeSet<Int>()
    var count = IntArray(k)
    var result: MutableList<Int> = ArrayList<Int>()
    var max = Int.MIN_VALUE / 2
    IntRange(0,k-1).forEach { ts.add(it) }
    arrival.indices.forEach {
        while (!pq.isEmpty() && pq.peek().first <= arrival[it]){
            var p = pq.poll()
            ts.add(p.second)
        }
        if (ts.isEmpty()){
            return@forEach
        }
        var nextServer = ts.ceiling(it % k)
        if (nextServer == null) nextServer = ts.first()
        ts.remove(nextServer)
        pq.offer(Pair(arrival[it] + load[it],nextServer))
        count[nextServer!!]++
        if (count[nextServer] > max){
            max = count[nextServer]
            result.clear()
            result.add(nextServer)
        }else if(count[nextServer] == max){
            result.add(nextServer)
        }
    }
    return result


}