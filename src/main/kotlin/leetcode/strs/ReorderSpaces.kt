package leetcode

class ReorderSpaces{
    fun reorderSpaces(text:String):String{
        val length = text.length
        val words = text.trim().split("\\s+")
        var cntSpace = length
        for (word in words) {
            cntSpace -= word.length
        }
        val sb = StringBuilder()
        if (words.size == 1){
            sb.append(words[0])
            for (i in 0 until cntSpace) {
                sb.append(' ')
            }
            return sb.toString()
        }
        val perSpace = cntSpace / (words.size - 1)
        val restSpace = cntSpace % (words.size - 1)
        for (i in 0 until words.size) {
            if (i > 0){
                for (j in 0 until perSpace) {
                    sb.append(' ')
                }
            }
            sb.append(words[i])
        }
        for (i in 0 until restSpace) {
            sb.append(' ')
        }
        return sb.toString()
    }
}