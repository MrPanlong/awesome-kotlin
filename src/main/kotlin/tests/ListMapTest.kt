package tests

fun main(args: Array<String>) {

    var map: MutableMap<Int, MutableList<String>> = mutableMapOf()

    var list1 = mutableListOf<String>().apply {
        add("keke")
        add("java")
        add("yiyi")
    }
    map[1] = list1

    var list2 = mutableListOf<String>().apply {
        add("wawa")
        add("dada")
        add("haha")
    }
    map[2] = list2

    var triple = Triple<String, String, Int>("alfred", "nan", 1)
    var pair = Pair<String, Int>("thoma", 21)
    for (entry in map) {
        println("${entry.key}--->${entry.value}")
    }

    var mapOf: Map<Int, String> = mapOf<Int,String>(Pair(1, "A"), Pair(2, "wawa"))
    for (entry in mapOf) {
        println("${entry.key}--->${entry.value}")
    }


}