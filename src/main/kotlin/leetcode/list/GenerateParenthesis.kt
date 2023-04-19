package leetcode

class GenerateParenthesis {
    fun generateParenthesis(n: Int): List<String> {
        val result: MutableList<String> = mutableListOf<String>()
        backup("(", n - 1, n, result)
        return result
    }

    private fun backup(s: String, numStart: Int, numEnd: Int, result: MutableList<String>) {
        if (numStart == 0 && numEnd == 0) {
            result.add(s)
        } else {
            when {
                numEnd == numStart -> {
                    backup("$s(", numStart - 1, numEnd, result)
                }
                else -> {
                    if (numStart > 0) {
                        backup("$s)", numStart, numEnd - 1, result)
                    }
                }
            }
        }
    }
}
