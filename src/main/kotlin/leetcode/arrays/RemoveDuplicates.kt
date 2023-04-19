package leetcode.arrays

fun removeDuplicates(s:String):String{
    var stack = StringBuilder()
    var top = -1
    for (i in 0 until s.length) {
        var ch = s[i]
        if (top >= 0 && stack[top] == ch){
            stack.deleteCharAt(top)
            --top
        }else{
            stack.append(ch)
            ++top
        }
    }
    return stack.toString()
}