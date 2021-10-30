package com.challange.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import java.lang.Exception
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<ListView>(R.id.list_vew)


        val repo = Repository();
        try {
            val events = repo.getData();
            val displayEvents:List<String> = events.map { it.guideBookName + "\n" + it.startDate}
            val arrayAdapter: ArrayAdapter<*>
            var mListView = findViewById<ListView>(R.id.list_vew)
            arrayAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, displayEvents)
            mListView.adapter = arrayAdapter

        } catch (e:Exception){
            var x = e.message;

        }
    }
}