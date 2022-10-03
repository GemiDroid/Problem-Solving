fun main(){
    println(findClosestElements(intArrayOf(1,2,3,9,11), 4, 3))
}
fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    val sortedList = arr.sorted().toList()
    if (arr.size == 1) return arr.toList()
    if (k >= 1 && k <= arr.size && sortedList.size <= Math.pow(10.0, 4.0)) {
        val matchedItem = sortedList.find { it == k } ?: return emptyList()
        val indexedKeyItem = sortedList.indexOf(matchedItem)
        val indexedXItem = sortedList.indexOf(x)
        arr.forEach{ _ ->
            if(indexedKeyItem - indexedXItem == 1)
                return  sortedList.subList(0, sortedList[x])

        }
    }
    return sortedList
}