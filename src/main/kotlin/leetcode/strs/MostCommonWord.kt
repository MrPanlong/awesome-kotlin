package leetcode.strs

import java.util.*

fun mostCommonWord(paragraph:String,banned:Array<String>):String{
    var bannedSet = mutableSetOf<String>()
    for (s in banned) {
        bannedSet.add(s)
    }
    var maxFrequency = 0
    var frequencies = mutableMapOf<String, Int>()
    var sb = StringBuilder()
    var length = paragraph.length
    for (i in 0..length) {
        if (i < length && (paragraph[i] in 'a'..'z')){
            sb.append(paragraph[i].toLowerCase())
        }else if(sb.length > 0){
            var word = sb.toString()
            if (!bannedSet.contains(word)){
                var frequency = frequencies.getOrDefault(word, 0) + 1
                frequencies[word] = frequency
                maxFrequency = maxOf(maxFrequency,frequency)
            }
            sb.setLength(0)
        }
    }
    var mostCommon = ""
    for (entry in frequencies) {
        var word = entry.key
        var frequency = entry.value
        if (frequency == maxFrequency){
            mostCommon = word
            break
        }
    }
    return mostCommon
}


fun mostCommonWords(s: String, ar: Array<String>) = mutableMapOf<String, Int>().apply {
    s.toLowerCase().replace(Regex("[^a-z ]"), " ").split(" ")
            .filter { !ar.contains(it) && it.isNotBlank() }
            .forEach { this[it] = getOrDefault(it, 0) + 1 }
}.maxBy { it.value }?.key!!