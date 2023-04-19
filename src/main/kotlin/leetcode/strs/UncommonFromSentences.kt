package leetcode.strs

class UncommonFromSentences {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val freq = HashMap<String, Int>()
        insert(s1, freq)
        insert(s2, freq)
        val ans = ArrayList<String>()
        for (mutableEntry in freq) {
            if (mutableEntry.value == 1) {
                ans.add(mutableEntry.key)
            }
        }
        return ans.toTypedArray()
    }

    private fun insert(s: String, freq: HashMap<String, Int>) {
        val arr = s.split(" ")
        for (word in arr) {
            freq[word] = freq.getOrDefault(word,0) + 1
        }
    }
}