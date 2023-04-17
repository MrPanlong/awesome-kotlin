package leetcode.strs


class CheckConcatenation{
    fun checkPalindromeFormation(a:String,b:String) : Boolean{
        return checkConcatenation(a,b) || checkConcatenation(b,a)
    }

    private fun checkConcatenation(a: String, b: String): Boolean {
        var n = a.length
        var left = 0
        var right = n - 1
        while (left < right && a[left] == b[right]) {
            left += 1
            right -= 1
        }
        if (left >= right){
            return true
        }
        return checkSelfPalindrome(a,left,right) || checkSelfPalindrome(b,left,right)
    }

    private fun checkSelfPalindrome(a: String, left: Int, right: Int): Boolean {
        var l = left
        var r = right
        while (left < right && a[left] == a[right]) {
            l += 1
            r -=1
        }
        return l >= r
    }


}