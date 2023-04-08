package leetcode

import java.util.*

class CommonChars{
    fun commonChars(words:Array<String>) :Array<String>{
        val minFreq = IntArray(26)
        Arrays.fill(minFreq, Int.MAX_VALUE)
        for (word in words) {
            val freq = IntArray(26)
            val length = word.length
            for (i in 0 until length) {
                val ch = word[i]
                ++freq[ch - 'a']
            }
            for (i in 0 until 26) {
                minFreq[i] = Math.min(minFreq[i],freq[i])
            }
        }
        val ans = arrayOf<String>()
        for (i in 0 until 26) {
            for (j in 0 until minFreq[i]) {

            }
        }
        return ans
    }
}