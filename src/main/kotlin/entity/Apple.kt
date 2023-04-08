package entity

import java.math.BigDecimal

/**
 * @ClassName: Apple
 * @Date: 2023/3/7 22:23
 * @Author: panLong
 * @Description: TODO
 */

data class Apple(var id: Int?, var name: String?, var money: BigDecimal?, var num: Int?) {
    constructor() : this(null, null, null, null)
    fun getMe() = this
    fun getMoney() = money!!.toDouble()
}
