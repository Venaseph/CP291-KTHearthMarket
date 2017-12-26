package com.venaseph.kt_hearthmarket

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

//should be separate kt file
class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    // numberOfItems
    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        //return View/Cell inside this method
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardimg_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {

    }
}

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v) {

}