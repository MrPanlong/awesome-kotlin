package tests

import entity.Apple
import java.math.BigDecimal
import java.util.stream.Collectors

/**
 * @ClassName: DemoTest
 * @Date: 2023/3/7 22:24
 * @Author: panLong
 * @Description: TODO
 */



fun main(args: Array<String>) {
    var arrayList = ArrayList<Apple>()
    var apple1 = Apple(1, "苹果1", BigDecimal("3.25"), 10)
    val apple2 = Apple(1, "苹果2", BigDecimal("1.35"), 20)
    val apple3 = Apple(2, "香蕉", BigDecimal("2.67"), 30)
    val apple4 = Apple(3, "葡萄", BigDecimal("7.87"), 40)

    arrayList.add(apple1)
    arrayList.add(apple2)
    arrayList.add(apple3)
    arrayList.add(apple4)

    arrayList.also { println("Java Stream") }.stream()
            .collect(Collectors.groupingBy(Apple::id))
            .forEach{(t,u) -> println("\t\t $t -> $u")}
    println("============================")
    arrayList.also { println("kotlin stream") }.groupBy(Apple::id, Apple::getMe)
            .forEach{(t,u) -> println("\t\t$t - > $u") }

    arrayList.also { println("去重") }.distinctBy { it.id }.forEach{print("\t\t$it")}
}