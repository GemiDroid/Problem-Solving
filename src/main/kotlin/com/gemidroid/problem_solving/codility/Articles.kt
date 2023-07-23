package com.gemidroid.problem_solving.codility

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

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

private inline fun <reified T> fromJson(json: String): T = Gson().fromJson(json, T::class.java)

data class Data(val title: String? = null, val story_title: String? = null)
data class DataList(
    val per_page: Int = 1, val data: List<Data>? = emptyList()
)