package com.challange.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = Repository()
        val events = repo.getData()
        val displayEvents: List<String> = events.map { it.guideBookName + "\n" + it.startDate }
        val arrayAdapter: ArrayAdapter<*>
        val mListView = findViewById<ListView>(R.id.list_vew)
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, displayEvents
        )
        mListView.adapter = arrayAdapter
    }
}