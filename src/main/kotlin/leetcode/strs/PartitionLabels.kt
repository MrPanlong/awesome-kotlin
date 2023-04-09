package leetcode.strs

fun partitionLabels(s:String):List<Int>{
    var last = IntArray(26)
    var length = s.length
    for (i in 0..length) {
        last[s[i] - 'a'] = i
    }
    var partition = mutableListOf<Int>()
    var start = 0;var end = 0
    for (i in 0 until length) {
        end = maxOf(end,last[s[i] - 'a'])
        if (i == end){
            partition.add(end - start + 1)
            start = end + 1
        }
    }
    return partition
}