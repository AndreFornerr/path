package com.dedemolu.path.utils

import android.util.Log
import com.dedemolu.path.data.model.Book
import com.google.gson.Gson
import java.io.InputStream
import java.lang.Exception

class RetriviedData {

    companion object {
        fun dataBooksFromJson(inputStream: InputStream): List<Book> {
            val gson = Gson()
            try {
                val inputString: String = inputStream.bufferedReader().use { it.readText() }
                return gson.fromJson(inputString, Array<Book>::class.java).toList()
            } catch (e: Exception) {
                Log.d("Exception: ", e.toString())
            }
            return listOf()
        }
    }

}