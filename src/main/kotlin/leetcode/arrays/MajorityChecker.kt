package leetcode.arrays

import java.util.*

class MajorityChecker {
    fun countCharacters(words:Array<String>,chars:String):Int{
        var charsCnt = mutableMapOf<Char, Int>()
        var length = chars.length
        for (i in 0 until length) {
            var c = chars[i]
            charsCnt[c] = charsCnt.getOrDefault(c,0) + 1
        }
        var ans = 0
        for (word in words) {
            var wordCnt = mutableMapOf<Char, Int>()
            var wordLength = word.length
            for (i in 0 until wordLength) {
                var c = word[i]
                wordCnt.put(c,wordCnt.getOrDefault(c,0)+1)
            }
            var isAns = true
            for (i in 0 until wordLength) {
                var c = word[i]
                if (charsCnt.getOrDefault(c,0) < wordCnt.getOrDefault(c,0)){
                    isAns = false
                    break
                }
            }
            if (isAns){
                ans += word.length
            }
        }
        return ans
    }

}