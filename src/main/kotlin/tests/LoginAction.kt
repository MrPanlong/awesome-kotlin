package tests

fun main(args: Array<String>) {
    //用户登录
    val res: Int = loginAction("keke", "12", { if (it) println("登录成功") else print("登录失败") })
    println(res)
}

fun loginAction(userName:String,password:String,loginResponseResult:(Boolean) -> Unit):Int{
    return loginEngine(userName,password,loginResponseResult)
}

fun loginEngine(userName: String, password: String, loginResponseResult: (Boolean) -> Unit):Int {
    if (("keke" == userName) && ("12" == password)){
        loginResponseResult(true)
    }else{
        loginResponseResult(false)
    }
    return 1
}
