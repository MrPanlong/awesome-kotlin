package leetcode.strs

class IsTransformable{
    fun isTransformable(s:String,t:String) :Boolean{
        val idx = Array<MutableList<Int>>(10) { mutableListOf() }
        val pos = IntArray(10)

        for ((index, value) in s.withIndex()) {
            idx[value - '0'].add(index)
        }

        for ((index, value) in t.withIndex()) {
            val d = value - '0'
            if (pos[d] >= idx[d].size) return false
            for (j in 0 until d) {
                if (pos[j] < idx[j].size && idx[j][pos[j]] < idx[d][pos[d]]) return false
            }
            pos[d] ++
        }
        return true
    }
}