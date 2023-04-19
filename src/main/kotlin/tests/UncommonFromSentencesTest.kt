package tests
import leetcode.strs.UncommonFromSentences

fun main(args: Array<String>) {

    var s1 = "this apple is sweet"
    var s2 = "this apple is sour"

    var uncommonFromSentences = UncommonFromSentences()
    var res1 = uncommonFromSentences.uncommonFromSentences(s1, s2)

    var toTypedArray = res1.toList().toTypedArray()
    println(toTypedArray)
    var toString = res1.toString()
    println(toString)
    for (s in res1) {
        println(s)
    }


    val items = listOf<Int>(9, 2, 3, 4, 5)
    for ((index,item) in items.withIndex()) {
        println("index:$index,item:$item")
    }

    val method:(String,String) -> Unit = {aStr,bStr-> print("a:$aStr,b$bStr")}
    val method02  = { println("keke")}
    val method03:(String) -> Unit={
        print("keke  hehe:$it")
    }
    val method04:(Int) -> Unit={
        when(it){
            1 -> println("你是等于1")
            in 20 .. 30 -> print("20 .. 30")
            else -> print("其他")
        }
    }
    val method05:(Int,Int) -> Unit={
        anum,bNum -> print("$anum,$bNum")
    }
    val method06:(Int,Int) -> Unit={
        aNum,_-> print("$aNum")
    }

}