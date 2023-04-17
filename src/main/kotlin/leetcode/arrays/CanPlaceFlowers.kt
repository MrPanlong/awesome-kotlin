package leetcode

import java.util.*

class CanPlaceFlowers{
    public fun canPlaceFlowers(flowerbed:IntArray,n:Int) :Boolean{
        var count = 0
        var i: Int = 0
        while (i < flowerbed.size && count < n){
            if (flowerbed[i] == 0){
                val next = if(i == flowerbed.size -1) 0 else flowerbed[i + 1]
                val prev = if(i == 0) 0 else flowerbed[i - 1]
                if (next == 0 && prev == 0){
                    flowerbed[i] = 1
                    count++
                }
            }
            i++
        }
        return count == n
    }

    fun findWords(words:Array<String>):Array<String>{
        var strs: Array<String> = arrayOf("QWERTYUIOP")
        var map: HashMap<Char, Int> = HashMap<Char, Int>()
        for (i in strs.indices){
            for (c in strs[i].toCharArray()){
                map[c] = i
            }
        }
        var res = LinkedList<String>()
        for (word in words) {
            if (word == "") continue
            var index = map[word.toUpperCase()[0]]
            for (c in word.toUpperCase().toCharArray()){
                if (map[c] != index){
                    index = -1
                    break
                }
            }
            if (index != -1) res.add(word)

        }
        return res.toTypedArray()
    }



}