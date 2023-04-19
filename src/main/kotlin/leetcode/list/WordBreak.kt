package leetcode.list

class WordBreak{
    var dp = mutableMapOf<String,List<String>>()
    fun wordBreak(s:String,worDict:List<String>):List<String>{
        if (dp.containsKey(s)) return dp[s]!!
        val a = mutableListOf<String>()
        for (i in worDict.indices) {
            val temp = worDict[i]
            if (s.length >= temp.length && s.substring(0,temp.length) == temp){
                if (temp.length == s.length){
                    a.add(temp)
                }else{
                    val subR = wordBreak(s.substring(temp.length),worDict)
                    for (j in subR.indices) {
                        a.add("${temp} ${subR[j]}")
                    }
                }
            }
        }
        dp[s] = a
        return a
    }
}