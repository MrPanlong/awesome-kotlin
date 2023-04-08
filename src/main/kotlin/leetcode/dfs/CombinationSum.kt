package leetcode.dfs

/**
 *
 *@author panlong
 *@date 2023/4/8
 */
fun combinationSum(candidates:IntArray,target: Int):List<List<Int>>{
    var len = candidates.size
    var res = mutableListOf<List<Int>>()
    var path = mutableListOf<Int>()
    dfs(candidates,target,0,path,res)
    return res
}

private fun dfs(candidates: IntArray, target: Int, start: Int, path: MutableList<Int>, res: MutableList<List<Int>>) {
    if (target == 0){
        res.add(path.toList())
        return
    }
    for (i in start until candidates.size) {
        if (target - candidates[i] < 0){
            continue
        }
        path.add(candidates[i])
        dfs(candidates,target - candidates[i],i,path,res)
        path.removeAt(path.size - 1)
    }
}
