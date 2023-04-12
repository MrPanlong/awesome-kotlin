package leetcode.strs

import java.util.*

fun groupAnagrams(strs:Array<String>):List<List<String>>{
    val map = mutableMapOf<String, MutableList<String>>()
    for (str in strs) {
        val array = str.toCharArray()
        Arrays.sort(array)
        val key = String(array)
        val list = map.getOrDefault(key, mutableListOf<String>())
        list.add(str)
        map[key] = list
    }
    return map.values.toList()
}

fun main(args: Array<String>) {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    var groupAnagrams: List<List<String>> = groupAnagrams(strs)
    println(groupAnagrams)
}