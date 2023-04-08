package leetcode.dfs

import java.util.*
import kotlin.collections.ArrayList

fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
    if (source == target) return 0
    var n = routes.size
    var edge = Array(n) { BooleanArray(n) }
    var rec = mutableMapOf<Int, MutableList<Int>>()
    for (i in 0 until n) {
        for (site in routes[i]) {
            var list = rec.getOrDefault(site, ArrayList<Int>())
            for (j in list) {
                edge[i][j] = true
                edge[j][i] = true
            }
            list.add(i)
            rec[site] = list
        }
    }
    var dis = IntArray(n)
    Arrays.fill(dis, -1)
    var que: Queue<Int> = LinkedList<Int>()
    for (bus in rec.getOrDefault(source, ArrayList<Int>())) {
        dis[bus] = 1
        que.offer(bus)
    }
    while (!que.isEmpty()) {
        var x = que.poll()
        for (y in 0 until n) {
            if (edge[x][y] && dis[y] == -1) {
                dis[y] = dis[x] + 1
                que.offer(y)
            }
        }
    }
    var ret = Int.MAX_VALUE
    for (bus in rec.getOrDefault(target, ArrayList<Int>())) {
        if (dis[bus] != -1) {
            ret = minOf(ret, dis[bus])
        }
    }
    return if (ret == Int.MAX_VALUE) return -1 else return ret
}