package com.dedemolu.path.utils

import android.content.Context
import android.util.Log
import com.dedemolu.path.data.model.Book
import com.dedemolu.path.data.model.Chapter
import com.dedemolu.path.data.model.Point
import com.google.gson.Gson
import java.lang.Exception

class RetriviedData(
    private val context: Context
) {

    private val gson = Gson()

    private fun getBooksFromJson(): List<Book> {
        try {
            return gson.fromJson(readFromJson("books.json"), Array<Book>::class.java).toList()
        } catch (e: Exception) {
            Log.d("Exception: ", e.toString())
        }
        return listOf()
    }

    private fun getPointsFromJson(): List<Point> {
        try {
            return gson.fromJson(readFromJson("points.json"), Array<Point>::class.java).toList()
        } catch (e: Exception) {
            Log.d("Exception: ", e.toString())
        }
        return listOf()
    }

    private fun getChaptersFromJson(): List<Chapter> {
        try {
            return gson.fromJson(readFromJson("chapters.json"), Array<Chapter>::class.java).toList()
        } catch (e: Exception) {
            Log.d("Exception: ", e.toString())
        }
        return listOf()
    }

    private fun readFromJson(fileName: String): String {
        val inputStream = context.assets.open(fileName)
        return inputStream.bufferedReader().use { it.readText() }
    }

    fun loadAllObjectsFromJson(): List<Book> {
        getChaptersFromJson()
        getPointsFromJson()
        return getBooksFromJson()
    }


}