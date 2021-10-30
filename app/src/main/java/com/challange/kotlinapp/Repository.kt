package com.challange.kotlinapp

import org.json.JSONObject
import org.json.JSONTokener
import java.net.URL

class Repository {

    fun getData():List<EventDataClass>{
        val result = URL(uri).readText()

        val body = JSONTokener(result).nextValue() as JSONObject
        val array = body.getJSONArray("data")
        val newOutput = mutableListOf<EventDataClass>()

        for(i in 0 until array.length()){
            val item = array.getJSONObject(i)

            val name = item.getString("name")
            val date = item.getString("startDate")
            val row = EventDataClass(name, date)
            newOutput.add(row)
        }

        return newOutput.toList()
    }

    companion object {
        const val uri = "https://guidebook.com/service/v2/upcomingGuides/"
    }
}