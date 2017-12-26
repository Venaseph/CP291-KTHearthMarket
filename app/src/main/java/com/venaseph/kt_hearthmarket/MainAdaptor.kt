package com.venaseph.kt_hearthmarket

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cardimg_row.view.*

/**
 * Created by cpera on 12/26/2017.
 */

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    private val cardTitle = listOf<String>("Carniv Cube", "Second Card", "Third Card", "Fourth Card", "Fifth Card", "Sixth Card", "Seventh Card")

    // numberOfItems
    override fun getItemCount(): Int {
        return cardTitle.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        //return View/Cell inside this method
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardimg_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val cardTitles = cardTitle.get(position)

        holder?.view?.titleView?.text = cardTitles


    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}