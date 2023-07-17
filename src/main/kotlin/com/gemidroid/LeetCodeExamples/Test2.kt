import com.gemidroid.LeetCodeExamples.factorial
import com.gemidroid.LeetCodeExamples.fibonacci
import com.gemidroid.LeetCodeExamples.test
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.swing.tree.TreeNode


data class Data(val title: String? = null, val story_title: String? = null)
data class DataList(
    val per_page: Int = 1, val data: List<Data>? = emptyList()
)

/**
 *  UBS assessment...
 */
fun getArticleTitles(author: String): Array<String> {
    var page = 1
    var endPage = 1 // assume at least has only page as a default, then increment depend on @per_page value...
    val articleTitles = mutableListOf<String>()
    while (page <= endPage) {
        val url = URL("https://jsonmock.hackerrank.com/api/articles?author=$author&page=$page")
        println(url)
        val request = url.openConnection() as HttpURLConnection
        request.apply {
            requestMethod = "GET"
        }
        val responseCode = request.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            val inReader = BufferedReader(InputStreamReader(request.inputStream))
            val stringJson = StringBuilder()
            var inputLine: String? = ""
            while (inReader.readLine()?.run { inputLine = this } != null) {
                stringJson.append(inputLine)
            }
            inReader.close()
            val gsonData = fromJson<DataList>(stringJson.toString())
            val items = gsonData.data
            endPage = gsonData.per_page
            println(items)
            items?.filter { it.title != null || it.story_title != null }?.forEach {
                articleTitles.add(it.title ?: it.story_title!!)
            }
        }
        page++
    }
    return articleTitles.toTypedArray()
}

// LeetCode #Hard...
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val mergedList = nums1.plus(nums2).sorted()
    val median = if (mergedList.size % 2 != 0)
        mergedList[mergedList.size / 2].toDouble()
    else {
        val beforeMid = ((mergedList.size - 1) / 2)
        ((mergedList[beforeMid] + mergedList[beforeMid + 1]).toDouble() / 2)
    }
    return median
}

fun reverse(x: Int): Int {
    var newX = x.toString()
    if (newX.startsWith("-")) {
        newX = newX.replace("-", "")
        return (newX.reversed().toIntOrNull() ?: 0) * -1
    }
    return newX.reversed().toIntOrNull() ?: 0
}

fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
    root?.childCount?.let {
        if (k > it)
            return emptyList()
    }
    return emptyList()
}


fun checkIfPangram(sentence: String): Boolean {
    val sentenceSet = mutableSetOf<Char>()
    for (i in sentence) {
        sentenceSet.add(i)
    }
    return 26 == sentenceSet.size
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val complement = hashMapOf<Int, Int>()
    nums.forEachIndexed { k, i ->
        val compIndex = complement[i]
        if (compIndex != null) {
            return intArrayOf(compIndex, k)
        }
        complement[target - i] = k
    }
    return intArrayOf(0, 0)
}

fun main() {
    /*val result = getArticleTitles("epaga")

    println(result.joinToString("\n"))*/
    /* findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))
     println(reverse(-2147483648))*/

    //println(distanceK(TreeNode))
    // print(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
    /* twoSum(intArrayOf(4, 2, 8, -2), 6).map {
      //   println(it)
     }*/
    /*println(factorial(5))
    println(fibonacci(70))*/
    //  println(singleNumber(intArrayOf(1, 2, 3, 4, 4, 3, 1)))
    // findDifference(intArrayOf(1, 2, 3, 3), intArrayOf(1, 1, 2, 2))
   // println(compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')))
}

/*fun compress(chars: CharArray): Int {
    val list = mutableSetOf<String>()
    var count = 0
    for (i in chars) {
        if(list.contains(i))
            count++
        list.add(i.toString())
        list.add(count.toString())
    }
    println(list)
    return list.size
}*/

fun singleNumber(nums: IntArray): Int {
    nums.forEach { item ->
        val counter = nums.count { it == item }
        if (counter == 1)
            return item
    }
    return -1
}

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val mutList = mutableListOf<List<Int>>()
    val num1 = nums1.toMutableSet()
    val num2 = nums2.toMutableSet()
    for (i in nums1) {
        if (nums2.contains(i)) {
            num1.remove(i)
            num2.remove(i)
            mutList.add(num1.toMutableList())
            mutList.add(num2.toMutableList())
        }
    }
    val uniqueList = mutList.ifEmpty {
        mutList.apply {
            add(num1.toMutableList())
            add(num2.toMutableList())
        }
    }
    println(uniqueList.takeLast(2))
    return uniqueList
}

private inline fun <reified T> fromJson(json: String): T = Gson().fromJson(json, T::class.java)
