package example.test

/**
 * @ClassName: VarDecla
 * @Date: 2023/3/12 16:56
 * @Author: panLong
 * @Description: TODO
 */
class LambdaToVariableTest {
    var name: String? = null
    private val base = 10
    val sum = { x: Int, y: Int, z: Int -> x + y + z + base }
}

fun main(args: Array<String>) {
    var name = "keke"
    val test = LambdaToVariableTest()
    println(test.sum(12, 10, 200))


    var str: String? = null
    //村民一：使用age
    //TODO 第一种补救措施 age 如果真的为null 后面不执行 就不会引发空指针异常

    var length = str?.length
    //TODO 第二种补救措施 无论str是不是null 都执行
    //var length1 = str!!.length
    println(length)

    //TODO 第二种补救措施
    if (str != null) {
        var length2 = str.length
        print(length2)
    }

    //可读 不可改
    val age: String = "keke"
    val info = "hehe"

    val gender: String = "nan"

    val add1 = add1(1, 2)
    println(add1)


    val number = 148


    val test01 = test01(23, "keke")
    println(test01)


    var valid: Boolean = isValid("[]")
    print("hello")
    println(valid)
    print("world")
}

fun add1(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun add2(num1: Int, num2: Int) = num1 + num2

fun add3(num3: Int) = num3 * num3

fun add4() = "num4"

private fun test01(age: Int, name: String): String {
    val str = "你的姓名是：${name},你的年龄是${age}"
    return str
}

private fun isValid(s: String): Boolean {
    var s = s
    if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
        if (s.contains("()")) {
            s.replace("()", "");
        }
        if (s.contains("{}")) {
            s.replace("{}", "")
        }
        if (s.contains("[]")) {
            s.replace("[]", "")
        }
    }
    return s.isEmpty()
}