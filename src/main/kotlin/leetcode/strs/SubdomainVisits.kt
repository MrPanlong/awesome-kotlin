package leetcode.strs

fun subdomainVisits(cpdomains:Array<String>):List<String>{
    val ans = mutableListOf<String>()
    val counts = mutableMapOf<String, Int>()
    for (cpdomain in cpdomains) {
        val space = cpdomain.indexOf(' ')
        val count = cpdomain.substring(0, space).toInt()
        val domain = cpdomain.substring(space + 1)
        counts[domain] = counts.getOrDefault(domain,0)+count
        for (i in 0 until domain.length) {
            if (domain[i] == '.'){
                val subdomain = domain.substring(i + 1)
                counts[subdomain] = counts.getOrDefault(subdomain,0)+count
            }
        }
    }
    for (entry in counts.entries) {
        val subdomain = entry.key
        val count = entry.value
        val res = StringBuilder()
                .append(count)
                .append(" ")
                .append(subdomain)
                .toString()
        ans.add(res)
    }
    return ans
}

fun main(args: Array<String>) {
    var cpdomains = arrayOf("9001 discuss.leetcode.com")
    var res = subdomainVisits(cpdomains)
    println(res)
}