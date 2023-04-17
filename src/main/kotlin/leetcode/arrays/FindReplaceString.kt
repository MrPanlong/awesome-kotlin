package leetcode

import java.util.*

class FindReplaceString{
    fun findReplaceString(s:String,indexes:IntArray,sources:Array<String>,target:Array<String>):String{
        val N = s.length
        val match = IntArray(N)
        Arrays.fill(match,-1)
        for (i in indexes.indices) {
            val ix = indexes[i]
            if (s.substring(ix,ix + sources[i].length) == sources[i]){
                match[ix] = i
            }
        }
        val ans = StringBuilder()
        var ix = 0
        while (ix < N){
            if (match[ix] >= 0){
                ans.append(target[match[ix]])
                ix += sources[match[ix]].length
            }else{
                ans.append(s[ix++])
            }
        }
        return ans.toString()
    }
}