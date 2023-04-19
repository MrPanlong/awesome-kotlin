package leetcode.strs

fun maxRepOpt1(text:String):Int{
    var chars = text.toCharArray()
    var counts = IntArray(26)
    var n = chars.size
    var cnt = 1
    var ans = 1
    //记录每个字符出现的次数
    for (c in chars) {
        counts[c - 'a']++
    }
    //选定字符开始对比
    var last = chars[0]
    //从第二个开始匹配
    for (i in 1 until n) {
        //匹配成功，当前最长
        if (chars[i] == last){
            cnt++
        }else{
            //从i + 1往后找
            var index = i + 1
            while (index < n && chars[index] == last){
                ++cnt
                ++ index
            }
            if (counts[last - 'a'] > cnt){
                ++cnt
            }
            ans = Math.max(ans,cnt)
            cnt = 1
            last = chars[i]
        }
    }
    if (counts[last - 'a'] > cnt){
        ++cnt
    }
    ans = Math.max(ans,cnt)
    return ans
}