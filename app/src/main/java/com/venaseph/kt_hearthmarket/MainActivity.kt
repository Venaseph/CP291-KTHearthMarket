package com.venaseph.kt_hearthmarket

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recView_main.setBackgroundColor(Color.BLUE)
        recView_main.layoutManager = LinearLayoutManager(this)
        recView_main.adapter = MainAdapter()

    }
}