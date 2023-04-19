package leetcode

/**
 *
 *@author panlong
 *@date 2023/4/3
 */
open class IsPalindrome {
    fun isPalindrome(number: Int): Boolean {
        var isPalindromeNumber = false
        var sum = 0
        var tempNum = number
        while (tempNum > 0) {
            val r = tempNum % 10
            sum = sum * 10 + r
            tempNum /= 10
        }
        if (sum == number) {
            isPalindromeNumber = true
        }
        return isPalindromeNumber
    }
}