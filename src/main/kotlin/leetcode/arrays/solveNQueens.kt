package leetcode.arrays


class SolveNQueens{
    lateinit var result:MutableList<List<String>>
    fun solveNQueens(n:Int):List<List<String>>{
        if (n <=0) return listOf(emptyList())
        if (n==1) return List(1){ List(1){"Q"}}
        result = mutableListOf<List<String>>()
        var list = List(n) { List(n) { 0 } }
        (0 until n).forEach{i ->
            getList(0,i,list)
        }
        return result
    }

    private fun getList(x: Int, y: Int, list: List<List<Int>>) {
        if (x > list.size - 1)return
        if (list[x][y] != 0) return
        if (x == list.size - 1){
            var current = mutableListOf<String>()
            list.mapIndexed{index,list->
                if (index == x) list.mapIndexed{index, i ->
                    if (index == y) 1
                    else i
                }
                else list
            }.forEach { item ->
                current.add(item.joinToString(separator = ""){
                    if (it== 1) "Q"
                    else "."
                })
            }
            result.add(current)
            return
        }
        (list.indices).forEach{i ->
            val currentList = list.mapIndexed{indexX,list ->
                if (indexX == x)
                    List(list.size){i -> if (i == y) 1 else 2}
                else
                    list.mapIndexed{indexY,number ->
                        if (indexY == y) 2
                        else{
                            val row = if (indexX > x){
                                indexX - x
                            }else{
                                x - indexX
                            }
                            val col = if (indexY > y){
                                indexY - y
                            }else{
                                y - indexY
                            }
                            if (row == col) 2
                            else number
                        }
                    }
            }
            getList(x + 1,i, currentList)
        }
    }
}