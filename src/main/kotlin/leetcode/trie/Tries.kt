package leetcode.trie

import java.util.*

class Tries {
    var size: Int = 0
    var root: Node = Node()

    inner class Node constructor(var isWord: Boolean = false) {
        var next: TreeMap<Char, Node> = TreeMap()
    }

    fun insert(word: String) {
        var cur: Node = root
        for (c in word.toCharArray()) {
            if (cur.next[c] == null) {
                cur.next[c] = Node()
            }
            cur = cur.next[c]!!
        }
        if (!cur.isWord) {
            cur.isWord = true
            this.size++
        }
    }

    fun search(word: String): Boolean {
        var cur: Node = root
        for (c in word.toCharArray()) {
            if (cur.next[c] == null) {
                return false
            }
            cur = cur.next[c]!!
        }
        return cur.isWord
    }

    fun startsWith(word: String): Boolean {
        var cur: Node = root
        for (c in word.toCharArray()) {
            if (cur.next[c] == null) {
                return false
            }
            cur = cur.next[c]!!
        }
        return true
    }
}