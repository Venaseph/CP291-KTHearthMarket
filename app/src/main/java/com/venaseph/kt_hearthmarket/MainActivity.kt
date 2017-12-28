package com.venaseph.kt_hearthmarket

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView_main.layoutManager = LinearLayoutManager(this)

        fetchJson()

    }

    private fun fetchJson() {
        //println("Attempting to Fetch JSON")
        //for API key
        val keyVal = "mSCkyyFuiMmshxkH3QTA6RsLglGGp1GG15ajsnJdGUUoajgNgt"
        // for API location
        val url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards"
        // make request object
        val request = Request.Builder().header("X-Mashape-Key", keyVal).url(url).build()
        //make request client
        val client = OkHttpClient()
        //create request (can't execute http requests on main thread in android so enqueue
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()

                val gson = GsonBuilder().create()
                    // to pass type of class to kotlin ::
                val cardFeed = gson.fromJson(body, CardFeed::class.java)

                runOnUiThread {
                    recView_main.adapter = MainAdapter(cardFeed)
                }

            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }
}

//model object for feed, public as suggested GSON library vals must match JSON objects key names
class CardFeed(val Basic: List<Card>)
class Card(val name: String, val text: String, val flavor: String, val imgGold: String)
//each subsection[] would go as a "subclass here and get referenced in class model above