package leetcode.strs

import java.util.*

fun mostCommonWord(paragraph:String,banned:Array<String>):String{
    var bannedSet = mutableSetOf<String>()
    for (s in banned) {
        bannedSet.add(s)
    }

}