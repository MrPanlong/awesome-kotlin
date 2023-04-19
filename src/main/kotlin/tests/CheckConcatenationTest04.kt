package tests

import leetcode.strs.CheckConcatenation

fun main(args: Array<String>) {

    var checkConcatenation: CheckConcatenation = CheckConcatenation()
    var aStr = "abdef"
    var bStr = "fecab"
    var flag: Boolean = checkConcatenation.checkPalindromeFormation(aStr, bStr)

    println("flag = $flag")

}