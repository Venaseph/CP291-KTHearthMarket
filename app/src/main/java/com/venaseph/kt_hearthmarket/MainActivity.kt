package com.venaseph.kt_hearthmarket

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recView_main.setBackgroundColor(Color.BLUE)
        recView_main.layoutManager = LinearLayoutManager(this)
        recView_main.adapter = MainAdapter()

        fetchJson()

    }

    private fun fetchJson() {
        //println("Attempting to Fetch JSON")

        val keyVal = "mSCkyyFuiMmshxkH3QTA6RsLglGGp1GG15ajsnJdGUUoajgNgt"
        val url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards"
        // make request object
        val request = Request.Builder().header("X-Mashape-Key", keyVal).url(url).build()
        //make request client
        val client = OkHttpClient()
        //create request (can't execute http requests on main thread in android so enqueue
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })

    }
}